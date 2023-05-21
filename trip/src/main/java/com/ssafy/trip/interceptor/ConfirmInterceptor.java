package com.ssafy.trip.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.trip.member.dto.Member;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ConfirmInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        Member user = (Member) session.getAttribute("userinfo");
        if(user == null) {
            response.sendRedirect(request.getContextPath() + "/member/login");
            return false;
        }
        return true;
    }
}
