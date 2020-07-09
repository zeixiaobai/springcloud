package org.springcloud.template;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 用户注册中心
 */
@SpringBootApplication
// 开启事务支持 在需要事务支持的类和方法上添加@Transactional
@EnableTransactionManagement
public class UserCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication.class, args);
    }

}
