package com.Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        String loginURI = req.getContextPath() + "Login/login.jsp";
        String registerURI = req.getContextPath() + "/register.jsp";
        boolean loggedIn = (session != null && session.getAttribute("user") != null);
        boolean loginRequest = req.getRequestURI().equals(loginURI) || req.getRequestURI().equals(registerURI);
        boolean isPublicResource = req.getRequestURI().endsWith(".css") || req.getRequestURI().endsWith(".js");

        if (loggedIn || loginRequest || isPublicResource) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(loginURI);
        }
    }
}
