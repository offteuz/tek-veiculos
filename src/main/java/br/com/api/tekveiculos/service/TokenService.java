package br.com.api.tekveiculos.service;

import br.com.api.tekveiculos.exception.GenerateTokenErrorException;
import br.com.api.tekveiculos.exception.ValidateTokenErrorException;
import br.com.api.tekveiculos.model.Member;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String tokengenerate(Member member) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("Tek-Veículos API")
                    .withSubject(member.getName())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new GenerateTokenErrorException();
        }

    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("Tek-Veículos API")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTCreationException exception) {
            throw new ValidateTokenErrorException();
        }
    }

    private Instant genExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
