package org.springcloud.template.usercenter.configuration;

import org.springcloud.template.usercenter.entity.Token;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 登录配置
 *
 * @author zjx
 * @date 2020/7/31 0031 17:19
 */
@Configuration
public class UserConfig {

    /**
     * token 集合对象
     *
     * @param
     * @return {@link Map< String,  Token >}
     * @author zjx
     * @date 2020/09/15 14:19
     */
    @Bean(name = "tokenMap")
    public Map<String, Token> registration() {
        return new ConcurrentHashMap<>();
    }

}
