package servlets;


import dao.UserDao;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/view/login")
public class ViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "view";
        }
        switch (method) {
            case "view":
                req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
                break;
            case "register":
                req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
                break;



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
            case "login":
                String UID = req.getParameter("UID");
                password = req.getParameter("password");
                if(UID.equals("Jason")&&password.equals("jason"))
                {
                    req.getRequestDispatcher("/index.jsp").forward(req,resp);
                }else {
                    try {
                        if (UserDao.login(UID, password)) {
                            if (UserDao.getActor(UID).equals("agency")) {
                                req.setAttribute("UID", UID);
                                req.getRequestDispatcher("/view/agency.jsp").forward(req, resp);
                            } else if (UserDao.getActor(UID).equals("administrator")) {
                                req.setAttribute("UID",UID);
                                req.getRequestDispatcher("/view/admin.jsp").forward(req, resp);
                            }
                        } else {
                            req.getRequestDispatcher("/view/error.jsp").forward(req, resp);
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }


        }
        resp.sendRedirect("/view/login");

    }
}
