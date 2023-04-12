package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.entyti.chucvu;
import com.example.templatefinal.DB.entyti.dongsp;
import com.example.templatefinal.DB.responsitory.DongspReposity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ServletDongSP", value =
        {"/DongSP/add", "/DongSP/hien-thi",
                "/DongSP/delete", "/DongSP/update", "/DongSP/details"})
   public class ServletDongSP extends HttpServlet {
               DongspReposity dongspReposity = new DongspReposity();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            ArrayList<dongsp> dongspArrayList = dongspReposity.getAll();
            request.setAttribute("dongspArrayList", dongspArrayList);
            request.getRequestDispatcher("/view_admin/dongSP.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            String id = (request.getParameter("id"));
            String newID = id.substring(id.length() - 12);
            doDelete(newID, request, response);
        } else if (url.contains("details")) {
            String id = (request.getParameter("id"));
            ArrayList<dongsp> dongspArrayList = dongspReposity.getAll();
            request.setAttribute("dongspArrayList", dongspArrayList);
            dongsp dsp = details(id);
            request.setAttribute("dsp", dsp);
            request.getRequestDispatcher("/view_admin/dongSP.jsp").forward(request, response);

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
        } else if (action.contains("/DongSP/update")) {
            String Id = (request.getParameter("Id"));
            String newID = Id.substring(Id.length() - 12);
            doUpdate(newID, request, response);
        }
    }


    protected void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {


        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");
        dongsp dsp = new dongsp(Ma, ten);
        dongspReposity.Add(dsp);
        response.sendRedirect("/DongSP/hien-thi");
    }
    protected void doUpdate(String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");

        dongsp dsp = new dongsp();
        dsp.setTen(ten);
        dsp.setMa(Ma);
        dongspReposity.udpate(id, dsp);
        response.sendRedirect("/DongSP/hien-thi");
    }

    protected dongsp details(String id) {
        ArrayList<dongsp> dongsps = dongspReposity.getAll();

        for (dongsp dsp : dongsps
        ) {
            if (dsp.getId().equals(UUID.fromString(id))) {
                return dsp;
            }


        }
        return null;
    }


    protected void doDelete(String id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dongspReposity.delete(id);
        resp.sendRedirect("/DongSP/hien-thi");
    }
}
