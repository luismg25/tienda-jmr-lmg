package es.iesclaradelrey.da2d1a.tiendajmrlmgapi.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    //Valores leídos de application.properties con expresiones SpEL
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.access-token-expiration}")
    private long accessTokenExpiration;

    @Value("${jwt.refresh-token-expiration}")
    private long refreshTokenExpiration;

    // obtiene la clave de firma a partir del Base64 guardado en properties
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String generateAccessToken(UserDetails user) {
        return buildToken(user, accessTokenExpiration, TokenType.ACCESS);
    }

    @Override
    public String generateRefreshToken(UserDetails user) {
        return buildToken(user, refreshTokenExpiration, TokenType.REFRESH);
    }

    // Construye el token con los claims estándar y el claim personalizado "type"
    private String buildToken(UserDetails user, long expiration, TokenType type) {
        return Jwts.builder()
                .subject(user.getUsername())              // claim "sub" -- nombre de usuario
                .issuedAt(new Date())                      // claim "iat" -- fecha emisión
                .expiration(new Date(System.currentTimeMillis() + expiration)) // claim "exp"
                .claim("type", type.name())                // claim personalizado
                .signWith(getSigningKey())                  // firma digital HMAC-SHA256
                .compact();
    }

    @Override
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public Boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    @Override
    public Boolean isTokenValid(String token, UserDetails user) {
        String username = extractUsername(token);
        return username.equals(user.getUsername()) && !isTokenExpired(token);
    }

    // Extrae un claim específico del token función genérica
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    //Parsea el token y verifica la firma y lanza excepción si fue manipulado
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}