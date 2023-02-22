package com.baha.TrainingPlatformEE.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static com.baha.TrainingPlatformEE.Utils.Constant.APP_ROOT ;


@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket SwaggerApi()
    {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder().description("Skier Management platform").title("Project Rest API").build())
                .groupName("REST API V1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.baha.TrainingPlatformEE"))
                .paths(PathSelectors.ant(APP_ROOT+"/**"))
                .build() ;

    }


}
