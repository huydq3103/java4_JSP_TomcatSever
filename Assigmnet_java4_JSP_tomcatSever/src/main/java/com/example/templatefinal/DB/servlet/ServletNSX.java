package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.entyti.chucvu;
import com.example.templatefinal.DB.entyti.mausac;
import com.example.templatefinal.DB.entyti.nsx;
import com.example.templatefinal.DB.responsitory.NhaSanXuatResponsitory;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ServletNSX", value =
        {"/NSX/add", "/NSX/hien-thi",
                "/NSX/delete", "/NSX/update", "/NSX/details"})
public class ServletNSX extends HttpServlet {

            NhaSanXuatResponsitory nhaSanXuatResponsitory = new NhaSanXuatResponsitory();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            ArrayList<nsx> nsxArrayList = nhaSanXuatResponsitory.getAll();
            request.setAttribute("nsxArrayList", nsxArrayList);
            request.getRequestDispatcher("/view_admin/NSX.jsp").include(request,response);
        } else if (url.contains("delete")) {
            String id = (request.getParameter("id"));
            String newID = id.substring(id.length() - 12);
            doDelete(newID, request, response);
        } else if (url.contains("details")) {
            String id = (request.getParameter("id"));
            ArrayList<nsx> nsxArrayList = nhaSanXuatResponsitory.getAll();
            request.setAttribute("nsxArrayList", nsxArrayList);
            nsx nsx = details(id);
            request.setAttribute("nsx", nsx);
            request.getRequestDispatcher("/view_admin/NSX.jsp").include(request,response);

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
        nsx nsx = new nsx(Ma,ten);
        nhaSanXuatResponsitory.Add(nsx);
        response.sendRedirect("/NSX/hien-thi");
    }

    protected void doUpdate(String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");

        nsx nsx = new nsx();
        nsx.setTen(ten);
        nsx.setMa(Ma);
        nhaSanXuatResponsitory.udpate(id, nsx);
        response.sendRedirect("/NSX/hien-thi");
    }

    protected nsx details(String id) {
        ArrayList<nsx> nsxes = nhaSanXuatResponsitory.getAll();

        for (nsx nsx : nsxes
        ) {
            if (nsx.getId().equals(UUID.fromString(id))) {
                return nsx;
            }


        }
        return null;
    }


    protected void doDelete(String id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        nhaSanXuatResponsitory.delete(id);
        resp.sendRedirect("/NSX/hien-thi");
    }
}
