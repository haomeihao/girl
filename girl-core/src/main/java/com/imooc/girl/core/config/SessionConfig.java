package com.imooc.girl.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by hmh on 2017/11/6.
 */
@Configuration
/**
 * maxInactiveIntervalInSecondsSession 失效时间
 * 使用Redis Session之后，原Boot的server.session.timeout属性不再生效
 *
 * redis-cli -a password
 * keys '*session*'
 * "spring:session:sessions:expires:618e2833-0c0f-4afc-928d-1006205667b9"
 * "spring:session:sessions:618e2833-0c0f-4afc-928d-1006205667b9"
 * "spring:session:expirations:1511690220000"
 */
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {
}
