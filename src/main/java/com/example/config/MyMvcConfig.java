package com.example.config;

import com.example.component.LoginHandlerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 配置静态资源映射
 */
//Configuration
//@EnableWebMvc

@Component
public class MyMvcConfig implements WebMvcConfigurer {
    /**
     * 添加静态资源文件，外部可以直接访问地址
     *
     * @param registry
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 配置首页，配置成templates下的某一个文件
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //映射
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器
        //因为SpringBoot已经做好了静态资源映射，所以这里不需要排除它们的路径
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
    }
}
