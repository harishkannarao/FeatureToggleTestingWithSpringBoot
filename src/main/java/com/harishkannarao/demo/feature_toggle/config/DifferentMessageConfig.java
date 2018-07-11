package com.harishkannarao.demo.feature_toggle.config;

import com.harishkannarao.demo.feature_toggle.service.DifferentMessageService;
import com.harishkannarao.demo.feature_toggle.service.MessageService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "conditional-service", value = "name", havingValue = "different")
public class DifferentMessageConfig {

    @Bean
    public MessageService createDifferentMessageService() {
        return new DifferentMessageService();
    }
}
