package com.demo;

import com.demo.service.ParserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Herve on 05/03/2017.
 */

@Component
public class ParserRunner implements CommandLineRunner {

    private final static Logger logger = LoggerFactory.getLogger(ParserRunner.class);

    private final ParserService parserService;

    @Autowired
    public ParserRunner (ParserService parserService) {
        this.parserService = parserService;
    }

    @Override
    public void run (String... args) {
        logger.info("Application starts");
    }
}
