package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.entyti.khachhang;
import com.example.templatefinal.DB.responsitory.KhachHangResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "ServletKhachHang", value =
        {"/User/add", "/User/form-dang-ky",
                "/User/delete", "/User/update", "/User/details",})
public class ServletKhachHang extends HttpServlet {

    KhachHangResponsitory khachHangResponsitory = new KhachHangResponsitory();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("form-dang-ky")) {
            ArrayList<khachhang> khachhangArrayList = khachHangResponsitory.getAll();
            request.setAttribute("khachhangArrayList", khachhangArrayList);
            request.getRequestDispatcher("/view/khachhang.jsp").forward(request, response);
        } else if (url.contains("details")) {
            String ma = (request.getParameter("id"));
            ArrayList<khachhang> khachhangArrayList = khachHangResponsitory.getAll();
            request.setAttribute("khachhangArrayList", khachhangArrayList);
            khachhang khachhang = details(ma);
            System.out.println(khachhang);
            String ngaySinh = dateFormat.format(khachhang.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("kh", khachhang);
            request.getRequestDispatcher("/view/Profile.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            String id = (request.getParameter("id"));
            String newID = id.substring(id.length() - 12);
            doDelete(newID, request, response);
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
        String tendem = request.getParameter("TenDem");
        String ho = request.getParameter("Ho");


        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String diachi = request.getParameter("DiaChi");
        String sdt = request.getParameter("Sdt");
        String thanhpho = request.getParameter("ThanhPho");
        String quocgia = request.getParameter("QuocGia");
        String matkhau = request.getParameter("MatKhau");
        khachhang kh = new khachhang(Ma, ten, tendem,
                ho, ngaySinh, diachi, sdt, thanhpho, quocgia, matkhau);
        khachHangResponsitory.Add(kh);
        response.sendRedirect("/Login/hien-thi");
    }

    protected void doUpdate(String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");
        String tendem = request.getParameter("TenDem");
        String ho = request.getParameter("Ho");
        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String diachi = request.getParameter("DiaChi");
        String sdt = request.getParameter("Sdt");
        String thanhpho = request.getParameter("ThanhPho");
        String quocgia = request.getParameter("QuocGia");
        String matkhau = request.getParameter("MatKhau");
        khachhang kh = new khachhang();
        kh.setMa(Ma);
        kh.setHo(ho);
        kh.setSdt(sdt);
        kh.setDiaChi(diachi);
        kh.setTen(ten);
        kh.setTenDem(tendem);
        kh.setNgaySinh(ngaySinh);
        kh.setMatKhau(matkhau);
        kh.setQuocGia(quocgia);
        kh.setThanhPho(thanhpho);
        if(khachHangResponsitory.udpate(id, kh)){
            request.setAttribute("message","update thanh cong");

            response.sendRedirect("/Login/hien-thi");
        }

    }

    protected khachhang details(String ma) {
        ArrayList<khachhang> khachhangs = khachHangResponsitory.getAll();

        for (khachhang kh : khachhangs
        ) {
            if (kh.getMa().equals(ma)) {
                return kh;
            }


        }
        return null;
    }


    protected void doDelete(String id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        khachHangResponsitory.delete(id);
//        resp.sendRedirect("/User/hien-thi");
    }
}
