package com.javasd.ijm.qna;

import com.javasd.ijm.commons.utils.Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 *
 * @author acampos
 */
@SpringBootApplication
@EnableEurekaClient
public class IjmQnaApplication implements CommandLineRunner
{

    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        SpringApplication.run(IjmQnaApplication.class,
                args);
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception
    {
        Utils.consoleMsg("QnA Microservice up and Running!");
    }
}
