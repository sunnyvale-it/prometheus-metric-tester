package it.sunnyvale.metrictester.controllers;


import it.sunnyvale.metrictester.model.MetricData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v2/test")
public class MetricTesterController {
    @Value("${meter.initial.value}")
    private MetricData ;

    @RequestMapping( method = RequestMethod.POST)
    public


}
