package com.kristijan.pajtasev.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.context.*;

/**
* Created by kristijan on 10.11.14..
*/
@Configuration
public class MessageSecurityWebApplicationInitializer
        extends AbstractSecurityWebApplicationInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfiguration.class };
    }

}