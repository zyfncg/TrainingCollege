package security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ZhangYF on 2017/3/16.
 */
public class LoginPageStrategy {
    public void process(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String targetUrl = null;
        String uri = request.getRequestURI();

        if (uri.contains("/student/")) {
            targetUrl = "/login/student";
        } else if(uri.contains("/institution/")){
            targetUrl = "/login/institution";
        }else if(uri.contains("/TCManager/")){
            targetUrl = "/login/TCManager";
        }

        targetUrl = request.getContextPath() + targetUrl;
        response.sendRedirect(targetUrl);
    }
}
