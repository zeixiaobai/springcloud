package org.springcloud.template.usercenter.configuration;

import org.springcloud.template.usercenter.filter.TokenFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置
 *
 * @author zjx
 * @date 2020/7/31 0031 15:24
 */
@Configuration
public class FilterConfig {

    /**
     * 服务过滤器注册
     *
     * @param filter token拦截器
     * @return {@link FilterRegistrationBean}
     * @author zjx
     * @date 2020/09/15 14:16
     */
    @Bean
    public FilterRegistrationBean registration(TokenFilter filter) {
        FilterRegistrationBean bean = new FilterRegistrationBean(filter);
        bean.addUrlPatterns("/*");
        // 排序
        bean.setOrder(1);
        return bean;
    }

}
