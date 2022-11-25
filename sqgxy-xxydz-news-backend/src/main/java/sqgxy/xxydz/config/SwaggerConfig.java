package sqgxy.xxydz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author xmp
 * @date 2022-11-19 21:23
 * Swagger配置
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig(ApiInfo apiInfo) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .groupName("xmp")
                .select()
                .apis(RequestHandlerSelectors.basePackage("sqgxy.xxydz.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiInfo webAipInfo() {
        return new ApiInfoBuilder()
                .title("商丘工学院-信电分院-新闻网")
                .description("本文档描述了后端接口API定义")
                .version("1.0.2")
                .contact(
                        new Contact
                                ("@xmp", "https://blog.csdn.net/qq_53463544?spm=1000.2115.3001.5343", "xmp0526@162.com")
                )
                .build();
    }

}

