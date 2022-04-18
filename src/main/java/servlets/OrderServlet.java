package servlets;


import dao.OrderDao;
import entity.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Order/OrderManage")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "getdata";
        }
        switch (method) {
            case "getdata":
                try {

                    List<Order> list = OrderDao.getdata();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/Order/OrderManage.jsp").forward(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "deleteByOID":
                String OID = req.getParameter("OID");
                try {
                    OrderDao.deleteByOID(OID);
                    resp.sendRedirect("/Order/OrderManage");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "findByOID":
                OID = req.getParameter("OID");
                try {
                    req.setAttribute("Order",OrderDao.findByOID(OID));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                req.getRequestDispatcher("/Order/Orderupdate.jsp").forward(req,resp);


        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {
            case "add":

                String duetime = req.getParameter("duetime");
                String quantity = req.getParameter("quantity");
                String UID = req.getParameter("UID");
                String PID = req.getParameter("PID");
                try {

                    OrderDao.add(duetime,quantity,UID,PID);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/Order/OrderManage");
                break;
            case "update":
                String OID = req.getParameter("OID");
                String status = req.getParameter("status");
                duetime = req.getParameter("duetime");
                quantity = req.getParameter("quantity");
                UID = req.getParameter("UID");
                PID = req.getParameter("PID");
                try {
                    OrderDao.update(OID,status,duetime,quantity,UID,PID);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/Order/OrderManage");
                break;
            case "agencyadd":
                duetime = req.getParameter("duetime");
                quantity = req.getParameter("quantity");
                UID = req.getParameter("UID");
                PID = req.getParameter("PID");
                try {

                    OrderDao.add(duetime,quantity,UID,PID);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/view/agency2.jsp");
        }



    }
}
