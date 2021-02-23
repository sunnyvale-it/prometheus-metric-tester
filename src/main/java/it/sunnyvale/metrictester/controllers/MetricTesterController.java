package it.sunnyvale.metrictester.controllers;


import io.micrometer.core.annotation.Timed;
import it.sunnyvale.metrictester.model.MetricData;
import it.sunnyvale.metrictester.prometheus.PrometheusExporter;
import it.sunnyvale.metrictester.services.DataProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/api/v2")
public class MetricTesterController {

    @Autowired
    private DataProvider dataProvider;

    @Autowired
    private PrometheusExporter prometheusExporter;

    @Timed(value = "updatedValue.MetricData.request", histogram = true, extraTags = {"version", "1.0"}, percentiles = {0.95, 0.99})
    @RequestMapping( value = "/updateValue", method = RequestMethod.POST)
    public MetricData updateValue(@RequestBody MetricData inputData){
        return dataProvider.updateValue(inputData);
    }

    @Timed(value = "getValue.MetricData.request", histogram = true, extraTags = {"version", "1.0"}, percentiles = {0.95, 0.99})
    @RequestMapping( value = "/getValue", method = RequestMethod.GET)
    public MetricData getValue(){
        return dataProvider.getValue();
    }


}
