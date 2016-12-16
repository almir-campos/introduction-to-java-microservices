package com.javasd.ijm.exam;

import com.javasd.ijm.commons.utils.Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author acampos
 */
@SpringBootApplication
@EnableSwagger2
public class IjmExamApplication
        implements CommandLineRunner
{

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
