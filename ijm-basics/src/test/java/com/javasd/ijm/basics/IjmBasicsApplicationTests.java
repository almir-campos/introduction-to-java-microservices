package com.javasd.ijm.basics;

import com.javasd.ijm.commons.utils.Utils;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment
        = WebEnvironment.DEFINED_PORT)
public class IjmBasicsApplicationTests
{

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads()
    {
        //System.out.println("\n\n\nTESTS/contextLoads()\n\n\n");
        Utils.consoleMsg("TESTS/contextLoads - OK", "ok");
    }

    @Test
    public void rootTest()
    {
        try
        {
            String result = testRestTemplate
                    .getForObject(
                    "http://localhost:9002/",
                    String.class);
            assertThat(result).contains(
                    "Basics Microservice");
            Utils.consoleMsg( "TESTS/rootTest - OK", "ok");
        }
        catch (Exception e)
        {
            Utils.consoleMsg( "TESTS/rootTest - FAIL", "error");
            e.printStackTrace();
        }
    }

}
