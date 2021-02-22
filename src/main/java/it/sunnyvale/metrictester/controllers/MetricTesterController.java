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
@RequestMapping(value = "/v2/test")
public class MetricTesterController {

    @Autowired
    private DataProvider dataProvider;

    @RequestMapping( value = "/updateData", method = RequestMethod.POST)
    public MetricData updateData(@RequestBody MetricData inputData){
        return dataProvider.updateData(inputData);
    }

    @RequestMapping( value = "/testValue", method = RequestMethod.GET)
    public MetricData getData(){
        return dataProvider.getData();
    }


}
