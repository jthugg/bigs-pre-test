package org.example.bigs.pretest.util;

import org.example.bigs.pretest.core.util.util.ApplicationLockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LockProviderConfig {

    @Bean
    public ApplicationLockProvider lockProvider() {
        return new ApplicationLockProvider();
    }

}
