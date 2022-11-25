package sqgxy.xxydz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * @author xmp
 * @date 2022-11-22 14:23
 */

//请求 放行  静态资源放行
@Configuration
public class MyConfig implements WebMvcConfigurer {

    /**
     * 重写静态资源访问处理路径
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String property = System.getProperty("user.dir");
        File file = new File(property, "static");
        String path = "file:" + file + File.separator;
        registry.addResourceHandler("/**").addResourceLocations("classpath:META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/", path);
    }
}



