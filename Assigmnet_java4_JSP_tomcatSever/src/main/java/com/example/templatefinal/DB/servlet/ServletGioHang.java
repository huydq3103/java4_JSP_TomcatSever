package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.entyti.*;
import com.example.templatefinal.DB.responsitory.GioHangResponsitory;
import com.example.templatefinal.DB.responsitory.KhachHangResponsitory;
import com.example.templatefinal.DB.responsitory.NhanVienResponitory;
import com.example.templatefinal.DB.responsitory.SanPhamresponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "ServletGioHang", value = {"/GioHang/hien-thi", "/GioHang/add","/GioHang/delete","/GioHang/remove"})
public class ServletGioHang extends HttpServlet {
    GioHangResponsitory gioHangResponsitory = new GioHangResponsitory();
    KhachHangResponsitory khachHangResponsitory = new KhachHangResponsitory();
    NhanVienResponitory nhanVienResponitory = new NhanVienResponitory();
    SanPhamresponsitory sanPhamresponsitory = new SanPhamresponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String url = request.getRequestURI();
        HttpSession session = request.getSession();
        String maKh = (String) session.getAttribute("user");
      if(url.contains("/GioHang/hien-thi")) {
          if (session.getAttribute("user") == null) { // kiem tra xem thang user nay co san pham trong gio ko
              ArrayList<giohangchitiet> giohangchitietArrayList = new ArrayList<>();
              session.setAttribute("dem",0);// ko co thi tra ve list trong
          } else {
              ArrayList<giohangchitiet> giohangchitietArrayList = gioHangResponsitory.getAll(maKh);
              session.setAttribute("dem",giohangchitietArrayList.size());
              request.setAttribute("giohangchitietArrayList", giohangchitietArrayList); // co thi show all
          }
      } else if (url.contains("delete")) {
          if (session.getAttribute("user") == null) { // kiem tra xem thang user nay co san pham trong gio ko
                   // ko co thi tra ve list trong
          } else {
              gioHangResponsitory.delete();

          }
      }else if(url.contains("remove")){
          UUID id = UUID.fromString(request.getParameter("id"));
          System.out.println(id);
          gioHangResponsitory.deleteOneSP(id);
      }

        request.getRequestDispatcher("/view/GioHang.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI();
        if (action.contains("/GioHang/add")) {
            HttpSession sessionUser = request.getSession();
            String maKh = (String) sessionUser.getAttribute("user");
            String id = request.getParameter("id");
            String idctsp = id.substring(id.length() - 12);


            Integer soLuong = Integer.valueOf(request.getParameter("quantity"));

            if (gioHangResponsitory.CheckGioHang(maKh) == null) { // check xem thang user nay da co gio hang hay chua
                doCreateGioHang(maKh, request, response); // chua thi tao
                if (gioHangResponsitory.CheckGioHang(maKh) != null) { // tao xong thi kiem tra va  them san pham vao
                    giohang gh = gioHangResponsitory.CheckGioHang(maKh);
                    chitietsanpham ctsp = sanPhamresponsitory.getOneCTSP(idctsp);
                    BigDecimal giaBan = ctsp.getGiaBan();
                    giohangchitiet ghct = new giohangchitiet(gh, ctsp, soLuong, giaBan);
                    gioHangResponsitory.AddGioHang(ghct);
                    response.sendRedirect("/GioHang/hien-thi");
                    return;
                }
            } else { // da co va chi viec them luon vao
                giohang gh = gioHangResponsitory.CheckGioHang(maKh);
                chitietsanpham ctsp = sanPhamresponsitory.getOneCTSP(idctsp);
                BigDecimal giaBan = ctsp.getGiaBan();
                giohangchitiet ghct = new giohangchitiet(gh, ctsp, soLuong, giaBan);
                gioHangResponsitory.AddGioHang(ghct);
                response.sendRedirect("/GioHang/hien-thi");
            }
        }
    }

    protected void doCreateGioHang(String ma, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.fromString("5EFA2248-7BE2-9B44-9C2A-2A8388D2D41D");
        nhanvien nhanvien = nhanVienResponitory.getOneNv(id);
        khachhang khachhang = khachHangResponsitory.GetKH(ma);
        String diachi = khachhang.getDiaChi();
        String sdt = khachhang.getSdt();
        String ten = khachhang.getTen();
        Integer tinhtrang = 1;
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 10);
        Date newDate = calendar.getTime();
        giohang gh = new giohang(khachhang, nhanvien, ma, date, newDate, tinhtrang, ten, diachi, sdt);
        gioHangResponsitory.CreateGioHang(gh);
        response.sendRedirect("/GioHang/hien-thi");
    }

}
