package lu.ing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class GraphQLApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(GraphQLApplication.class);
        app.run(args);
    }
}
