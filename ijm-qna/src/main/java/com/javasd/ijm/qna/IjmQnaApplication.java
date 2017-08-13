package com.javasd.ijm.qna;

import com.javasd.ijm.commons.utils.Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IjmQnaApplication implements CommandLineRunner
{

    public static void main(String[] args)
    {
        SpringApplication.run(IjmQnaApplication.class,
                args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        Utils.consoleMsg("QnA Microservice up and Running!");
    }
}
