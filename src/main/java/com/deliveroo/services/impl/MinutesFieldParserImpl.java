package com.deliveroo.services.impl;

import com.deliveroo.exceptions.InvalidFieldException;
import com.deliveroo.services.MinuteFieldParser;
import com.deliveroo.utils.CronParserUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MinutesFieldParserImpl implements MinuteFieldParser {

        private final String REGEX=
                "^(\\\\*|[0-5]?[0-9]|\\\\*/\\\\d+|[0-5]?[0-9]-[0-5]?[0-9]|([0-5]?[0-9],)+[0-5]?[0-9])$\n";

        private final int MIN =0, MAX =59;
    @Override
    public List<String> parseField(String field) throws InvalidFieldException {
        Pattern pattern=Pattern.compile(REGEX);
        Matcher matcher=pattern.matcher(field);


        return CronParserUtil.parseNumericalField(field,MIN,MAX);

    }
}
