package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.responsitory.NhanVienResponitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletLoginAdmin", value = "/admin/login/hien-thi")
public class ServletLoginAdmin extends HttpServlet {
    NhanVienResponitory nhanVienResponitory = new NhanVienResponitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();


        if (url.contains("/admin/login/hien-thi")) {

            request.getRequestDispatcher("/view_admin/LoginAdmin.jsp").include(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("pass");

        if(nhanVienResponitory.FindNV(user,pass)==null){
            HttpSession sessionAdmin = request.getSession();
            sessionAdmin.setAttribute("error", "Login unsuccessful!");
            response.sendRedirect("/view_admin/LoginAdmin.jsp");
        } else{
            HttpSession sessionAdmin =  request.getSession();
            sessionAdmin.setAttribute("userAdmin",user);
            sessionAdmin.setAttribute("passAdmin",pass);
            sessionAdmin.setAttribute("isLoggedIn", true);
            response.sendRedirect("/NhanVien/hien-thi");
        }

    }
}
