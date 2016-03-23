package org.gold.reststack.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 资源获取
 * Created by wangwr on 2016.3.23.
 */
public class ResourceUtil {

    public static final String ENTER_NEWLINE_CODE= "\r\n";

    /**
     * 获取文件内容
     * @param resourcePackage
     * @return
     */
    public static String getResourceContent(String resourcePackage){
        StringBuffer stringBuffer = new StringBuffer();
        try {
            InputStream inputStream = ResourceUtil.class.getClassLoader().getResourceAsStream(resourcePackage);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            String line = "";
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line+ENTER_NEWLINE_CODE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

}
