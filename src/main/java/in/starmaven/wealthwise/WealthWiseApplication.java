package in.starmaven.wealthwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class,SecurityAutoConfiguration.class})
public class WealthWiseApplication {
	public static void main(String[] args) {
		SpringApplication.run(WealthWiseApplication.class, args);
		System.out.println("\t\t\t///////////////////Application Started Successfully\\\\\\\\\\\\\\\\\\\\\\\\");
	}
}
