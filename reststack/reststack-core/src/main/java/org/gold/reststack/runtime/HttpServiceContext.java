package org.gold.reststack.runtime;

import org.springframework.context.ApplicationContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 服务运行上下文类。
 */
public class HttpServiceContext {
    public static final String Default_Date_Format_Pattern = "yyyy-MM-dd HH:mm:ss";
    public static final String Access_Token_Header_Key = "API-Access-Token";
    public static final String Refresh_Token_Header_Key = "API-Refresh-Token";

    private static ThreadLocal<HttpServiceContext> threadLocal = new ThreadLocal<HttpServiceContext>();

    private ApplicationContext applicationContext;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Object handler;

    public static void init(ApplicationContext applicationContext, HttpServletRequest request, HttpServletResponse response,Object handler) {
        threadLocal.set(new HttpServiceContext(applicationContext, request, response,handler));
    }

    private static HttpServiceContext getCurrent() {
        return threadLocal.get();
    }

    private HttpServiceContext(ApplicationContext applicationContext, HttpServletRequest request, HttpServletResponse response,Object handler) {
        this.applicationContext = applicationContext;
        this.request = request;
        this.response = response;
        this.handler = handler;
    }

    public static Object getHandler(){
        return getCurrent().handler;
    }

    public static HttpServletRequest getRequest() {
        return getCurrent().request;
    }

    public static HttpServletResponse getResponse() {
        return getCurrent().response;
    }

    public static String getAccessToken() {
        return getRequest() == null ? null : getRequest().getHeader(Access_Token_Header_Key);
    }

    public static String getRefreshToken() {
        return getRequest() == null ? null : getRequest().getHeader(Refresh_Token_Header_Key);
    }

    /**
     * 获取客户端源端口
     * @return
     */
    public static Long getRemotePort(){
        Long port=Long.valueOf(getRequest().getRemotePort());
        return port;
    }

    public static <T> T getBean(Class<T> clazz){
        return getCurrent().applicationContext.getBean(clazz);
    }

    /**
     * 获取项目的访问地址
     * @return
     */
    public static String getUrl(){
        return getRequest().getScheme()+"://"+getRequest().getServerName()+":"+getRequest().getServerPort()+getRequest().getContextPath()+getRequest().getPathInfo();
    }

    /**
     * 获取项目根地址
     * @return
     */
    public static String getContextPath(){
        return getRequest().getScheme()+"://"+getRequest().getServerName()+":"+getRequest().getServerPort()+getRequest().getContextPath();
    }
}
