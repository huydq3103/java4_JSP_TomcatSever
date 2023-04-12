package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.responsitory.KhachHangResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletLogin", value = {"/Login/hien-thi",})
public class ServletLogin extends HttpServlet {


      KhachHangResponsitory khachHangResponsitory = new KhachHangResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String url = request.getRequestURI();


            if (url.contains("hien-thi")) {

               request.getRequestDispatcher("/view/Login.jsp").include(request,response);
           }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String user = request.getParameter("username");
           String pass = request.getParameter("pass");

          if(khachHangResponsitory.FindKH(user,pass)==null){
//              PrintWriter out = response.getWriter();
//              response.setContentType("text/html");
//              out.println("<script>");
//              out.println("Swal.fire({" +
//                      "               icon: 'error'," +
//                      "               title: 'Oops...'," +
//                      "               text: 'Login unSucessful!'," +
//                      "               footer: '<a href=>Why do I have this issue?</a>'" +
//                      "           })");
//              out.println("</script>");
              HttpSession session = request.getSession();
              session.setAttribute("error", "Login unsuccessful!");
              //response.sendRedirect("/Login/hien-thi");
//              response.sendRedirect("/Login/hien-thi");


             request.getRequestDispatcher("/view/Login.jsp").include(request,response);
          } else if (user.equals("admin") && pass.equals("admin")) {
              HttpSession sessionAdmin =  request.getSession();
              sessionAdmin.setAttribute("userAdmin",user);
              sessionAdmin.setAttribute("passAdmin",pass);
              response.sendRedirect("/NhanVien/hien-thi");
          } else{
              HttpSession session =  request.getSession();
              session.setAttribute("user",user);
              session.setAttribute("pass",pass);
              session.setAttribute("isLoggedIn", true);
              session.setMaxInactiveInterval(10*60);
              response.sendRedirect("/trang-chu");
          }
    }
}
