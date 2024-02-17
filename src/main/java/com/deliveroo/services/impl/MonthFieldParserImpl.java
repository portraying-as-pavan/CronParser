package com.deliveroo.services.impl;

import com.deliveroo.exceptions.InvalidFieldException;
import com.deliveroo.services.MonthFieldParser;
import com.deliveroo.utils.CronParserUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MonthFieldParserImpl implements MonthFieldParser {

    private final int MIN=1;
    private final int MAX=12;
    @Override
    public List<String> parseField(String field) throws InvalidFieldException {

       return CronParserUtil.parseNumericalField(field,MIN,MAX);
    }
}
