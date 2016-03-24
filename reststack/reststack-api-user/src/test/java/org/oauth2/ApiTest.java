package org.oauth2;

import org.gold.reststack.models.User;
import org.gold.reststack.utils.MockUtil;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

/**
 * Created by wangwr on 2016.3.23.
 */
public class ApiTest extends BaseTest {

    @Test
    public void documentTest() throws IOException {
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity("http://localhost:8080/documents", String.class);
        super.show("------------------------------------------------------------------------");
        super.show(entity);
    }

    @Test
    public void mockTest(){
        super.show(MockUtil.mock(User.class));
    }
}
