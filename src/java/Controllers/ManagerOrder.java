/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers;

import DAL.DAOOrder;
import Models.Order;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;

/**
 *
 * @author HP
 */
@WebServlet(name="ManagerOrder", urlPatterns={"/Order"})
public class ManagerOrder extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ManagerOrder</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ManagerOrder at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String service = request.getParameter("Service");
        DAOOrder dob = new DAOOrder();
        if(service == null) {
            String[] listStatus = new String[]{"wait", "process", "done"};
            Vector<Order> listOrder = dob.getAllOrder();
            request.setAttribute("listOrder", listOrder);
            request.setAttribute("listStatus", listStatus);
            request.getRequestDispatcher("/Views/ManagerOrder.jsp").forward(request, response);
            return;
        }
        if(service.equals("changeStatus")) {
         String OrderID = request.getParameter("OrderID");
         String status = request.getParameter("status");
         int OrderId = Integer.parseInt(OrderID);
          dob.changeStatus(status, OrderId);
          response.sendRedirect("Order");
          return;
        }
       if(service.equals("filterByStatus")) {
          String status = request.getParameter("OrderStatus");
          Vector<Order> listOrders = new Vector<>();
             for (Order order : dob.getAllOrder()) {
                 if(order.getStatus().equals(status)) {
                  listOrders.add(order);
                 }
             }
            request.setAttribute("listOrder", listOrders);
            request.getRequestDispatcher("/Views/ManagerOrder.jsp").forward(request, response);
         }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
