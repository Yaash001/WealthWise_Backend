package in.starmaven.wealthwise.config;

// import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@EnableWebMvc
@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI createSwaggerApi() {
		return new OpenAPI()
				          .info(new Info()
				          .title("WealthWise")
				          .version("1.0.0")
				          .description("WealthWise Monitoring "));
	}
}