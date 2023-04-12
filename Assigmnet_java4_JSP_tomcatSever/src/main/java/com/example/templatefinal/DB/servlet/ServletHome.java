package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.entyti.chitietsanpham;
import com.example.templatefinal.DB.entyti.giohangchitiet;
import com.example.templatefinal.DB.responsitory.GioHangResponsitory;
import com.example.templatefinal.DB.responsitory.SanPhamresponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ServletHome", value = "/trang-chu")
public class ServletHome extends HttpServlet {
    SanPhamresponsitory sanPhamresponsitory = new SanPhamresponsitory();
    GioHangResponsitory gioHangResponsitory = new GioHangResponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String maKh = (String) session.getAttribute("user");
        ArrayList<chitietsanpham> chitietsanphamArrayList = sanPhamresponsitory.getAll();
        ArrayList<giohangchitiet> giohangchitietArrayList = gioHangResponsitory.getAll(maKh);
        session.setAttribute("dem",giohangchitietArrayList.size());
        request.setAttribute("chitietsanphamArrayList", chitietsanphamArrayList);
        request.getRequestDispatcher("/view/home.jsp").include(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
