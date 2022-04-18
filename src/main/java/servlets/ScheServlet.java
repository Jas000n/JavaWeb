package servlets;

import dao.ScheDao;
import entity.Sche;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Sche/ScheManage")
public class ScheServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "getdata";
        }
        switch (method) {
            case "getdata":
                try {

                    List<Sche> list = ScheDao.getdata();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/Sche/ScheManage.jsp").forward(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "deleteBySID":
                String SID = req.getParameter("SID");
                try {
                    ScheDao.deleteBySID(SID);
                    resp.sendRedirect("/Sche/ScheManage");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "findBySID":
                SID = req.getParameter("SID");
                try {
                    req.setAttribute("Sche",ScheDao.findBySID(SID));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                req.getRequestDispatcher("/Sche/Scheupdate.jsp").forward(req,resp);


        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {
            case "add":

                String OID = req.getParameter("OID");
                String EID = req.getParameter("EID");
                String efficiency = req.getParameter("efficiency");
                try {

                    ScheDao.add(OID,EID,efficiency);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "update":
                EID = req.getParameter("EID");
                OID = req.getParameter("OID");
                efficiency = req.getParameter("efficiency");
                String SID = req.getParameter("SID");
                try {
                    ScheDao.update(SID,OID,EID,efficiency);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


        }
        resp.sendRedirect("/Sche/ScheManage");


    }
}
