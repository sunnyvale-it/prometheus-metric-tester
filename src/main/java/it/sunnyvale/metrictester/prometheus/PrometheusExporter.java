package it.sunnyvale.metrictester.prometheus;

import io.prometheus.client.Gauge;
import it.sunnyvale.metrictester.model.MetricData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;

public class PrometheusExporter {

    @Value("${meter.initial.value}")
    private int initialValue;

    @Autowired
    private MetricData data;

    @PostConstruct
    public void init(){
        // todo inserire codice per creare server
    }

    static final Gauge valueGauge = Gauge.build()
            .name("inprogress_requests").help("Inprogress requests.").register();

    void processRequest() {
        // processare il dato  valueGauge....
    }
}
