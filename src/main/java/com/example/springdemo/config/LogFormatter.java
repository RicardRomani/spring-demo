package com.example.springdemo.config;

import java.util.logging.LogRecord;

public class LogFormatter {


    final static String ANSI_RESET = "\u001B[0m";
    final static String ANSI_RED = "\u001B[31m";
    final static String ANSI_GREEN = "\u001B[32m";

    public static String apiErrorCodeFormat() {
        return String.format("Error call in: {} %s {} \"{}\"%s", ANSI_RED, ANSI_RESET);
    }
}
