package com.chs.jenkinsspringbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinsSpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JenkinsSpringbootDemoApplication.class, args);
    }

    @RequestMapping(value = "jenkinsSpringbootDemo",method = RequestMethod.GET)
    public String jenkinsSpringbootDemo(){
        return "get hello webhook day2 test3 pipeline";
    }

}
