package com.tcs.trainingxi.exceptions;

public class FieldsExeption extends AssertionError {
    public FieldsExeption(String message, Throwable throwable ){
        super(message,throwable);
    }
}