package es.onoguera.zopa.test.utils;

import java.math.BigDecimal;

public final class NumberUtils {

    private NumberUtils() {

    }


    public static boolean isPositiveInteger(String number) {
        boolean isPositiveInteger = false;
        try {
            Integer value = Integer.parseInt(number);
            if (value >= 0) {
                isPositiveInteger = true;
            }
        } catch (NumberFormatException | NullPointerException e) {
        }
        return isPositiveInteger;
    }

    public static boolean isInteger(String number) {
        boolean isInteger = false;
        try {
            Integer.parseInt(number);
            isInteger = true;
        } catch (NumberFormatException | NullPointerException e) {
        }
        return isInteger;
    }

    /**
     * Round to certain number of decimals
     *
     * @param d
     * @param decimalPlace
     * @return
     */
    public static double round(double d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Double.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }
}
