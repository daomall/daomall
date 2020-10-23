package io.daosoft.daomall.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticateInterceptor implements HandlerInterceptor {

    protected final String guard;

    public AuthenticateInterceptor(String guard) {
        this.guard = guard;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // HttpSession session = request.getSession();

//        if (session.getAttribute(guard + Constant.AUTH_ID) == null) {
//            // 用户未登录
//            String redirectUrl = guard.equals("user") ? "login" : guard + "/login";
//            String callback = URLUtil.encodeQuery(request.getRequestURL().toString());
//            response.sendRedirect("/" + redirectUrl + "?callback=" + callback);
//
//            return false;
//        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}