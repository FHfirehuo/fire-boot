/*package com.ciecc.fire.config;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomizationBean implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(9000); // 配置端口号
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html")); //配置错误页
        container.setSessionTimeout(10, TimeUnit.MINUTES); //session过期时间
    }

}*/