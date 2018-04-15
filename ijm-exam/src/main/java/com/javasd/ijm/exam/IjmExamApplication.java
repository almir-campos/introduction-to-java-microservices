package com.javasd.ijm.exam;

import com.javasd.ijm.commons.utils.Utils;
import com.javasd.ijm.exam.email.EmailService;
import com.javasd.ijm.exam.messaging.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @author acampos
 */
@SpringBootApplication
@EnableSwagger2
@EnableAsync
//@EnableEurekaClient
public class IjmExamApplication
        implements CommandLineRunner
{

    @Autowired
    private EmailService emailService;
    
    @Autowired
    private Sender sender;
    
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
        sender.sendToExamToUiExamAliveQ();
    }
    
    @Bean
//    @LoadBalanced  //REQUIRED!!! (To resolve the application names to the actual urls)
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
