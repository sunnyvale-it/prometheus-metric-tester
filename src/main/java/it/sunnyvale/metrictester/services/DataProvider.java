package it.sunnyvale.metrictester.services;

import it.sunnyvale.metrictester.model.MetricData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataProvider {

    @Value("${meter.initial.value}")
    private int initialValue;

    @Autowired
    private MetricData data;

    @PostConstruct
    public void init(){
        data.setValue(initialValue);
    }

    public DataProvider(){

    }

    public MetricData updateData(MetricData metricData){
        data.setValue(metricData.getValue());
        return data;
    }

    public MetricData getData(){
        return data;
    }

}
