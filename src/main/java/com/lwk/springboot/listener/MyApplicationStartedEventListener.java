package com.lwk.springboot.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 支持的事件类型四种
 * ApplicationStartedEvent 应用启动时
 * ApplicationEnvironmentPreparedEvent 对应Enviroment已经准备完毕，但此时上下文context还没有创建。
 * ApplicationPreparedEvent 上下文context创建完成，但此时spring中的bean是没有完全加载完成的。
 * ApplicationFailedEvent
 * spring boot 启动监听类
 * Created by R9L4H0W on 2016/2/29.
 */
public class MyApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {


    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        SpringApplication app = applicationStartedEvent.getSpringApplication();
        app.setBannerMode(Banner.Mode.LOG);// 不显示banner信息
        System.out.println("你大爷启动了吗");

    }
}
