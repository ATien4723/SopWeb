/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import DAL.DAOOrder;
import DAL.DAOOrderItem;
import Models.Account;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "CartServlet", urlPatterns = {"/cart"})
public class CartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //create constant ship price
            DAO dp = new DAO();
            DAOOrder dOrder = new DAOOrder();
            HttpSession session = request.getSession();

            String service = request.getParameter("Service");

            if (service == null) {
                java.util.Enumeration em = session.getAttributeNames();
                int numOrder = 0;
                while (em.hasMoreElements()) {
                     String id = em.nextElement().toString();
                        if (id.startsWith("key")) {
                            Product pro_session = (Product) session.getAttribute(id);
                            numOrder+=pro_session.getQuantity();
                    }
                }
                session.setAttribute("numOrder", numOrder);
                request.getRequestDispatcher("Views/Cart.jsp").forward(request, response);
                return;
            }
            //if add to cart check have cart exist before
            if (service.equals("addToCart")) {
                String pid_raw = request.getParameter("product_id");
                String key = "key-" + pid_raw;
                //san pham luu o dang key va value
                String quantity_raw = request.getParameter("quantity");
                int pid = Integer.parseInt(pid_raw);
                int quantity = Integer.parseInt(quantity_raw);

                Product p = (Product) session.getAttribute(key);
                //IF DONT EXIST will store to the session a new product
                if (p == null) {
                    Product p_root = dp.getProductById(pid);
                    Product pAdd = new Product(
                            pid,
                            p_root.getDiscount(),
                            p_root.getProduct_name(),
                            p_root.getProduct_img(),
                            p_root.getCategory_name(),
                            p_root.getPrice_import(),
                            p_root.getPrice_sell(),
                            quantity,
                            p_root.getBrand()
                    );
                    session.setAttribute(key, pAdd);
                } else {
                    //IF HAVE EXIST get old product in session and change quantity
                    Product pAdd = new Product(
                            pid,
                            p.getDiscount(),
                            p.getProduct_name(),
                            p.getProduct_img(),
                            p.getCategory_name(),
                            p.getPrice_import(),
                            p.getPrice_sell(),
                            p.getQuantity() + quantity,
                            p.getBrand()
                    );
                    session.setAttribute(key, pAdd);
                }
                response.sendRedirect("cart");
                return;
            }

            if (service.equals("add")) {
                String pid_raw = request.getParameter("product_id");
                int pid = Integer.parseInt(pid_raw);
                String key = "key-" + pid_raw;
                //sp root
                Product p_root = dp.getProductById(pid);
                Product p = (Product) session.getAttribute(key);
                int quantity = 0;
                //IF DONT EXIST
                if (p != null) {
                    if ((p.getQuantity() + 1) == p_root.getQuantity()) {
                        quantity = p_root.getQuantity();
                    } else {
                        quantity = p.getQuantity() + 1;
                    }
                    // create a new p and set in old key
                    Product pAdd = new Product(
                            pid,
                            p.getDiscount(),
                            p.getProduct_name(),
                            p.getProduct_img(),
                            p.getCategory_name(),
                            p.getPrice_import(),
                            p.getPrice_sell(),
                            quantity,
                            p.getBrand()
                    );
                    session.setAttribute(key, pAdd);
                }
                response.sendRedirect("cart");
            }
            
            if (service.equals("minus")) {
                String pid_raw = request.getParameter("product_id");
                int pid = Integer.parseInt(pid_raw);
                String key = "key-" + pid_raw;
                Product p = (Product) session.getAttribute(key);
                //IF DONT EXIST
                if (p != null) {
                    // create a new p and set in old key
                    //check is delete
                    if ((p.getQuantity() - 1) == 0) {
                        session.removeAttribute(key);
                    } else {
                        Product pAdd = new Product(
                                pid,
                                p.getDiscount(),
                                p.getProduct_name(),
                                p.getProduct_img(),
                                p.getCategory_name(),
                                p.getPrice_import(),
                                p.getPrice_sell(),
                                p.getQuantity() - 1,
                                p.getBrand()
                        );
                        session.setAttribute(key, pAdd);
                    }
                }
                response.sendRedirect("cart");
            }
            if (service.equals("remove")) {
                String pid_raw = request.getParameter("product_id");
                String key = "key-" + pid_raw;
                session.removeAttribute(key);
                response.sendRedirect("cart");
            }
            if (service.equals("removeAll")) {
                java.util.Enumeration em = session.getAttributeNames();
                while (em.hasMoreElements()) {
                    String id = em.nextElement().toString();
                    if (id.startsWith("key")) {
                        session.removeAttribute(id);
                    }
                }
                response.sendRedirect("cart");
            }
            if (service.equals("checkout")) {
            Vector<Product> listItem = new Vector<>();
            Account acc = (Account) session.getAttribute("acc");
            java.util.Enumeration em = session.getAttributeNames();
            while (em.hasMoreElements()) {
                //when get from session id is cart-id
                String id = em.nextElement().toString();
                if (id.startsWith("key")) {
                    //add product into list before remove in session
                    Product pro_session = (Product) session.getAttribute(id);
                    //get product in database but the quantity is number want to order
//                    Product pAdd = dp.getProductById(pro_session.getProduct_id());
//                    pAdd.setQuantity(pro_session.getQuantity());
                    listItem.add(pro_session);
                    session.removeAttribute(id);
                }
            }
            if(listItem.size() > 0) {
              dOrder.checkcount(acc, listItem);
//              session.setAttribute("listD", listItem);
              response.sendRedirect("cart");
            }
        }
      }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public static void main(String[] args) {
        DAOOrderItem Dod = new DAOOrderItem();
         int newOrderItemId = Dod.getAllOrderItem().get(Dod.getAllOrderItem().size() - 1).getItem_id() + 1;
         System.out.println(newOrderItemId);
    }
}
