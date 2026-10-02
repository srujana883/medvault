package com.medvault.medvault.exception;

public class PatientNotFoundException  extends  RuntimeException{
    public PatientNotFoundException(String message){
        super(message);
    }
}
