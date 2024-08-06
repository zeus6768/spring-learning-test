package cholog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mail")
public record ConfigProperties(
        String hostName,
        int port,
        String from
) {
}
