package servlets;

import dao.BidDao;
import entity.Bid;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Bid/BidManage")
public class BidServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (method == null) {
            method = "getdata";
        }
        switch (method) {
            case "getdata":
                try {

                    List<Bid> list = BidDao.getdata();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/Bid/BidManage.jsp").forward(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "deleteByBID":
                String BID = req.getParameter("BID");
                try {
                    BidDao.deleteByBID(BID);
                    resp.sendRedirect("/Bid/BidManage");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "findByBID":
                BID = req.getParameter("BID");
                try {
                    req.setAttribute("Bid",BidDao.findByBID(BID));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                req.getRequestDispatcher("/Bid/Bidupdate.jsp").forward(req,resp);
                break;
            case "select":
                try {

                    List<Bid> list = BidDao.getdata();
                    req.setAttribute("list", list);
                    req.getRequestDispatcher("/Bid/Bidselect.jsp").forward(req, resp);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "selectByBID":
                BID = req.getParameter("BID");
                try {
                    BidDao.selectByBID(BID);
                    resp.sendRedirect("/view/agency2.jsp");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method) {
            case "add":

                String fname = req.getParameter("fname");
                String OID = req.getParameter("OID");
                String price = req.getParameter("price");
                try {

                    BidDao.add(fname,OID,price);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/Bid/BidManage");
                break;
            case "update":
                String BID = req.getParameter("BID");
                fname = req.getParameter("fname");
                OID = req.getParameter("OID");
                String status = req.getParameter("status");
                price = req.getParameter("price");
                try {
                    BidDao.update(BID,fname,OID,status,price);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/Bid/BidManage");
                break;
            case "adminadd":
                fname = req.getParameter("fname");
                OID = req.getParameter("OID");
                price = req.getParameter("price");
                try {

                    BidDao.add(fname,OID,price);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                resp.sendRedirect("/view/admin2.jsp");
        }



    }
}
