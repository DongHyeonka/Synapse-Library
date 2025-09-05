package com.synapse.synapse_security.configuration;

public class TokenProps {
    private String secretKey;
    private long validityInSeconds;
    private String issuer;

    public String getSecretKey() {
        return secretKey;
    }

    public long getValidityInSeconds() {
        return validityInSeconds;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setValidityInSeconds(long validityInSeconds) {
        this.validityInSeconds = validityInSeconds;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}
