package dev.julioperez.certificate.shared.application.logger.adapter;

import org.slf4j.Logger;

public class LoggerAdapter {

    private final Logger slf4jLogger;

    public LoggerAdapter(Logger slf4jLogger) {
        this.slf4jLogger = slf4jLogger;
    }

    public Logger log(){
        return slf4jLogger;
    }
}
