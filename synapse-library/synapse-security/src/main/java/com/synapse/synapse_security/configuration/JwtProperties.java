package com.synapse.synapse_security.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "synapse.jwt")
public class JwtProperties {
    private TokenProps external;
    private TokenProps internal;

    public TokenProps getExternal() {
        return external;
    }

    public TokenProps getInternal() {
        return internal;
    }

    public void setExternal(TokenProps external) {
        this.external = external;
    }

    public void setInternal(TokenProps internal) {
        this.internal = internal;
    }
}
