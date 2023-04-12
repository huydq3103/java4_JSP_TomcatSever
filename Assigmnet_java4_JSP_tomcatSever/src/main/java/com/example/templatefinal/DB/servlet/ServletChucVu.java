package com.example.templatefinal.DB.servlet;

import com.example.templatefinal.DB.entyti.chucvu;
import com.example.templatefinal.DB.responsitory.ChucVuRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "ServletChucVu", value =
        {"/ChucVu/add", "/ChucVu/hien-thi",
                "/ChucVu/delete", "/ChucVu/update", "/ChucVu/details"})
public class ServletChucVu extends HttpServlet {
    ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            ArrayList<chucvu> chucvuArrayList = chucVuRepository.getAll();
            request.setAttribute("chucvuArrayList", chucvuArrayList);
            request.getRequestDispatcher("/view_admin/ChucVu.jsp").forward(request, response);
        } else if (url.contains("delete")) {
            String id = (request.getParameter("id"));
            String newID = id.substring(id.length() - 12);
            doDelete(newID, request, response);
        } else if (url.contains("details")) {
            String id = (request.getParameter("id"));
            ArrayList<chucvu> chucvuArrayList = chucVuRepository.getAll();
            request.setAttribute("chucvuArrayList", chucvuArrayList);
            chucvu cv = details(id);
            request.setAttribute("cv", cv);
            request.getRequestDispatcher("/view_admin/ChucVu.jsp").forward(request, response);

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
        chucvu cv = new chucvu(Ma, ten);
        chucVuRepository.Add(cv);
        response.sendRedirect("/ChucVu/hien-thi");
    }

    protected void doUpdate(String id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String Ma = request.getParameter("Ma");
        String ten = request.getParameter("Ten");

        chucvu cv = new chucvu();
        cv.setTen(ten);
        cv.setMa(Ma);
        chucVuRepository.udpate(id, cv);
        response.sendRedirect("/ChucVu/hien-thi");
    }

    protected chucvu details(String id) {
        ArrayList<chucvu> chucvus = chucVuRepository.getAll();

        for (chucvu cv : chucvus
        ) {
            if (cv.getId().equals(UUID.fromString(id))) {
                return cv;
            }


        }
        return null;
    }


    protected void doDelete(String id, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        chucVuRepository.delete(id);
        resp.sendRedirect("/ChucVu/hien-thi");
    }
}
