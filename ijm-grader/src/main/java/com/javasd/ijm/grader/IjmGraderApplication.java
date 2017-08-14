package com.javasd.ijm.grader;

import com.javasd.ijm.commons.utils.Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IjmGraderApplication
        implements CommandLineRunner
{

    public static void main(String[] args)
    {
        SpringApplication.run(IjmGraderApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception
    {
        Utils.consoleMsg("Grader Microservice up and running!");
    }
}
