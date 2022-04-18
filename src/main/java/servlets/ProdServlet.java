package servlets;

import dao.EquiDao;
import dao.ProdDao;
import entity.Equi;
import entity.Prod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Prod/ProdManage")
public class ProdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "getdata";
        }
        switch (method) {
            case "getdata":
                try {

                    List<Prod> list = ProdDao.getdata();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/Prod/ProdManage.jsp").forward(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "deleteByPID":
                String PID = req.getParameter("PID");
                try {
                    ProdDao.deleteByPID(PID);
                    resp.sendRedirect("/Prod/ProdManage");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "findByPID":

                PID = req.getParameter("PID");
                try {
                    req.setAttribute("Prod",ProdDao.findByPID(PID));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                req.getRequestDispatcher("/Prod/Produpdate.jsp").forward(req,resp);


        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {
            case "add":
                String type = req.getParameter("type");
                try {

                    ProdDao.add(type);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "update":
                String PID = req.getParameter("PID");
                type = req.getParameter("type");
                try {
                    ProdDao.update(PID,type);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


        }
        resp.sendRedirect("/Prod/ProdManage");


    }
}
