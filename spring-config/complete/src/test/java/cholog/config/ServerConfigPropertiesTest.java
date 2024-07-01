package cholog.config;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
@EnableConfigurationProperties(ServerConfigProperties.class)
class ServerConfigPropertiesTest {

    @Autowired
    private ServerConfigProperties serverConfigProperties;

    @Test
    void test() {
        Address actualAddress = serverConfigProperties.address();
        var actualResourcesPath = serverConfigProperties.resourcesPath();

        System.out.println(actualAddress);
        System.out.println(actualResourcesPath);

        var expectedIp = "192.168.0.1";
        var expectedResourcesPath = new HashMap<String, String>();
        expectedResourcesPath.put("img", "/root/img");

        assertThat(actualAddress.ip()).isEqualTo(expectedIp);
        assertThat(actualResourcesPath).isEqualTo(expectedResourcesPath);
    }
}
