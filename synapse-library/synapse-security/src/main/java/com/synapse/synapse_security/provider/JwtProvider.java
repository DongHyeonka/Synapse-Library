package com.synapse.synapse_security.provider;

import java.util.Map;

import com.auth0.jwt.interfaces.DecodedJWT;

public interface JwtProvider {

    String createToken(String subject, Map<String, Object> claims);

    DecodedJWT verify(String token);
}
