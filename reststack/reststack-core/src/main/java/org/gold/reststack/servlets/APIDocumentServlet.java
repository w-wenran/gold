package org.gold.reststack.servlets;

import org.gold.reststack.models.RequestRouting;
import org.gold.reststack.runtime.APIContext;
import org.gold.reststack.utils.ResourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by wangwr on 2016.3.23.
 */
public class APIDocumentServlet extends HttpServlet{

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*List<RequestRouting> routings = APIContext.getAllReqMappings(applicationContext);
        resp.setContentType("text/HTML; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String body = DocumentParser.getDocumentHeader();
        body = body.replace("<style></style>","<style>"+DocumentParser.getDocumentCss()+"</style>");
        String content = DocumentParser.getDocumentTableContent(routings);
        body = body.replace("{content}",content);
        out.write(body);
        out.close();*/
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
            /*stringBuffer.append("<div class=\"content\"><div class=\"content-title\"><h1>目录</h1></div><ul class=\"content-body\">");
            int i = 0;
            for(RequestRouting routing:routings){
                String str = String.format("<li><a href=\"http://www.itrigo.net/doc.html#p%s\">%s</a></li>",i+"",i+". "+routing.getApiName());
                stringBuffer.append(str);
                i++;
            }
            stringBuffer.append("</ul></div>");*/
            return stringBuffer.toString();
        }

        public static String getDocumentApiDetailList(){
            return "";
        }
    }
}
