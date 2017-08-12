package com.javasd.ijm.myms;

import com.javasd.ijm.commons.utils.Utils;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment
        = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IjmMymsApplicationTests
{

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void contextLoads()
    {
    }

    @Test
    public void rootTest1()
    {
        try
        {
            String result = testRestTemplate
                    .getForObject(
                            "http://localhost:9013/",
                            String.class);
            assertThat(result).contains(
                    "MyMs");
            Utils.consoleMsg("TESTS/rootTest1 - OK", "ok");
        }
        catch (Exception e)
        {
            Utils.consoleMsg("TESTS/rootTest - EXCEPTION",
                    "error");
            e.printStackTrace();
        }
    }
    
    @Test
    public void rootTest2()
    {
        try
        {
            String result = testRestTemplate
                    .getForObject(
                            "http://localhost:9013/",
                            String.class);
            Object assertObject = assertThat(result).contains(
                    "XyXs");
            Utils.consoleMsg("TESTS/rootTest2 - OK", "ok");
        }
        catch (Exception e)
        {
            Utils.consoleMsg("TESTS/rootTest2 - EXCEPTION",
                    "error");
            e.printStackTrace();
        }
    }

}
