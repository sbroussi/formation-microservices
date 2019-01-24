package lu.ing.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Load:
 * # pictures
 * app:
 * pictures:
 * directory: /home/zzadmin/IdeaProjects/stef/pictures
 */
@Configuration
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {

    private Pictures pictures;

    @Data
    public static class Pictures {
        private String directory = "/tmp";
    }
}
