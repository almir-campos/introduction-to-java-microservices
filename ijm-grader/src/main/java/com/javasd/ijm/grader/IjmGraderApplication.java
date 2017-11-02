package com.javasd.ijm.grader;

import com.javasd.ijm.commons.utils.Utils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class IjmGraderApplication
        implements CommandLineRunner
{
    @Value( "${server.port}")
    private String serverPort;
    
    // QnA base url
    //
    @Value("${qna.${ijm_env}.host}")
    private String qnaHost;
    @Value("${qna.${ijm_env}.port}")
    private String qnaPort;
    
    @Bean
    public String qnaBaseUrl()
    {
        return "http://" + qnaHost + ":" + qnaPort; 
    }

    public static void main(String[] args)
    {
        SpringApplication.run(IjmGraderApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception
    {
        Utils.consoleMsg("Grader Microservice up and running at port " + serverPort + "!");
    }
    
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
