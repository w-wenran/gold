package org.oauth2;

import org.codehaus.jackson.map.ObjectMapper;
import org.gold.reststack.models.User;
import org.gold.reststack.utils.MockUtil;
import org.junit.Test;

import java.io.IOException;

/**
 * 一般测试
 * Created by wangwr on 2016.3.23.
 */
public class NormalTest {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void mockTest(){
        this.show(MockUtil.mock(User.class));
    }

    public void show(Object object){
        try {
            System.out.println(objectMapper.writeValueAsString(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
