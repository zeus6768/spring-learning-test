package cholog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties(prefix = "mail")
@ConfigurationPropertiesScan
public class ConfigProperties {

    private String hostName;
    private int port;
    private String from;

    public String getHostName() {
        return hostName;
    }

    public int getPort() {
        return port;
    }

    public String getFrom() {
        return from;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
