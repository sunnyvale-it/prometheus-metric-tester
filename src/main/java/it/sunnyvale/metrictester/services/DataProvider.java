package it.sunnyvale.metrictester.services;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.replicatedmap.ReplicatedMap;
import it.sunnyvale.metrictester.model.MetricData;
import lombok.Data;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Service
@Scope("singleton")
public class DataProvider {

    @Value("${meter.initial.value}")
    private int initialValue;

    HazelcastInstance hz;
    ReplicatedMap<Object,MetricData> map;

    @PostConstruct
    private void init(){
        hz = Hazelcast.newHazelcastInstance();
        map = hz.getReplicatedMap("value");
        MetricData metricData = map.get("metricData");
        if(metricData==null){
            metricData = new MetricData();
            metricData.setValue(initialValue);
            map.put("metricData",metricData);
        }
    }

    @Synchronized
    public void updateValue(MetricData inputData) {
        map.replace("metricData", inputData);
    }

    public MetricData getData(){
        return map.get("metricData");
    }

    public double getValue(){
        return map.get("metricData").getValue();
    }


}
