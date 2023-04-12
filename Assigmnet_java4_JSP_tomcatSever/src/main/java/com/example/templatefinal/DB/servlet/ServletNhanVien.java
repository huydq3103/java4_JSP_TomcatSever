package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.entyti.chucvu;
import com.example.templatefinal.DB.entyti.cuahang;
import com.example.templatefinal.DB.entyti.nhanvien;
import com.example.templatefinal.DB.responsitory.ChucVuRepository;
import com.example.templatefinal.DB.responsitory.CuaHangresponsitory;
import com.example.templatefinal.DB.responsitory.NhanVienResponitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "ServletNhanVien", value = {"/NhanVien/hien-thi",
        "/NhanVien/add", "/NhanVien/update",
        "/NhanVien/delete", "/NhanVien/details"
})
public class ServletNhanVien extends HttpServlet {
    NhanVienResponitory nhanVienResponitory = new NhanVienResponitory();
    CuaHangresponsitory cuaHangresponsitory = new CuaHangresponsitory();
    ChucVuRepository chucVuRepository = new ChucVuRepository();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("/NhanVien/hien-thi")) {
            ArrayList<chucvu> chucvuArrayList = chucVuRepository.getAll();
            ArrayList<cuahang> cuahangArrayList = cuaHangresponsitory.getAll();
            ArrayList<nhanvien> nhanvienArrayList = nhanVienResponitory.getAll();
            request.setAttribute("nhanvienArrayList", nhanvienArrayList);
            request.setAttribute("chucvuArrayList", chucvuArrayList);
            request.setAttribute("cuahangArrayList", cuahangArrayList);
            request.getRequestDispatcher("/view_admin/NhanVien.jsp").forward(request, response);
        } else if (url.contains("details")) {
            ArrayList<chucvu> chucvuArrayList = chucVuRepository.getAll();
            ArrayList<cuahang> cuahangArrayList = cuaHangresponsitory.getAll();
            ArrayList<nhanvien> nhanvienArrayList = nhanVienResponitory.getAll();
            UUID id = UUID.fromString(request.getParameter("id"));
            nhanvien nv = doDetails(id);
            String ngaySinh = dateFormat.format(nv.getNgaySinh());
            request.setAttribute("ngaySinh", ngaySinh);
            request.setAttribute("nv", nv);
            request.setAttribute("nhanvienArrayList", nhanvienArrayList);
            request.setAttribute("chucvuArrayList", chucvuArrayList);
            request.setAttribute("cuahangArrayList", cuahangArrayList);
            request.getRequestDispatcher("/view_admin/NhanVien.jsp").forward(request, response);
        }else if (url.contains("delete")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            doDelete(id, request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI();
        if (action.contains("add")) {
            doAdd(request, response);
        } else if (action.contains("update")) {
            UUID id = UUID.fromString(request.getParameter("Id"));
            doUpdate(id, request, response);
        }
    }

    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");
        String tendem = request.getParameter("TenDem");
        String ho = request.getParameter("Ho");
        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("NgaySinh"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String diachi = request.getParameter("DiaChi");
        String sdt = request.getParameter("Sdt");
        String Gioitinh = request.getParameter("GioiTinh");
        cuahang ch = nhanVienResponitory.getOneCH(request.getParameter("cuahang"));
        chucvu cv = nhanVienResponitory.getOneCV(request.getParameter("chucvu"));
        Integer trangthai = Integer.parseInt(request.getParameter("trangthai"));
        String matkhau = request.getParameter("MatKhau");
        nhanvien nv = new nhanvien(Ma, ten, tendem, ho, Gioitinh, ngaySinh, diachi, sdt, matkhau, trangthai, ch, cv);
        nhanVienResponitory.Add(nv);
        response.sendRedirect("/NhanVien/hien-thi");
    }

    protected void doUpdate(UUID id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");
        String tendem = request.getParameter("TenDem");
        String ho = request.getParameter("Ho");
        Date ngaySinh;
        try {
            ngaySinh = dateFormat.parse(request.getParameter("NgaySinh"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        String diachi = request.getParameter("DiaChi");
        String sdt = request.getParameter("Sdt");
        String Gioitinh = request.getParameter("GioiTinh");
        cuahang ch = nhanVienResponitory.getOneCH(request.getParameter("cuahang"));
        chucvu cv = nhanVienResponitory.getOneCV(request.getParameter("chucvu"));
        Integer trangthai = Integer.parseInt(request.getParameter("trangthai"));
        String matkhau = request.getParameter("MatKhau");
        nhanvien nv = new nhanvien(id,cv,ch,Ma,ten,tendem,ho,Gioitinh,ngaySinh,diachi,sdt,matkhau,trangthai);
        nhanVienResponitory.Update(nv);
        response.sendRedirect("/NhanVien/hien-thi");
    }

    protected void doDelete(UUID id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        nhanVienResponitory.delete(id);
        response.sendRedirect("/NhanVien/hien-thi");
    }

    protected nhanvien doDetails(UUID id) throws ServletException, IOException {

        for (nhanvien nv : nhanVienResponitory.getAll()
             ) {
                if(nv.getId().equals(id)){
                        return nv;
                }
        }
        return null;
    }
}
