package sqgxy.xxydz.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xmp
 * @date 2022-11-19 15:03
 * Cors 跨域配置文件
 */

@Configuration
@Slf4j
public class CorsConfig  {

    @Bean
    public WebMvcConfigurer webMvcConfigurer()  {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")	// 允许跨域访问的路径
                        .allowCredentials(true) // 解决请求带上Cookie信息
                        .allowedOriginPatterns("*")	// 允许跨域访问的源
                        .allowedMethods("GET", "POST", "OPTIONS","PUT","DELETE")
                        .maxAge(60)	// 预检间隔时间
                        .allowedHeaders("authorization", "Content-Type") // 允许头部设置
                        .exposedHeaders()
                        .allowCredentials(Boolean.TRUE);	// 是否发送cookie
            }
        };
    }

}
