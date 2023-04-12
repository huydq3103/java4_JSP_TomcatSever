package com.example.templatefinal.DB.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "FilterLogin",urlPatterns = "/*")
public class FilterLogin implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        HttpSession session = httpServletRequest.getSession();
        String url = httpServletRequest.getRequestURI();
        if(session.getAttribute("user") != null && url.equals("/Login/hien-thi") ){
            httpServletResponse.sendRedirect("/trang-chu");
        }
        else{

            chain.doFilter(request, response);
        }
    }
}
