package com.lwk.springboot.conf;

import com.lwk.springboot.fremarker.tag.LwkTestTag;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * 该配置类 类似于mvc配置文件:spring_mvc.xml
// @EnableWebMvc 用来导入mvc框架的自动化配置，使用前提是该类有@Configuration存在
/*@ComponentScan 扫描控制器组件，使用方式有两种:
* 1.指定具体类 例如@ComponentScan(basePackageClasses = HelloController.class)，或者 basePackageClasses = {HelloController.class,xxx.class,…}
* 2.指定基础包 例如本例使用的方法，或者数组形式@ComponentScan({"com.*.**","com.*.**"})
* 注：basePackages 关键字 可以选择性添加，默认会自动匹配到basePackages
* */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.lwk.springboot.controller")
public class WebMvcConfig {

    //    声明页面的编码格式、类型
    private static final String CONTENTTYPE = "text/html; charset=UTF-8";

    //    Thymeleaf框架配置
    @Bean
    public FreeMarkerViewResolver templateResolver(){
        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
        resolver.setPrefix("");
        resolver.setSuffix(".ftl");
        resolver.setCache(false);//     去除缓存
        resolver.setContentType(CONTENTTYPE);
        return resolver;
    }

    @Bean
    public FreeMarkerConfigurer getFreeMarkerConfigurer(){
        Map map=new HashMap();
        map.put("mamadan",new LwkTestTag());

        FreeMarkerConfigurer freeMarkerConfigurer=new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/");
        freeMarkerConfigurer.setDefaultEncoding("utf-8");
        freeMarkerConfigurer.setFreemarkerVariables(map);//设置自定义模板
        return freeMarkerConfigurer;
    }


    /**
     * 模板引擎解释器
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {

        return templateResolver();
    }
}