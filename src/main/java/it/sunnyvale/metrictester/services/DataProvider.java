package it.sunnyvale.metrictester.services;

import it.sunnyvale.metrictester.model.MetricData;
import lombok.Data;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Data
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

    @Synchronized
    public MetricData updateValue(MetricData inputData) {
        data.setValue(inputData.getValue());
        return data;
    }

    public MetricData getValue(){
        return data;
    }

}
