package it.sunnyvale.metrictester.model;


import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
//@Scope("singleton")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MetricData {

    private int value;


}
