package com.harishkannarao.demo.feature_toggle.config;

import com.harishkannarao.demo.feature_toggle.service.DefaultMessageService;
import com.harishkannarao.demo.feature_toggle.service.MessageService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "conditional-service", value = "name", havingValue = "default", matchIfMissing = true)
public class DefaultMessageConfig {

    @Bean
    public MessageService createDefaultMessageService() {
        return new DefaultMessageService();
    }
}
