package com.lwk.springboot;

import com.lwk.springboot.configurationProperties.LwkProperties;
import com.lwk.springboot.listener.MyApplicationEnvironmentPreparedEventListener;
import com.lwk.springboot.listener.MyApplicationFailedEventListener;
import com.lwk.springboot.listener.MyApplicationPreparedEventListener;
import com.lwk.springboot.listener.MyApplicationStartedEventListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;

// @SpringBootApplication 包含了：
// 1、@Configuration  该类是一个配置文件
// 2、@EnableAutoConfiguration 告诉spring-boot 进行自动化配置，加载基础包
// 3、@ComponentScan 自动扫描当前包下的class，完成mvc配置
// exclude 关键字，用来排除不需要的配置。比如我们要自定义 模板引擎，原有的就可以排除掉
@SpringBootApplication(exclude = {FreeMarkerAutoConfiguration.class},scanBasePackages = "com.lwk.springboot.conf")
@EnableConfigurationProperties(LwkProperties.class)
public class Application {
//    main方法作为程序入口，启动spring程序
    public static void main(String[] args) {
        SpringApplication app=new SpringApplication(Application.class);
        app.addListeners(new MyApplicationStartedEventListener());
        app.addListeners(new MyApplicationEnvironmentPreparedEventListener());
        app.addListeners(new MyApplicationPreparedEventListener());
        app.addListeners(new MyApplicationFailedEventListener());
        app.run(args);
    }


}