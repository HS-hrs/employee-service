package HS_hrs.employee_service.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "Employee Service API",
        description = "Employee Service API 문서",
        version = "v1.0.0"
    )
)
@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI api(){
        return new OpenAPI()
            .components(new Components())
            .info(new Info()
                .title("Employee Service API")
                .version("v1.0.0")
                .description("Employee Service API 문서"));
    }
}
