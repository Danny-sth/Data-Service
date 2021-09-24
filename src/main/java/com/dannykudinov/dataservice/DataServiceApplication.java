package com.dannykudinov.dataservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataServiceApplication {

    static  final Logger logger =
            LoggerFactory.getLogger(DataServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DataServiceApplication.class, args);
        logger.info("Application is START!");
    }

}
