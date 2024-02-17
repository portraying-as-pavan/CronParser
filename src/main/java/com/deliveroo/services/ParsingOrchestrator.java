package com.deliveroo.services;

import com.deliveroo.exceptions.InvalidCronExpressionException;
import com.deliveroo.exceptions.InvalidFieldException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParsingOrchestrator {

    private final MinuteFieldParser minuteFieldParser;
    private final HourFieldParser hourFieldParser;
    private final DayFieldParser dayFieldParser;
    private final WeekFieldParser weekFieldParser;

    private final MonthFieldParser monthFieldParser;

    private final CommandFieldParser commandFieldParser;

    public ParsingOrchestrator(MinuteFieldParser minuteFieldParser, HourFieldParser hourFieldParser, DayFieldParser dayFieldParser
                                    , WeekFieldParser weekFieldParser, MonthFieldParser monthFieldParser, CommandFieldParser commandFieldParser){
        this.minuteFieldParser = minuteFieldParser;
        this.hourFieldParser=hourFieldParser;
        this.dayFieldParser=dayFieldParser;
        this.weekFieldParser=weekFieldParser;
        this.monthFieldParser=monthFieldParser;
        this.commandFieldParser = commandFieldParser;
    }

    public Map<String,List<String>> parseCron(String[] cronExpression) throws InvalidFieldException, InvalidCronExpressionException {

        if(cronExpression.length!=6) throw new InvalidCronExpressionException(" Cron Expression size is not valid");

        Map<String,List<String>> parsedExpression =new HashMap<>();

        parsedExpression.put("Minute",minuteFieldParser.parseField(cronExpression[0]));
        parsedExpression.put("Hour",hourFieldParser.parseField(cronExpression[1]));
        parsedExpression.put("Day",dayFieldParser.parseField(cronExpression[2]));
        parsedExpression.put("Day of Week",weekFieldParser.parseField(cronExpression[3]));
        parsedExpression.put("Month",monthFieldParser.parseField(cronExpression[4]));
        parsedExpression.put("Command",commandFieldParser.parseField(cronExpression[5]));

        return parsedExpression;


    }
}
