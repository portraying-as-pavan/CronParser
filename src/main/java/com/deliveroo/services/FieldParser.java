package com.deliveroo.services;

import com.deliveroo.exceptions.InvalidFieldException;

import java.util.List;

public interface FieldParser {

    List<String> parseField(String field) throws InvalidFieldException;
}
