package servlets;


import dao.RentDao;
import entity.Rent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Rent/RentManage")
public class RentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "getdata";
        }
        switch (method) {
            case "getdata":
                try {

                    List<Rent> list = RentDao.getdata();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/Rent/RentManage.jsp").forward(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "deleteByRID":
                String RID = req.getParameter("RID");
                try {
                    RentDao.deleteByRID(RID);
                    resp.sendRedirect("/Rent/RentManage");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "findByRID":
                RID = req.getParameter("RID");
                try {
                    req.setAttribute("Rent",RentDao.findByRID(RID));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                req.getRequestDispatcher("/Rent/Rentupdate.jsp").forward(req,resp);


        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {
            case "add":
                String fname = req.getParameter("fname");
                String EID = req.getParameter("EID");
                String expiretime = req.getParameter("expiretime");

                try {

                    RentDao.add(fname,EID,expiretime);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/Rent/RentManage");
                break;
            case "update":
                String RID = req.getParameter("RID");
                fname = req.getParameter("fname");
                EID = req.getParameter("EID");
                expiretime = req.getParameter("expiretime");
                try {
                    RentDao.update(RID,EID,fname,expiretime);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/Rent/RentManage");
                break;
            case "adminadd":
                fname = req.getParameter("fname");
                EID = req.getParameter("EID");
                expiretime = req.getParameter("expiretime");

                try {

                    RentDao.add(fname,EID,expiretime);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/view/admin2.jsp");
                break;
        }


    }
}
