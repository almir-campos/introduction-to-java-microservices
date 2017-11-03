package com.javasd.ijm.ui;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javasd.ijm.commons.utils.Utils;
import java.net.URL;
import java.text.DecimalFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
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

    @Autowired
    private Environment environment;
    
//    // User
//    @Value("${users.regular.username}")
//    private String user_username;
//    @Value("${users.regular.password}")
//    private String user_password;
//    @Value("${users.regular.role}")
//    private String user_role;
//    
//    @Bean
//    public String[] user_credentials()
//    {
//        return new String[] { user_username, user_password, user_role};
//    }
//    
//    // Admin
//    @Value("${users.admin.username}")
//    private String admin_username;
//    @Value("${users.admin.password}")
//    private String admin_password;
//    @Value("${users.admin.role}")
//    private String admin_role;
//    
//    @Bean
//    public String[] admin_credentials()
//    {
//        return new String[] {admin_username, admin_password, admin_role};
//    }
    
    // QnA base url
    //
    @Value("${qna.${ijm_env}.host}")
    private String qnaHost;
    @Value("${qna.${ijm_env}.port}")
    private String qnaPort;
    @Value("${qna.${ijm_env}.management.port}")
    private String qnaManagementPort;
    
    @Bean
    public String qnaBaseUrl()
    {
        return "http://" + qnaHost + ":" + qnaPort; 
    }
    
    @Bean
    public String qnaManagementBaseUrl()
    {
        return "http://" + qnaHost + ":" + qnaManagementPort; 
    }
    
    
    // Exam base url
    //
    @Value("${exam.${ijm_env}.host}")
    private String examHost;
    @Value("${exam.${ijm_env}.port}")
    private String examPort;
    
    @Bean
    public String examBaseUrl()
    {
        return "http://" + examHost + ":" + examPort; 
    }
    
    // Logger base url
    //
    @Value("${logger.${ijm_env}.host}")
    private String loggerHost;
    @Value("${logger.${ijm_env}.port}")
    private String loggerPort;
    
    @Bean
    public String loggerBaseUrl()
    {
        return "http://" + loggerHost + ":" + loggerPort; 
    }
    
    // UI base url
    //
    @Value("${ui.${ijm_env}.host}")
    private String uiHost;
    @Value("${ui.${ijm_env}.port}")
    private String uiPort;
    @Value("${ui.${ijm_env}.management.port}")
    private String uiManagementPort;
    
    @Bean
    public String uiBaseUrl()
    {
        return "http://" + uiHost + ":" + uiPort; 
    }
    
    @Bean
    public String uiManagementBaseUrl()
    {
        return "http://" + uiHost + ":" + uiManagementPort; 
    }
    
    

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
        System.out.println(this.getClass() + "=====>>>>> uiHost: " + uiHost);
        System.out.println(this.getClass() + "=====>>>>> uiPort: " + uiPort);
        System.out.println(this.getClass() + "=====>>>>> uiManagementPort: " + uiManagementPort);
        
        String serverPort = environment.getProperty("server.port");
        String managementPort = environment.getProperty("management.port");
        Utils.consoleMsg("UI Microservice up and running at port " + serverPort +
                " (Please, use the port " + uiManagementPort + " for the Actuator endpoints)");

        //String actuatorUrl = "http://localhost:9022";
        ObjectMapper objectMapper = new ObjectMapper();
        URL url;
        JsonNode json;
        DecimalFormat df = new DecimalFormat("###,###,###,###,###");
        
        // HEALTH
        //
        url = new URL(uiManagementBaseUrl() + "/health");
        json = objectMapper.readTree(url);
        String healthFreeSpace =
                "+ Free Disk Space: " +
                 df.format(Long.parseLong(json.get("diskSpace").get("free").toString() )/1024/1024)
                + " M";

        // METRICS 
        //
        url = new URL(uiManagementBaseUrl() + "/metrics");
        json = objectMapper.readTree(url);
        String metricsFreeMemory =
                "+ Free Memory    : " +
                 df.format(Long.parseLong(json.get("mem.free").toString() )/1024)
                + " M";
        
        // ENV 
        //
        url = new URL(uiManagementBaseUrl() + "/env");
        json = objectMapper.readTree(url);
        String javaVersion =
                "+ Java Version   : " + json.get("systemProperties").get("java.version").toString();

        System.out.println("\n+-----------------------------------");
        System.out.println("+ MORE SYSTEM INFO");
        System.out.println("+-----------------------------------");
        System.out.println( healthFreeSpace );
        System.out.println( metricsFreeMemory );
        System.out.println( javaVersion );
        System.out.println("+-----------------------------------\n");

    }

    /**
     *
     * @return
     */
    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }
}
