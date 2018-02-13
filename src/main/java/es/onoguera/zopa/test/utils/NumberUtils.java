package es.onoguera.zopa.test.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;

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
    public static String round(double d, Integer decimalPlace) {
        DecimalFormat df = new DecimalFormat("#." + StringUtils.left("0", decimalPlace));
        return df.format(d);
    }

}
