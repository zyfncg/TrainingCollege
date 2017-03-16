package security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.util.Assert;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ZhangYF on 2017/3/16.
 */
public class LoginPageEntryPoint implements AuthenticationEntryPoint{
    private LoginPageStrategy loginPageStrategy;

    public void afterPropertiesSet() throws Exception {
        Assert.notNull(loginPageStrategy, "loginPageStrategy must be specified");
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        loginPageStrategy.process(request, response);
    }

    public void setLoginPageStrategy(LoginPageStrategy loginPageStrategy) {
        this.loginPageStrategy = loginPageStrategy;
    }



}
