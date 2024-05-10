package com.qiu.test;

import com.qiu.utils.JwtHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JwtTest {
    @Autowired
    private JwtHelper jwtHelper;
    @Test
    public void test() throws InterruptedException {
        //生成数据 用户数据 userId 1L
        String token = jwtHelper.createToken(1L);
        System.out.println("token = " + token);
        //解析用户标识
        Long userId = jwtHelper.getUserId(token);
        System.out.println("userId = " + userId);
        //查看token是否过期 false 未到期 true到期
        boolean expiration = jwtHelper.isExpiration(token);;
        System.out.println("expiration = " + expiration);
        Thread.sleep(1000*60);
        System.out.println(" 程序睡眠一分钟后: ");
        //查看token是否过期 false 未到期 true到期
        boolean expiration1 = jwtHelper.isExpiration(token);;
        System.out.println("expiration = " + expiration1);
    }
}
