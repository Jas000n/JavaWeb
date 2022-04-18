package servlets;





import dao.FactDao;
import entity.Fact;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Fact/FactManage")
public class FactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "getdata";
        }
        switch (method) {
            case "getdata":
                try {

                    List<Fact> list = FactDao.getdata();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/Fact/FactManage.jsp").forward(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "deleteByfname":
                String fname = req.getParameter("fname");
                try {
                    FactDao.deleteByfname(fname);
                    resp.sendRedirect("/Fact/FactManage");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "findByfname":
                fname = req.getParameter("fname");
                try {
                    req.setAttribute("Fact",FactDao.findByfname(fname));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                req.getRequestDispatcher("/Fact/Factupdate.jsp").forward(req,resp);


        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {
            case "add":
                String fname = req.getParameter("fname");
                String UID = req.getParameter("UID");
                String status = req.getParameter("status");

                try {

                    FactDao.add(fname,UID,status);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "update":
                fname = req.getParameter("fname");
                UID = req.getParameter("UID");
                status = req.getParameter("status");
                try {
                    FactDao.update(fname,UID,status);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


        }
        resp.sendRedirect("/Fact/FactManage");


    }
}
