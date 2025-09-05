package com.synapse.synapse_security.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.synapse.synapse_security.provider.DefaultJwtProvider;
import com.synapse.synapse_security.provider.JwtProvider;

@AutoConfiguration
@EnableConfigurationProperties(JwtProperties.class)
public class JwtAutoConfiguration {
    
    @Bean
    @Qualifier("external")
    @ConditionalOnProperty(name = "synapse.jwt.external.secret-key")
    public JwtProvider externalJwtProvider(JwtProperties properties) {
        TokenProps props = properties.getExternal();
        return new DefaultJwtProvider(props.getSecretKey(), props.getValidityInSeconds() * 1000, props.getIssuer());
    }

    @Bean
    @Qualifier("internal")
    @ConditionalOnProperty(name = "synapse.jwt.internal.secret-key")
    public JwtProvider internalJwtProvider(JwtProperties properties) {
        TokenProps props = properties.getInternal();
        return new DefaultJwtProvider(props.getSecretKey(), props.getValidityInSeconds() * 1000, props.getIssuer());
    }
}
