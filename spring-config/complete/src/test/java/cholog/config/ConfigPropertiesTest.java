package cholog.config;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigPropertiesTest {

    @Autowired
    private ConfigProperties configProperties;

    @Test
    void scanConfigurationProperties() {
        assertThat(configProperties.hostName()).isEqualTo("host@mail.com");
        assertThat(configProperties.port()).isEqualTo(9000);
        assertThat(configProperties.from()).isEqualTo("mailer@mail.com");
    }
}
