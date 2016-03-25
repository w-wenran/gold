package org.gold.reststack.utils;

/**
 * 字符串工具
 * Created by wangwr on 2016.3.24.
 */
public class StrUtil {

    public static final String TAB_CHAR = "\t";

    public static final String CLER = "\n";

    public static String repeat(String chars,int times){
        StringBuffer target = new StringBuffer();
        for(int i = 0;i<times;i++){
            target.append(chars);
        }
        return target.toString();
    }
}
