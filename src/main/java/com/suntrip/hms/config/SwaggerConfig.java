package com.suntrip.hms.config;

import com.suntrip.hms.common.config.BaseSwaggerConfig;
import com.suntrip.hms.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by macro on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.suntrip.hms.modules")
                .title("suntrip-hms")
                .description("suntrip-hms项目接口文档")
                .contactName("lizh")
                .version("1.0")
                .enableSecurity(true)
                .build();
    }
}
