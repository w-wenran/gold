package org.oauth2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.gold.starter.AppApplication;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2016.3.22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AppApplication.class)
@WebIntegrationTest(value = "8080")
@DirtiesContext
public class BaseTest {

    @Autowired
    private ObjectMapper jsonObjectMapper;

    public void show(Object object){
        try {
            System.out.println(jsonObjectMapper.writeValueAsString(object));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
