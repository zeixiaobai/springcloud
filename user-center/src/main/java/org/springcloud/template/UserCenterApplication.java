package org.springcloud.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 用户服务中心
 *
 * @author zjx
 * @date 2020-07-10 15:22:56
 */
@SpringBootApplication
@EnableTransactionManagement
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

}
