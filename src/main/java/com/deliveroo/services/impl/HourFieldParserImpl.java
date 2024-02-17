package com.deliveroo.services.impl;

import com.deliveroo.exceptions.InvalidFieldException;
import com.deliveroo.services.HourFieldParser;
import com.deliveroo.utils.CronParserUtil;

import java.util.Arrays;
import java.util.List;

public class HourFieldParserImpl implements HourFieldParser {
    private final int MIN=0;
    private final int MAX=24;
    @Override
    public List<String> parseField(String field) throws InvalidFieldException {
        return CronParserUtil.parseNumericalField(field,MIN,MAX);
    }
}
