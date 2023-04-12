package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.entyti.chucvu;
import com.example.templatefinal.DB.entyti.mausac;
import com.example.templatefinal.DB.responsitory.MauSacResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ServletMauSac",  value =
        {"/MauSac/add", "/MauSac/hien-thi",
                "/MauSac/delete", "/MauSac/update", "/MauSac/details"})
public class ServletMauSac extends HttpServlet {
      MauSacResponsitory mauSacResponsitory = new MauSacResponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            ArrayList<mausac> mausacArrayList = mauSacResponsitory.getAll();
            request.setAttribute("mausacArrayList", mausacArrayList);
            request.getRequestDispatcher("/view_admin/MauSac.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            String id = (request.getParameter("id"));
            String newID = id.substring(id.length() - 12);
            doDelete(newID, request, response);
        } else if (url.contains("details")) {
            String id = (request.getParameter("id"));
            ArrayList<mausac> mausacArrayList = mauSacResponsitory.getAll();
            request.setAttribute("mausacArrayList", mausacArrayList);
            mausac ms = details(id);
            request.setAttribute("ms", ms);
            request.getRequestDispatcher("/view_admin/MauSac.jsp").forward(request, response);

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
        mausac ms = new mausac(Ma,ten);
        mauSacResponsitory.Add(ms);
        response.sendRedirect("/MauSac/hien-thi");
    }

    protected void doUpdate(String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");

        mausac ms = new mausac();
        ms.setTen(ten);
        ms.setMa(Ma);
        mauSacResponsitory.udpate(id, ms);
        response.sendRedirect("/MauSac/hien-thi");
    }

    protected mausac details(String id) {
        ArrayList<mausac> mausacs = mauSacResponsitory.getAll();

        for (mausac ms : mausacs
        ) {
            if (ms.getId().equals(UUID.fromString(id))) {
                return ms;
            }


        }
        return null;
    }


    protected void doDelete(String id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mauSacResponsitory.delete(id);
        resp.sendRedirect("/MauSac/hien-thi");
    }
}
