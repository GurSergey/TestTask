package TestTask.swagger;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration("swaggerConfigProperties")
public class SwaggerConfigProperties {
    @Value("1.0")
    private String apiVersion;
    @Value("true")
    private String enabled = "false";
    @Value("Заголовок")
    private String title;
    @Value("описание")
    private String description;
    @Value("false")
    private String useDefaultResponseMessages;
    @Value("false")
    private String enableUrlTemplating;
    @Value("true")
    private String deepLinking;
    @Value("1")
    private String defaultModelsExpandDepth;
    @Value("1")
    private String defaultModelExpandDepth;
    @Value("false")
    private String displayOperationId;
    @Value("false")
    private String displayRequestDuration;
    @Value("false")
    private String filter;
    @Value("0")
    private String maxDisplayedTags;
    @Value("false")
    private String showExtensions;
}