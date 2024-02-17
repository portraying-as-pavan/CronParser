package com.deliveroo.exceptions;

public class InvalidCronExpressionException extends Exception{

    public InvalidCronExpressionException(String msg){
        super(msg);
    }
}
