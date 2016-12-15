package com.javasd.ijm.basics;

import com.javasd.ijm.commons.utils.Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class IjmBasicsApplication implements
        CommandLineRunner
{

    public static void main(String[] args)
    {
        SpringApplication.run(
                IjmBasicsApplication.class,
                args);
    }

    @Override
    public void run(String... args) throws Exception
    {
       Utils.consoleMsg("Basics Microservice up and running!");
    }
}
