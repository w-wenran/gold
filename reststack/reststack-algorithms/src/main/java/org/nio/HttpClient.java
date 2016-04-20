package org.nio;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by wangwr on 2016/4/15.
 */
public class HttpClient {

    /**
     * 给指定的url发送请求和参数params
     * @param url
     * @param params
     * @return
     */
    public static String sendPost(String url,String params) throws IOException {
        String sCurrentLine = "";
        StringBuilder reMsg = new StringBuilder();
        try {
            URLConnection connection = new URL(url).openConnection();
            connection.setDoOutput(true);//post请求
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            out.write(params);
            out.flush();
            out.close();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            while ((sCurrentLine = reader.readLine()) != null) {
                reMsg.append(reMsg.length()>0?"\r\n":"").append(sCurrentLine);
            }
        }catch (IOException e) {
            throw e;
        }
        return reMsg.toString();
    }


    /**
     * 给指定的url发送请求
     * @param url
     * @return
     */
    public static String sendGet(String url) throws IOException {
        String sCurrentLine = "";
        StringBuilder reMsg = new StringBuilder();
        try {
            URLConnection connection = new URL(url).openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            while ((sCurrentLine = reader.readLine()) != null) {
                reMsg.append(reMsg.length()>0?"\r\n":"").append(sCurrentLine);
            }
        }catch (IOException e) {
            throw e;
        }
        return reMsg.toString();
    }

}
