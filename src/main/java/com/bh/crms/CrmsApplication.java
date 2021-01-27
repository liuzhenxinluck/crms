package com.bh.crms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class CrmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmsApplication.class, args);
    }

}
