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

    //@Timed creates a Timer time series named http_server_requests which by default contains dimensions for the HTTP status, method, exception
    //${name}_count - Total number of all calls
    //${name}_sum - Total time of all calls
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

    /*
            return findPersonTimer.record(() -> { // use the timer!
            if (q.toLowerCase().contains("steve")) {
                steveCounter.increment(); // use the counter
            }

            return people.stream().filter(p ->  etc ).findAny().orElse(null);

    Meters.monitor(
                registry,
                dataSource,
                metadataProviders,
                "data_source", // base metric name
                "stack", env.acceptsProfiles("prod") ? "prod" : "test", // <- any number of tags
        );

     */


}
