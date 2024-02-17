package com.deliveroo.util;

import com.deliveroo.exceptions.InvalidFieldException;
import com.deliveroo.utils.CronParserUtil;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

public class CronParserUtilTest {


    @Test
    public void testAnyValueParser() throws InvalidFieldException {
        String testCronExpression="*";
        int min=0, max=10;
        int expectedSize=11;
       List<String> actual= CronParserUtil.parseNumericalField(testCronExpression,min,max);
       assertNotNull(actual);
        assert(actual.size()==expectedSize);
    }

    @Test
    public void testCommaSeperatedExpressionParser() throws InvalidFieldException {
        String testCronExpression="1,2";
        int min=0, max=10;

        List<String> actual= CronParserUtil.parseNumericalField(testCronExpression,min,max);
        assertNotNull(actual);

        assert(actual.contains("1") && actual.contains("2"));
    }

    @Test
    public void testValueRangeParser() throws InvalidFieldException {
        String testCronExpression="1-10";
        int min=0, max=10;
        int expectedSize=10;
        List<String> actual= CronParserUtil.parseNumericalField(testCronExpression,min,max);
        assertNotNull(actual);
        assert(actual.size()==expectedSize);
    }

    @Test
    public void testChainedExpressionParser() throws InvalidFieldException {
        String exp1 ="1-5,8";
        String exp2="5,6-10";
        int min=0, max=10;
        int expectedSize =6;
        List<String> actual1 = CronParserUtil.parseNumericalField(exp1,min,max);
        List<String> actual2 = CronParserUtil.parseNumericalField(exp2,min,max);
        assertNotNull(actual1);
        assertNotNull(actual2);
        assert(actual1.size()== expectedSize && actual2.size()==expectedSize);
    }
    @Test
    public void testInvalidFieldValueException() {
        String testCronExpression="1-a";
        int min=0, max=10;
        assertThrows(InvalidFieldException.class, () -> CronParserUtil.parseNumericalField(testCronExpression,min,max));
    }
}
