package it.sunnyvale.metrictester.controllers;


import it.sunnyvale.metrictester.model.MetricData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/v2/test")
public class MetricTesterController {

    @Value("${meter.initial.value}")
    private int initialValue;
    private MetricData data ;

    @RequestMapping( value = "/updateData", method = RequestMethod.POST)
    public MetricData updateData(@RequestBody MetricData inputData){
        data.setValue(inputData.getValue());
        return data;
    }


}
