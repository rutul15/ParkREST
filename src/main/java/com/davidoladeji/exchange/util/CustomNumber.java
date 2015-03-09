package com.davidoladeji.exchange.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Daveola on 2/22/2015.
 */
public class CustomNumber {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
