package it.sunnyvale.metrictester;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;

@EnablePrometheusMetrics  //scraping solutions to multiple calls in thread under /prometheus registry
//it also apply @EnablePrometheusScraping enabling /prometheus (irrelevant?)
//@EnableAtlasMetrics  scraping based on metrics in actuator
@SpringBootApplication
public class MetricTesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(MetricTesterApplication.class, args);
    }


}
