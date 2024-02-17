package com.deliveroo;

import com.deliveroo.exceptions.InvalidCronExpressionException;
import com.deliveroo.exceptions.InvalidFieldException;
import com.deliveroo.services.ParsingOrchestrator;
import com.deliveroo.services.impl.*;

import java.util.List;
import java.util.Map;

public class Parser {

    public static void main(String[] args) {
        ParsingOrchestrator parsingOrchestrator=new ParsingOrchestrator(
                new MinutesFieldParserImpl(),new HourFieldParserImpl(),new DayFieldParserImpl(),
                new WeekFieldParserImpl(), new MonthFieldParserImpl(),new CommandFieldParserImpl());

        try {
            if(args.length==0) throw new InvalidCronExpressionException("Empty Cron Expression received");
            String cronExp=args[0];
            String[] expArray=cronExp.split(" ");

            Map<String,List<String>> result=parsingOrchestrator.parseCron(expArray);

            for (Map.Entry<String, List<String>> entry : result.entrySet()) {
                String paddedKey = String.format("%-14s", entry.getKey());
                System.out.print(paddedKey);
                for (String value : entry.getValue()) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        }catch (InvalidCronExpressionException | InvalidFieldException  e){
            System.out.println("Exception occurred while parsing cron Expression , Exception= "+e);
        }

    }
}
