package org.algosketch.android.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket swaggerAPI() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.swaggerInfo())
                .select()
                .apis(RequestHandlerSelectors.any())
                .build()
                .useDefaultResponseMessages(true);
    }

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder()
                .title("안드로이드 최종 과제용 임시 API")
                .description("라이브러리 충돌 때문에 스웨거 만드는데 고생했으니 과제 열심히 해주세요 ㅠㅠ")
                .version("1.0.0")
                .build();
    }
}
