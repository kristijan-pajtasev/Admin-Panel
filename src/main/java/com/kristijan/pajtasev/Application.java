package com.kristijan.pajtasev;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by kristijan on 05.11.14..
 */
public class Application implements WebApplicationInitializer {

    public static final String CONFIG_LOCATION = "com.kristijan.pajtasev.config";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext webApplicationContext = getContext();
        servletContext.addListener(new ContextLoaderListener(webApplicationContext));
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("DispatcherServlet", new DispatcherServlet(webApplicationContext));

        dispatcher.addMapping("/*");
//        dispatcher.addMapping("/static");
    }

    private WebApplicationContext getContext() {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.setConfigLocation(CONFIG_LOCATION);
        return context;
    }

}
