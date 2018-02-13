package es.onoguera.zopa.test.utils;

import org.junit.Assert;
import org.junit.Test;

public class NumberUtilsTest {

    @Test
    public void isIntegerNonNumberTest(){
        Assert.assertFalse("isIntegerNonNumberTest", NumberUtils.isInteger("test"));
    }

    @Test
    public void isIntegerFloatNumberTest(){
        Assert.assertFalse("isIntegerFloatNumberTest", NumberUtils.isInteger("2.2"));
    }

    @Test
    public void isIntegerNullStringTest(){
        Assert.assertFalse("isIntegerNullStringTest", NumberUtils.isInteger(null));
    }

    @Test
    public void isIntegerHappyPathTest(){
        Assert.assertTrue("isIntegerHappyPathTest", NumberUtils.isInteger("6"));
        Assert.assertTrue("isIntegerHappyPathTest", NumberUtils.isInteger("0"));
        Assert.assertTrue("isIntegerHappyPathTest", NumberUtils.isInteger("-6"));
    }

    @Test
    public void isPositiveIntegerNonNumberTest(){
        Assert.assertFalse("isPositiveIntegerNonNumberTest", NumberUtils.isPositiveInteger("test"));
    }

    @Test
    public void isPositiveIntegerFloatNumberTest(){
        Assert.assertFalse("isPositiveIntegerFloatNumberTest", NumberUtils.isPositiveInteger("2.2"));
    }

    @Test
    public void isPositiveIntegerNullStringTest(){
        Assert.assertFalse("isPositiveIntegerNullStringTest", NumberUtils.isPositiveInteger(null));
    }

    @Test
    public void isPositiveIntegerNegativeIntenerTest(){
        Assert.assertFalse("isPositiveIntegerNegativeIntenerTest", NumberUtils.isPositiveInteger(null));
    }

    @Test
    public void isPositiveIntegerHappyPathTest(){
        Assert.assertTrue("isPositiveIntegerHappyPathTest", NumberUtils.isPositiveInteger("6"));
        Assert.assertTrue("isPositiveIntegerHappyPathTest", NumberUtils.isPositiveInteger("0"));

    }

}
