package org.janine.jian.security;

import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class TokenProvider{
    private final Logger log = LoggerFactory.getLogger(TokenProvider.class);

    
    @Value("${app.name}")
    private String APP_NAME;//应用名称
    @Value("${jwt.header}")
    private String AUTH_HEADER;//认证头
    @Value("${jwt.base64-secret}")
    private String base64Secret;//加密secret
    @Value("${jwt.token-validity-in-seconds}")
    private long tokenValidityInMilliseconds;
    
    private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    /**
     * 根据用户权限信息创建Json Web Toke
     * @param authentication
     * @return
     */
    public String createToken(Authentication authentication) {
    	log.debug("==============Begin Create JWT Token");
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();
        Date validity = new Date(now + this.tokenValidityInMilliseconds);
        
        String token = Jwts.builder()
				.setIssuer( APP_NAME )
                .setSubject(authentication.getName())
                .claim(AUTH_HEADER, authorities)
                .signWith(SIGNATURE_ALGORITHM,base64Secret)
                .setExpiration(validity)
                .compact();

        log.debug("==============End Create JWT Token");
        return token;
    }
    
    /**
     * 更新Token
     * @param token
     * @return
     */
    public String refreshToken(String token) {
    	log.debug("==============Begin refresh JWT Token");
    	Authentication authentication = this.getAuthentication(token);
    	String refresh_token = this.createToken(authentication);
    	log.debug("==============Begin refresh JWT Token");
    	return refresh_token;
    }

    /**
     * 根据Token获取用户权限信息
     * @param token
     * @return
     */
    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser().setSigningKey(base64Secret).parseClaimsJws(token).getBody();

        Collection<? extends GrantedAuthority> authorities =
                Arrays.stream(claims.get(AUTH_HEADER).toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());

        User principal = new User(claims.getSubject(), "", authorities);

        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }
    
    /**
     * 根据Token获取Claims实体
     * @param token
     * @return
     */
    public Claims getClaims(String token) {
    	Claims claims = Jwts.parser().setSigningKey(base64Secret).parseClaimsJws(token).getBody();
    	return claims;
    }
    
    /**
     * 检查是否是有效Token
     * @param token
     * @return
     */
    public Boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(base64Secret).parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            log.trace("Expired JWT token trace: {}", e);
            return false;
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
            log.trace("Unsupported JWT token trace: {}", e);
            return false;
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
            log.trace("JWT token compact of handler are invalid trace: {}", e);
            return false;
        }
        //检查Token是否过期
    	Claims claims = getClaims(token);
    	Date created = claims.getIssuedAt();
    	return created.before(new Date());
    }
}
