package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.entyti.chucvu;
import com.example.templatefinal.DB.entyti.cuahang;
import com.example.templatefinal.DB.responsitory.CuaHangresponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ServletCuaHang", value =
        {"/CuaHang/add", "/CuaHang/hien-thi",
                "/CuaHang/delete", "/CuaHang/update", "/CuaHang/details"})
public class ServletCuaHang extends HttpServlet {

    ArrayList<String> ThanhphoArrayList = new ArrayList<>();
    ArrayList<String> quocGiaArrayList = new ArrayList<>();
    CuaHangresponsitory cuaHangresponsitory = new CuaHangresponsitory();
    public ServletCuaHang() {
        ThanhphoArrayList.add("ha noi");
        ThanhphoArrayList.add("hung yen");
        ThanhphoArrayList.add("hai phong");
        ThanhphoArrayList.add("ha nam");
        quocGiaArrayList.add("viet nam");
        quocGiaArrayList.add("lao");


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            ArrayList<cuahang> cuahangArrayList = cuaHangresponsitory.getAll();
            request.setAttribute("cuahangArrayList", cuahangArrayList);
            request.setAttribute("ThanhphoArrayList", ThanhphoArrayList);
            request.setAttribute("quocGiaArrayList", quocGiaArrayList);
            request.getRequestDispatcher("/view_admin/CuaHang.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            String id = (request.getParameter("id"));
            String newID = id.substring(id.length() - 12);
            doDelete(newID, request, response);
        } else if (url.contains("details")) {
            String id = (request.getParameter("id"));
            ArrayList<cuahang> cuahangArrayList = cuaHangresponsitory.getAll();
            request.setAttribute("cuahangArrayList", cuahangArrayList);
            request.setAttribute("ThanhphoArrayList", ThanhphoArrayList);
            request.setAttribute("quocGiaArrayList", quocGiaArrayList);
            cuahang ch = details(id);
            request.setAttribute("ch", ch);
            request.getRequestDispatcher("/view_admin/CuaHang.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI();
        if (action.contains("add")) {
            try {
                doAdd(request, response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (action.contains("update")) {
            String Id = (request.getParameter("Id"));
            String newID = Id.substring(Id.length() - 12);
            doUpdate(newID, request, response);
        }
    }
    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {


        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");
        String quocgia = request.getParameter("quocgia");
        String thanhpho = request.getParameter("thanhpho");
        String diachi = request.getParameter("diachi");
        cuahang ch = new cuahang(Ma, ten,diachi,thanhpho,quocgia);
        cuaHangresponsitory.Add(ch);
        response.sendRedirect("/CuaHang/hien-thi");
    }

    protected void doUpdate(String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("Ma") == null) {
            request.getSession().setAttribute("error", "ma dang trong cu nhap vao di");
            request.getRequestDispatcher("/view_admin/CuaHang.jsp").forward(request, response);
            return;
        }

        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");
        String quocgia = request.getParameter("quocgia");
        String thanhpho = request.getParameter("thanhpho");
        String diachi = request.getParameter("diachi");
        cuahang ch = new cuahang();
        ch.setTen(ten);
        ch.setMa(Ma);
        ch.setDiaChi(diachi);
        ch.setQuocGia(quocgia);
        ch.setThanhPho(thanhpho);
        cuaHangresponsitory.udpate(id, ch);
        response.sendRedirect("/CuaHang/hien-thi");
    }

    protected cuahang details(String id) {
        ArrayList<cuahang> cuahangs = cuaHangresponsitory.getAll();

        for (cuahang ch : cuahangs
        ) {
            if (ch.getId().equals(UUID.fromString(id))) {
                return ch;
            }


        }
        return null;
    }


    protected void doDelete(String id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cuaHangresponsitory.delete(id);
        resp.sendRedirect("/CuaHang/hien-thi");
    }
}
