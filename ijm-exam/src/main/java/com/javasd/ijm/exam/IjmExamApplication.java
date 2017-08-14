package com.javasd.ijm.exam;

import com.javasd.ijm.commons.utils.Utils;
import com.javasd.ijm.exam.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author acampos
 */
@SpringBootApplication
@EnableSwagger2
@EnableAsync
public class IjmExamApplication
        implements CommandLineRunner
{

    @Autowired
    private EmailService emailService;
    
    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        SpringApplication.run(IjmExamApplication.class,
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
        Utils.consoleMsg(
                "Exam Microservice up and running!");
    }
}
