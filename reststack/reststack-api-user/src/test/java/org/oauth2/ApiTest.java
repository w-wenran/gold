package org.oauth2;

import org.gold.reststack.models.User;
import org.gold.reststack.utils.MockUtil;
import org.gold.reststack.utils.ResourceUtil;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by wangwr on 2016.3.23.
 */
public class ApiTest extends BaseTest {

    @Test
    public void documentTest() throws IOException {
        /*ResourceUtil.getResourceContent("");
        URL url = this.getClass().getClassLoader().getResource("");
        URL uri = this.getClass().getClassLoader().getResource("org/oauth2/api_document_header.html");
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("org/gold/reststack/res/api_document_header.html");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
        String line = "";
        StringBuffer stringBuffer = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            stringBuffer.append(line+"\n\r");
        }
        super.show(stringBuffer.toString());*/
        ResponseEntity<String> entity = new TestRestTemplate().getForEntity("http://localhost:8080/documents", String.class);
        super.show("------------------------------------------------------------------------");
        super.show(entity);
    }


    @Test
    public void mockTest(){
        super.show(MockUtil.mock(User.class));
    }
}
