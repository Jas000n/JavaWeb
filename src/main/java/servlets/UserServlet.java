package servlets;


import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/User/UserManage")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "getdata";
        }
        switch (method) {
            case "getdata":
                try {

                    List<User> list = UserDao.getdata();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/User/UserManage.jsp").forward(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "deleteByUID":
                String UID = req.getParameter("UID");
                try {
                    UserDao.deleteByUID(UID);
                    resp.sendRedirect("/User/UserManage");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "findByUID":
                UID = req.getParameter("UID");
                try {
                    req.setAttribute("User",UserDao.findByUID(UID));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                req.getRequestDispatcher("/User/Userupdate.jsp").forward(req,resp);


        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {
            case "add":
                String password = req.getParameter("password");
                String address = req.getParameter("address");
                String phonenumber = req.getParameter("phonenumber");
                String actor = req.getParameter("actor");
                try {

                    UserDao.add(password,address,phonenumber,actor);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "update":
                String UID = req.getParameter("UID");
                password = req.getParameter("password");
                address = req.getParameter("address");
                actor = req.getParameter("actor");
                phonenumber = req.getParameter("phonenumber");
                try {
                    UserDao.update(UID,password,address,phonenumber,actor);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


        }
        resp.sendRedirect("/User/UserManage");


    }
}
