package com.javasd.ijm.myms;

import com.javasd.ijm.commons.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class IjmMymsApplication implements
        CommandLineRunner
{

    @Autowired
    Environment environment;

    public static void main(String[] args)
    {
        SpringApplication.run(IjmMymsApplication.class,
                args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        // Not required by the exercise, but I decided
        // to add it just for fun!
        String port = environment.getProperty(
                "server.port");
        Utils.consoleMsg(
                "MyMs up and Running locally at port " +
                port);
    }
}
