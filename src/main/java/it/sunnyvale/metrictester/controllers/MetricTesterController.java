package it.sunnyvale.metrictester.controllers;


import it.sunnyvale.metrictester.model.MetricData;
import it.sunnyvale.metrictester.services.DataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@Slf4j
@RestController
@RequestMapping(value = "/api/v2")
public class MetricTesterController {

    @Autowired
    private DataProvider dataProvider;

    @RequestMapping( value = "/updateValue", method = RequestMethod.POST)
    public MetricData updateValue(@RequestBody MetricData inputData){
        return dataProvider.updateValue(inputData);
    }

    @RequestMapping( value = "/getValue", method = RequestMethod.GET)
    public MetricData getValue(){
        return dataProvider.getValue();
    }


}
