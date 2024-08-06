package cholog.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "server")
public record ServerConfigProperties(
        Address address,
        Map<String, String> resourcesPath
) {
}
