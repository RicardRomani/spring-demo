package com.example.springdemo.config;

public class ApiConfig {

    private static final String API_VERSION = "v1";
    private static final String API_CONTEXT = "/ricard-api";
    public static final String BASE_URL = API_CONTEXT + "/" + API_VERSION;

    private ApiConfig() {
        throw new UnsupportedOperationException("Cannot instantiate utilities class");
    }
}