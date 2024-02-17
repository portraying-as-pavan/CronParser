package com.deliveroo.utils;

import com.deliveroo.exceptions.InvalidFieldException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CronParserUtil {

    public static List<String> parseNumericalField(String field, int MIN, int MAX) throws InvalidFieldException {
        field = field.trim();
        List<String> result = new ArrayList<>();

        if (field.equals("*")) {
            for (int i = MIN; i <= MAX; i++) {
                result.add(String.valueOf(i));
            }
            return result;
        }
        else if (field.matches("\\d+")) {
            int value = Integer.parseInt(field);
            if (value >= MIN && value <= MAX) {
                return Collections.singletonList(field);
            }
        }
        else if (field.matches("\\*/\\d+")) {
            int interval = Integer.parseInt(field.substring(2));
            if (interval > 0 && interval <= MAX - MIN + 1) {
                int count = (MAX - MIN + 1) / interval;

                for (int i = 0; i < count; i++) {
                    result.add(String.valueOf(MIN + i * interval));
                }
                return result;
            }
        } else if (field.matches("\\d+\\-\\d+/\\d+")) {
            String[] parts = field.split("/");
            int start = Integer.parseInt(parts[0].split("-")[0]);
            int end = Integer.parseInt(parts[0].split("-")[1]);
            int interval = Integer.parseInt(parts[1]);
            if (start >= MIN && end <= MAX && start <= end && interval > 0) {

                for (int i = start; i <= end; i += interval) {
                    result.add(String.valueOf(i));
                }
                return result;
            }
        } else if (field.matches("[0-5]?[0-9]-[0-5]?[0-9]")) {
            String[] range = field.split("-");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);
            if (start >= MIN && end <= MAX && start <= end) {

                for (int i = start; i <= end; i++) {
                    result.add(String.valueOf(i));
                }
                return result;
            }
        } else if (field.contains(",")) {
            String[] parts = field.split(",");
            for (String part : parts) {
                if (!part.matches("\\d+")) {
                   List<String> temp= parseNumericalField(part,MIN,MAX);
                   result.addAll(temp);
                }
                else {
                    int value = Integer.parseInt(part);
                    if (value < MIN || value > MAX) {
                        return null;
                    }
                    else{
                        result.add(part);
                    }
                }
            }
            return result;
        }
        else{
            throw new InvalidFieldException("Field doesn't match any pattern");
        }
        return null;
    }

}
