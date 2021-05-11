package it.sunnyvale.metrictester.prometheus;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;
import it.sunnyvale.metrictester.services.DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.management.monitor.GaugeMonitorMBean;

@Component
public class PrometheusExporter {



    @Autowired
    private DataProvider dataProvider;

    @PostConstruct
    public void init(){
        Gauge gauge = Gauge
                .builder("value_gauge", dataProvider, DataProvider::getValue)
                .description("")
                .register(Metrics.globalRegistry);
    }

}
