package cholog.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties(prefix = "server")
@ConfigurationPropertiesScan
public record ServerConfigProperties(
        Address address,
        Map<String, String> resourcesPath
) {
}
