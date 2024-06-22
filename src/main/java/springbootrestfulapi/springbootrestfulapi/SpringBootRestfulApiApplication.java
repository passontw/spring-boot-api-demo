package springbootrestfulapi.springbootrestfulapi;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot REST API Document",
                description = "Spring Boot REST API Document Description",
                version = "V1.0.0",
                contact = @Contact(
                        name = "PassonTW",
                        email="passon.com.tw@gmail.com",
                        url="https://www.javaguides.net"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url="https://www.javaguides.net/license"
                )
        )
)
public class SpringBootRestfulApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestfulApiApplication.class, args);
    }

}
