package com.example.templatefinal.DB.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLogout", value = "/logout")
public class ServletLogout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if(url.contains("logout")) {
            HttpSession session = request.getSession(false);
            session.setAttribute("isLoggedIn", false);
             session.invalidate();
            // Chuyển hướng đến trang đăng nhập
            response.sendRedirect("/trang-chu");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
