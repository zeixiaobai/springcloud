package org.springcloud.template.usercenter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springcloud.template.usercenter.constant.UcErrorConstant;
import org.springcloud.template.usercenter.entity.Token;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.zxb.common.utils.JSONUtil;
import org.zxb.web.vo.Result;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * token过滤器
 *
 * @author zjx
 * @date 2020/7/31 0031 15:21
 */
@Component
@Slf4j
public class TokenFilter implements Filter {

    @Resource(name = "tokenMap")
    private Map<String, Token> tokenMap;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String token = req.getHeader("Auto-Token");
        String uri = req.getRequestURI();
        log.info("请求路径： " + uri);
        // 是否允许不校验token
        AntPathMatcher matcher = new AntPathMatcher();
        if (matcher.match("/swagger*/**", uri)
                || matcher.match("/webjars/**", uri)
                || matcher.match("//v2/api-docs", uri)
                || matcher.match("/user/login", uri)
        ) {
            MyServletResponseWrapper myServletResponseWrapper = new MyServletResponseWrapper(resp);
            chain.doFilter(request, myServletResponseWrapper);
            String responseStr = new String(myServletResponseWrapper.getBaos().toByteArray(), response.getCharacterEncoding());

            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(responseStr);
            return;
        }
        if (token == null) {
            resp.setHeader("Content-Type", "application/json;charset=utf-8");
            response.getWriter().println(JSONUtil.toJSONString(Result.buildFail(UcErrorConstant.USER_NOT_LOGIN_ERROR, "请登录")));
            return;
        }
        // token不为空校验token
        Token tokenBean = tokenMap.get(token);
        if (tokenBean != null) {
            if (System.currentTimeMillis() - tokenBean.getExpireTime() <= 1000 * 60 * 5) {
                tokenBean.setExpireTime(System.currentTimeMillis());
                chain.doFilter(request, response);
                return;
            }
            // 过期移除该token
            tokenMap.remove(token);
        }
        resp.setHeader("Content-Type", "application/json;charset=utf-8");
        response.getWriter().println(JSONUtil.toJSONString(Result.buildFail(UcErrorConstant.USER_NOT_LOGIN_ERROR, "请登录")));
    }

    @Override
    public void destroy() {

    }

}
