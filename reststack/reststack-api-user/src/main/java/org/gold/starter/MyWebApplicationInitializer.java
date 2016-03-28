package org.gold.starter;

import org.gold.reststack.servlets.APIDocumentServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by wangwr on 2016.3.22.
 */
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ServletRegistration.Dynamic dispatcher  = servletContext.addServlet("dispatcher",new DispatcherServlet());
        dispatcher.addMapping("/*");
        dispatcher.setLoadOnStartup(1);
    }
}
