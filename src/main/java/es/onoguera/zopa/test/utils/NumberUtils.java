package es.onoguera.zopa.test.utils;

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
}
