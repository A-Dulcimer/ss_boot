package com.qiu.utils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.jsonwebtoken.*;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@ConfigurationProperties(prefix = "jwt.token")
public class JwtHelper {
    //有效时间,单位毫秒 1000毫秒 == 1秒
    private long tokenExpiration;
    //当前程序签名秘钥
    private String tokenSignKey;
    //生成token
    public String createToken(Long userId){
        String token = Jwts.builder().setSubject("YYGH-USER")
//                1分钟
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration * 1000 * 60))
                //存放数据
                .claim("userId", userId)
                //签名，当用户请求时携带token，根据签名判断身份是否通过
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }
    //当用户请求中携带token时，从token中获取数据（useId）
    public Long getUserId(String token){
        //StringUtils的包为com.baomidou.mybatisplus.core.toolkit.StringUtils;
        if (StringUtils.isEmpty(token))return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer) claims.get("userId");
        return userId.longValue();
    }
    //判断token是否有效
    public boolean isExpiration(String token){
        try {
            boolean isExpire = Jwts.parser()
                    .setSigningKey(tokenSignKey)
                    .parseClaimsJws(token)
                    .getBody()
                    .getExpiration().before(new Date());
            //没有过期，有效，返回false
            return isExpire;
        }catch (Exception e){
            //过期，返回true
            return true;
        }
    }

}
