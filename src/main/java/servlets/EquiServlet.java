package servlets;

import dao.EquiDao;
import entity.Equi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Equi/EquiManage")
public class EquiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "getdata";
        }
        switch (method) {
            case "getdata":
                try {

                    List<Equi> list = EquiDao.getdata();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/Equi/EquiManage.jsp").forward(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "deleteByEID":
                String EID = req.getParameter("EID");
                try {
                    EquiDao.deleteByEID(EID);
                    resp.sendRedirect("/Equi/EquiManage");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "findByEID":
                EID = req.getParameter("EID");
                try {
                    req.setAttribute("Equi",EquiDao.findByEID(EID));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                req.getRequestDispatcher("/Equi/Equiupdate.jsp").forward(req,resp);


        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {
            case "add":
                String rentstatus = req.getParameter("rentstatus");
                String runstatus = req.getParameter("runstatus");
                String type = req.getParameter("type");
                try {

                    EquiDao.add(rentstatus, runstatus, type);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "update":
                String EID = req.getParameter("EID");
                rentstatus = req.getParameter("rentstatus");
                runstatus = req.getParameter("runstatus");
                type = req.getParameter("type");
                try {
                    EquiDao.update(EID,rentstatus,runstatus,type);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


        }
        resp.sendRedirect("/Equi/EquiManage");


    }
}
