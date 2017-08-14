package com.javasd.ijm.ui;

import com.javasd.ijm.commons.utils.Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author acampos
 */
@SpringBootApplication
@EnableSwagger2
public class IjmUiApplication implements CommandLineRunner
{

    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        SpringApplication.
                run(IjmUiApplication.class, args);
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception
    {
        Utils.consoleMsg("UI Microservice up and running!");
    }
    
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
