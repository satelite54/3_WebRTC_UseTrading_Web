package com.dreamteam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class SpringWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Nullable
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {ApplicationContextConfig.class};
    }

    @Nullable
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ApplicationContextConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
