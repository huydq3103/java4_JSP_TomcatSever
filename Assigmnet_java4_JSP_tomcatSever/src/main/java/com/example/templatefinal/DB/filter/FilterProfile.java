package com.example.templatefinal.DB.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "FilterProfile",urlPatterns = "/*")

public class FilterProfile implements Filter {
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
         if(session.getAttribute("user") == null && url.equals("/User/details") ){
             httpServletResponse.sendRedirect("/Login/hien-thi");
         }else{

             chain.doFilter(request, response);
         }

    }
}
