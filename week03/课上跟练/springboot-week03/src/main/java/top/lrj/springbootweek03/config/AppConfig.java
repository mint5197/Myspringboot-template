package top.lrj.springbootweek03.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 李如锦
 */
@Data
@Component
@ConfigurationProperties(prefix = "app")
public class AppConfig {
    private String appName;
    private String version;
    private String description;
    private String publicshed;
    private String author;
    private List<String> features;

    @Data
    public static class Author {
        private String name;
        private String website;
        private String email;
    }
}
