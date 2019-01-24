package lu.ing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;

@SpringBootApplication
@EnableAutoConfiguration
public class ClientApiApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ClientApiApplication.class);
        app.addListeners(new ApplicationPidFileWriter());
        app.run(args);
    }
}
