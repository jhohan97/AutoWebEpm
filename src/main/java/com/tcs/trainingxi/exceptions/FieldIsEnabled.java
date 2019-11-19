package com.tcs.trainingxi.exceptions;

public class FieldIsEnabled extends AssertionError {

    public FieldIsEnabled (String message, Throwable throwable ){
        super(message,throwable);
    }
}
