package com.example.templatefinal.DB.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebFilter(filterName = "FilterError",urlPatterns = "/*")
public class FilterError implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String url = httpServletRequest.getRequestURI();
        if(url.endsWith(".html") ){
            httpServletResponse.sendRedirect("/view_error/Error_login.jsp");
        }else{
            chain.doFilter(request, response);
        }



    }
}
