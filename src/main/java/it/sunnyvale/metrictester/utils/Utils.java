package it.sunnyvale.metrictester.utils;

import it.sunnyvale.metrictester.model.MetricData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Utils {


    // returns true if the trend is decreasing
    public static boolean isDownward(int value){

        return false;
    }

    // returns true if the trend is rising
    public static boolean isUpward(){

        return false;
    }


}
