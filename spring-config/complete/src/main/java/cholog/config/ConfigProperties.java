package cholog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties(prefix = "mail")
@ConfigurationPropertiesScan
public record ConfigProperties(
        String hostName,
        int port,
        String from
) {
}
