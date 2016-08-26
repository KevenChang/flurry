package my.custom.transformer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

/**
 * Spring XD模块入口
 */
@Configuration
@EnableIntegration
public class ModuleConfiguration {
    @Bean
    MessageChannel input() {
        return new DirectChannel();
    }

    @Bean
    MessageChannel output() {
        return new DirectChannel();
    }

    @Bean
    Byte2StringTransformer transformer() {
        return new Byte2StringTransformer();
    }
}
