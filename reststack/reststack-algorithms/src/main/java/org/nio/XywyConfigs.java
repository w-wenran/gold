package org.nio;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangwr on 2016/4/15.
 */
public class XywyConfigs {

    public static Map<String,String> configs = new HashMap<String, String>();

    {
        configs.put("authorize_server","https://oauth.xywy.com/oauth2");
        configs.put("resource_server","https://oauth.xywy.com/resource");
        configs.put("response_type","code");
        configs.put("app_key","2000000017");
        configs.put("app_secret","c882cdfdf97475228457fc25f342a086");
        configs.put("callback_url","https://oauth.xywy.com/sdk_demo/callback.php");

    }
}
