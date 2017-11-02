package com.javasd.ijm.exam;

import com.javasd.ijm.commons.utils.Utils;
import com.javasd.ijm.exam.email.EmailService;
import com.javasd.ijm.exam.messaging.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
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
    
    @Autowired
    private Sender sender;
    
    @Value("${server.port}")
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
        Utils.consoleMsg("Exam Microservice up and Running on the " +
                System.getProperty("ijm_env").toUpperCase() +
                " environment at port " + serverPort );
        sender.sendToExamToUiExamAliveQ();
    }
}
