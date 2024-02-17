package com.deliveroo.services.impl;

import com.deliveroo.exceptions.InvalidFieldException;
import com.deliveroo.services.DayFieldParser;
import com.deliveroo.utils.CronParserUtil;

import java.util.Arrays;
import java.util.List;

public class DayFieldParserImpl implements DayFieldParser {

    private final int MIN=1;
    private final int MAX= 31;
    @Override
    public List<String> parseField(String field) throws InvalidFieldException {

        return CronParserUtil.parseNumericalField(field,MIN,MAX);
    }
}
