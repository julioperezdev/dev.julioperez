package dev.julioperez.certificate.shared.application.logger.service;

import dev.julioperez.certificate.shared.application.logger.adapter.LoggerAdapter;

public class LoggerService {

    private final LoggerAdapter loggerAdapter;

    public LoggerService(LoggerAdapter loggerAdapter) {
        this.loggerAdapter = loggerAdapter;
    }

    public void info(String information){
        loggerAdapter.log().info(information);
    }

    public void info(String information, Object object){
        loggerAdapter.log().info(information, object);
    }

    public void error(String information){
        loggerAdapter.log().error(information);
    }

    public void error(String information, Object object){
        loggerAdapter.log().error(information, object);
    }

    public void error(String information, Throwable throwable){
        loggerAdapter.log().error(information, throwable);
    }

}
