package it.sunnyvale.metrictester.prometheus;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;
import it.sunnyvale.metrictester.services.DataProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PrometheusExporter {

    @Value("${meter.initial.value}")
    private int initialValue;

    @Autowired
    private DataProvider dataProvider;

    private Gauge valueGauge;

    @PostConstruct
    public void init(){
        dataProvider.getData().setValue(initialValue);
        valueGauge = Gauge.builder("value_gauge", dataProvider.getData(), data -> data.getValue()).strongReference(true).description("value gauge").register(Metrics.globalRegistry);
    }

}
