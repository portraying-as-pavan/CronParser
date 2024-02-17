package com.deliveroo.services.impl;

import com.deliveroo.services.CommandFieldParser;

import java.util.Collections;
import java.util.List;

public class CommandFieldParserImpl implements CommandFieldParser {
    @Override
    public List<String> parseField(String field) {
       field= field.trim();
        return Collections.singletonList(field);
    }
}
