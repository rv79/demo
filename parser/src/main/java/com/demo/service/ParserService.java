package com.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Herve on 05/03/2017.
 */

@Service
public class ParserService {

    private final static Logger logger = LoggerFactory.getLogger(ParserService.class);

    public ParserService () {
        logger.info("Service initializing...");
    }
}
