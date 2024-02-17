package com.deliveroo.services;

import com.deliveroo.exceptions.InvalidCronExpressionException;
import com.deliveroo.exceptions.InvalidFieldException;
import com.deliveroo.services.impl.*;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;


public class ParsingOrchestratorTest {

    DayFieldParser dayFieldParser=mock(DayFieldParserImpl.class);
    MinuteFieldParser minuteFieldParser=mock(MinutesFieldParserImpl.class);
    HourFieldParser hourFieldParser=mock(HourFieldParserImpl.class);
    WeekFieldParser weekFieldParser=mock(WeekFieldParserImpl.class);
    MonthFieldParser monthFieldParser =mock(MonthFieldParserImpl.class);
    CommandFieldParser commandFieldParser =mock(CommandFieldParserImpl.class);

    ParsingOrchestrator underTest=new ParsingOrchestrator(minuteFieldParser,hourFieldParser,dayFieldParser,
            weekFieldParser,monthFieldParser,commandFieldParser);



    @Test
    public void testInvalidFieldException() throws InvalidFieldException {
        Mockito.when(minuteFieldParser.parseField(Mockito.any())).thenReturn(List.of("1","2"));
        Mockito.when(hourFieldParser.parseField(Mockito.any())).thenReturn(List.of("1","2"));
        Mockito.when(dayFieldParser.parseField(Mockito.any())).thenReturn(List.of("1","2"));
        Mockito.when(weekFieldParser.parseField(Mockito.any())).thenReturn(List.of("1","2"));
        Mockito.when(commandFieldParser.parseField(Mockito.any())).thenReturn(List.of("1","2"));
        Mockito.when(monthFieldParser.parseField(Mockito.any())).thenThrow(InvalidFieldException.class);

        assertThrows(InvalidFieldException.class, () -> underTest.parseCron(new String[6]));
    }

    @Test
    public void testInvalidCronException() {

        assertThrows(InvalidCronExpressionException.class, () -> underTest.parseCron(new String[2]));
    }
}
