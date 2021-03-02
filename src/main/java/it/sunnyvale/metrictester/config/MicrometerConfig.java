package it.sunnyvale.metrictester.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MicrometerConfig {

    @Bean
    MeterRegistryCustomizer meterRegistryCustomizer(MeterRegistry meterRegistry){
        return meterRegistry1 ->{
            meterRegistry.config().commonTags("application", "micrometer-testing");
        };

        //Map<Integer, Person> people = new Map<Integer, Person>();  create a map to monitor
        //registry.mapSize("population", people);   gauge to monitor the size of the map

        //registry.counter("threadpool_size", "id", "server_requests") the total number of threads in all pools.
        //registry.counter("db_size", "table", "users") group by or select an id to drill down further comparative analysis on each area to the number of threads

        // register a counter of questionable usefulness
        //steveCounter = registry.counter("find_steve", /* optional tags here */);  example

        // register a timer -- though for request timing it is easier to use @Timed
        //findPersonTimer = registry.timer("http_requests", "method", "GET");     example

    }

}
