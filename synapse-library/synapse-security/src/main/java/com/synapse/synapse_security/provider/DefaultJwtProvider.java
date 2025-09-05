package com.synapse.synapse_security.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class DefaultJwtProvider implements JwtProvider {
    private final String secretKey;
    private final long validityInMilliseconds;
    private final String issuer;
    private final Algorithm algorithm;
    private final JWTVerifier verifier;

    public DefaultJwtProvider (String secretKey, long validityInMilliseconds, String issuer) {
        this.secretKey = secretKey;
        this.validityInMilliseconds = validityInMilliseconds;
        this.issuer = issuer;
        this.algorithm = Algorithm.HMAC256(secretKey);
        this.verifier = JWT.require(algorithm).withIssuer(issuer).build();
    }

    @Override
    public String createToken(String subject, Map<String, Object> claims) {
        Instant now = Instant.now();
        Instant expiration = now.plus(validityInMilliseconds, ChronoUnit.MINUTES);

        return JWT.create()
                .withIssuer(issuer)
                .withSubject(subject)
                .withIssuedAt(now)
                .withExpiresAt(expiration)
                .withPayload(claims)
                .sign(algorithm);
    }

    @Override
    public DecodedJWT verify(String token) {
        return verifier.verify(token);
    }
}
