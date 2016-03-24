package org.gold.reststack.runtime;

import org.gold.reststack.annotation.Undefined;
import org.gold.reststack.models.RequestRouting;
import org.gold.reststack.utils.JsonUtil;
import org.gold.reststack.utils.MockUtil;
import org.gold.reststack.utils.ResourceUtil;
import org.springframework.context.ApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Administrator on 2016.3.23.
 */
public class ApiDocumentHandler {

    public static void createDocument(ApplicationContext applicationContext, HttpServletRequest req, HttpServletResponse resp){
        try {
            List<RequestRouting> routings = APIContext.getAllReqMappings(applicationContext);
            resp.setContentType("text/HTML; charset=UTF-8");
            PrintWriter out = resp.getWriter();
            String body = DocumentParser.getDocumentHeader();
            body = body.replace("<style></style>","<style>"+DocumentParser.getDocumentCss()+"</style>");
            String content = DocumentParser.getDocumentTableContent(routings);
            content = content+DocumentParser.getDocumentApiDetailList(routings);
            body = body.replace("{content}",content);
            out.write(body);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private static class DocumentParser{

        public static String getDocumentHeader(){
            return ResourceUtil.getResourceContent("org/gold/reststack/res/api_document_header.html");
        }

        public static String getDocumentCss(){
            return ResourceUtil.getResourceContent("org/gold/reststack/res/api_document_style.css");
        }

        public static String getDocumentTableContent(List<RequestRouting> routings){
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<div class=\"content\"><div class=\"content-title\"><h1>目录</h1></div><ul class=\"content-body\">");
            int i = 1;
            for(RequestRouting routing:routings){
                String str = String.format("<li><a href=\"http://localhost:8080/documents#p%s\">%s</a></li>",i+"",i+". "+routing.getApiName());
                stringBuffer.append(str);
                i++;
            }
            stringBuffer.append("</ul></div>");
            return stringBuffer.toString();
        }

        public static String getDocumentApiDetailList(List<RequestRouting> routings){
            StringBuffer target = new StringBuffer();
            target.append("<div class=\"box\">");
            target.append("<div class=\"box-title\">接口文档</div>");
            target.append("<div class=\"box-notice\">");
            target.append("<div class=\"red notice-title\">文档说明</div>");
            target.append("<ul class=\"notice-body\">");
            target.append("<li>该接口文档为实时更新文档</li>");
            target.append("<li>接口地址定义遵循restful风格</li>");
            target.append("<li>所有地址以及参数命名均采用下划线作为单词分割</li>");
            target.append("</ul>");
            target.append("</div>");
            target.append("<div class=\"interface\">");
            target.append("<div class=\"interface-title\">接口详情</div>");
            int index = 1;
            for(RequestRouting routing:routings){
                target.append("<div class=\"interface-item\">");
                target.append(String.format("<div class=\"item-tt\" id=\"p%s\">",index));
                target.append(String.format("<span>%s. %s</span> <span class=\"line\"></span>",index,routing.getApiName()));
                target.append("</div>");
                target.append("<div class=\"item-bd\">");
                target.append("<div class=\"item-lft\">接口功能</div>").append(String.format("<div class=\"item-rt\">%s</div>",routing.getApiName()));
                target.append("<div class=\"item-lft\">请求方式</div>").append(String.format("<div class=\"item-rt\">%s</div>",routing.getReqMethod().toUpperCase()));
                target.append("<div class=\"item-lft\">请求地址</div>").append(String.format("<div class=\"item-rt code\">%s</div>",routing.getReqUrl()));
                target.append("<div class=\"item-lft\">地址参数</div>").append(String.format("<div class=\"item-rt code\">%s</div>", Arrays.toString(routing.getParams())));
                if(!Undefined.class.equals(routing.getReqClass())){
                    target.append("<div class=\"item-lft\">BODY参数</div>").append(String.format("<div class=\"item-rt code\">%s</div>",JsonUtil.toJson(MockUtil.mock(routing.getReqClass()))));
                }
                String result = routing.getRespData();
                if(routing.getRespData().length()<=0){
                    result = JsonUtil.toJson(MockUtil.mock(routing.getRespClass()));
                }
                target.append("<div class=\"item-lft\">返回结果</div>").append(String.format("<div class=\"item-rt code\">%s</div>", result));
                target.append("</div></div>");
                index++;
            }
            target.append("</div>");
            return target.toString();
        }
    }

}
