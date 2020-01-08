package com.xxh.mymall.Interceptor;

import com.xxh.mymall.entity.User;
import com.xxh.mymall.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class SessionInterceptor implements HandlerInterceptor {
    @Resource
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[]cookies=request.getCookies();
        if(cookies!=null&&cookies.length!=0){
            for (Cookie cookie:cookies){
                if(cookie.getName().equals("userId")){
                    String uid = cookie.getValue();
                    User user = userService.getById(uid);
                    if(user!=null){
                        request.getSession().setAttribute("user",user);
                    }
                }
            }

        }
        return true;
    }
}
