package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.entyti.chitietsanpham;
import com.example.templatefinal.DB.responsitory.SanPhamresponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ServletChitietsanPham", value = "/cart/details")
public class ServletChitietsanPham extends HttpServlet {
    SanPhamresponsitory sanPhamresponsitory = new SanPhamresponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
        String url = request.getRequestURI();
        if(url.contains("/cart/details")){
            String id = (request.getParameter("id"));
         chitietsanpham ctsp = details(id);
         request.setAttribute("ctsp", ctsp);
            request.getRequestDispatcher("/view/DetailSanPham.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected chitietsanpham details(String id) {
        ArrayList<chitietsanpham> chitietsanphams = sanPhamresponsitory.getAll();

        for (chitietsanpham ctsp : chitietsanphams
        ) {
            if (ctsp.getId().equals(UUID.fromString(id))) {
                return ctsp;
            }


        }
        return null;
    }
}
