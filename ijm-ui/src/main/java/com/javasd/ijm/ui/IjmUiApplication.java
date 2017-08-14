package com.javasd.ijm.ui;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javasd.ijm.commons.utils.Utils;
import java.net.URL;
import java.text.DecimalFormat;
import org.springframework.beans.factory.annotation.Autowired;
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
        String serverPort = environment.getProperty("server.port");
        String managementPort = environment.getProperty("management.port");
        Utils.consoleMsg("UI Microservice up and running at port " + serverPort +
                " (Please, use the port " + managementPort + " for the Actuator endpoints)");

        String actuatorUrl = "http://localhost:9022";
        ObjectMapper objectMapper = new ObjectMapper();
        URL url;
        JsonNode json;
        DecimalFormat df = new DecimalFormat("###,###,###,###,###");
        
        // HEALTH
        //
        url = new URL(actuatorUrl + "/health");
        json = objectMapper.readTree(url);
        String healthFreeSpace =
                "+ Free Disk Space: " +
                 df.format(Long.parseLong(json.get("diskSpace").get("free").toString() )/1024/1024)
                + " M";

        // METRICS 
        //
        url = new URL(actuatorUrl + "/metrics");
        json = objectMapper.readTree(url);
        String metricsFreeMemory =
                "+ Free Memory    : " +
                 df.format(Long.parseLong(json.get("mem.free").toString() )/1024)
                + " M";
        
        // ENV 
        //
        url = new URL(actuatorUrl + "/env");
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
