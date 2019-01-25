package lu.ing.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GestionclientGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionclientGraphqlApplication.class, args);
    }

}

