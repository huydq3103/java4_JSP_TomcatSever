package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.entyti.*;
import com.example.templatefinal.DB.responsitory.DongspReposity;
import com.example.templatefinal.DB.responsitory.MauSacResponsitory;
import com.example.templatefinal.DB.responsitory.NhaSanXuatResponsitory;
import com.example.templatefinal.DB.responsitory.SanPhamresponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.persistence.Column;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@WebServlet(name = "ServletSanPham", value =
        {"/SanPham/add", "/SanPham/hien-thi",
                "/SanPham/delete", "/SanPham/update", "/SanPham/details"})
public class ServletSanPham extends HttpServlet {
    SanPhamresponsitory sanPhamresponsitory = new SanPhamresponsitory();
    NhaSanXuatResponsitory nhaSanXuatResponsitory = new NhaSanXuatResponsitory();
    DongspReposity dongspReposity = new DongspReposity();
    MauSacResponsitory mauSacResponsitory = new MauSacResponsitory();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            ArrayList<chitietsanpham> chitietsanphamArrayList = sanPhamresponsitory.getAll();
            ArrayList<nsx> nsxArrayList = nhaSanXuatResponsitory.getAll();
            ArrayList<dongsp> dongspArrayList = dongspReposity.getAll();
            ArrayList<mausac> mausacArrayList = mauSacResponsitory.getAll();
            request.setAttribute("chitietsanphamArrayList", chitietsanphamArrayList);
            request.setAttribute("nsxArrayList", nsxArrayList);
            request.setAttribute("dongspArrayList", dongspArrayList);
            request.setAttribute("mausacArrayList", mausacArrayList);
            request.getRequestDispatcher("/view_admin/SanPham.jsp").include(request, response);
        } else if (url.contains("delete")) {
                 String ma = request.getParameter("id");// id nhung truyen vao la ma sp :))
                   doDelete(ma,request,response);
        } else if (url.contains("details")) {
            String id = (request.getParameter("id"));
            ArrayList<chitietsanpham> chitietsanphamArrayList = sanPhamresponsitory.getAll();
            ArrayList<nsx> nsxArrayList = nhaSanXuatResponsitory.getAll();
            ArrayList<dongsp> dongspArrayList = dongspReposity.getAll();
            ArrayList<mausac> mausacArrayList = mauSacResponsitory.getAll();
            chitietsanpham ctsp = details(id);
            request.setAttribute("ctsp", ctsp);
            request.setAttribute("chitietsanphamArrayList", chitietsanphamArrayList);
            request.setAttribute("nsxArrayList", nsxArrayList);
            request.setAttribute("dongspArrayList", dongspArrayList);
            request.setAttribute("mausacArrayList", mausacArrayList);
            request.getRequestDispatcher("/view_admin/SanPham.jsp").include(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getRequestURI();
        if(action.contains("add")){
            try {
                doAdd(request,response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } else if (action.contains("update")) {
              String id = request.getParameter("Id");
              String idctsp = request.getParameter("IdCTSP");
            try {
                doUpdate(id,idctsp,request,response);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {


        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");
        sanpham sp = new sanpham(Ma, ten);

        nsx nsx = sanPhamresponsitory.getOneNSX(request.getParameter("nsx"));
        dongsp dsp = sanPhamresponsitory.getOneDSP(request.getParameter("dongsp"));
        mausac ms = sanPhamresponsitory.getOneMauSac(request.getParameter("mausac"));
        System.out.println(nsx);
        int nambh = Integer.parseInt(request.getParameter("nambh"));
        String MoTa = request.getParameter("mota");
        int SoLuongTon = Integer.parseInt(request.getParameter("soluongton"));
        BigDecimal GiaNhap = BigDecimal.valueOf(Long.parseLong(request.getParameter("gianhap")));
        BigDecimal giaban = BigDecimal.valueOf(Long.parseLong(request.getParameter("giaban")));

        chitietsanpham ctsp = new chitietsanpham();
        ctsp.setSanpham(sp);
        ctsp.setNsx(nsx);
        ctsp.setMausac(ms);
        ctsp.setDongsp(dsp);
        ctsp.setNamBH(nambh);
        ctsp.setSoLuongTon(SoLuongTon);
        ctsp.setGiaBan(giaban);
        ctsp.setGiaNhap(GiaNhap);
        ctsp.setMoTa(MoTa);
        sp.setChitietsanphams(Arrays.asList(ctsp));
        sanPhamresponsitory.Add(sp);
        response.sendRedirect("/SanPham/hien-thi");
    }

    protected void doUpdate(String id,String idctsp,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {


        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");
        sanpham sp = new sanpham(Ma, ten);
        sanPhamresponsitory.Update(sp,id);

        nsx nsx = sanPhamresponsitory.getOneNSX(request.getParameter("nsx"));
        dongsp dsp = sanPhamresponsitory.getOneDSP(request.getParameter("dongsp"));
        mausac ms = sanPhamresponsitory.getOneMauSac(request.getParameter("mausac"));

        int nambh = Integer.parseInt(request.getParameter("nambh"));
        String MoTa = request.getParameter("mota");
        int SoLuongTon = Integer.parseInt(request.getParameter("soluongton"));
        BigDecimal GiaNhap = BigDecimal.valueOf(Long.parseLong(request.getParameter("gianhap")));
        BigDecimal giaban = BigDecimal.valueOf(Long.parseLong(request.getParameter("giaban")));

        chitietsanpham ctsp = new chitietsanpham();
        ctsp.setNsx(nsx);
        ctsp.setMausac(ms);
        ctsp.setDongsp(dsp);
        ctsp.setNamBH(nambh);
        ctsp.setSoLuongTon(SoLuongTon);
        ctsp.setGiaBan(giaban);
        ctsp.setGiaNhap(GiaNhap);
        ctsp.setMoTa(MoTa);
        sanPhamresponsitory.UpdateChitietSP(ctsp,nsx,ms,dsp,idctsp);
        response.sendRedirect("/SanPham/hien-thi");
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
    protected void doDelete(String ma, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        sanPhamresponsitory.Remove(ma);
        resp.sendRedirect("/SanPham/hien-thi");
    }
}
