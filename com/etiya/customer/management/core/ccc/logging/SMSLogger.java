package com.etiya.customer.management.core.ccc.logging;

public class SMSLogger implements  ILogger{
    @Override
    public void log(String message) {
        System.out.println("[SMS LOGGER]: " + message);
    }
}
