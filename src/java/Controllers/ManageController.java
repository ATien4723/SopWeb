/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import DAL.DAOOrder;
import DAL.DAOOrderItem;
import Models.Brand;
import Models.OrderItem;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ManageController", urlPatterns = {"/Manage"})
public class ManageController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        DAO d = new DAO();
        try {
            String service = request.getParameter("Service");
            if (service == null) {
                service = "getAll";
            }
            if (service.equals("getAll")) {
                Vector<Product> list = new Vector<>();
                list = d.getProductManage();
                request.setAttribute("listProduct", list);
                request.getRequestDispatcher("/Views/Admin.jsp").forward(request, response);
            }

            if (service.equals("SearchProduct")) {
                int pid = -1;
                String pId = request.getParameter("searchId");

                try {
                    if (pId != null && !pId.equals("")) {
                        pid = Integer.parseInt(pId);
                    }
                    List<Product> list = new ArrayList<>();
                    Product p = d.getProductManageById(pid);
                    if (p == null) {
                        request.setAttribute("mess", "Not found this product");
                    } else {
                        list.add(p);
                        request.setAttribute("listProduct", list);
                    }
                    request.setAttribute("SearchValue", pId);
                    request.getRequestDispatcher("Views/Admin.jsp").forward(request, response);
                } catch (Exception e) {
                    response.sendRedirect("Views/Loi.jsp");
                }
            }

            if (service.equals("addProduct")) {
                String addBtn = request.getParameter("add");
                setCommonAttributes(request, d);
                if (addBtn == null) {
                    request.getRequestDispatcher("/Views/InsertProduct.jsp").forward(request, response);
                } else {
                    String image_raw = request.getParameter("productImage");
                    String proName = request.getParameter("productName");
                    String category_name = request.getParameter("category");
                    String brand_raw = request.getParameter("brand");
                    String pro_priceImport = request.getParameter("priceImport");
                    String pro_priceSell = request.getParameter("priceSell");
                    String discount_raw = request.getParameter("discount");
                    String productDesc = request.getParameter("productDesc");
                    String quantity_raw = request.getParameter("quantity");
                    if (image_raw.equals("") || image_raw == null) {
                        image_raw = request.getParameter("beforeImage");
                    }
                    int quantity = Integer.parseInt(quantity_raw);
                    int brand_id = Integer.parseInt(brand_raw);
                    int discount = Integer.parseInt(discount_raw);

                    double priceImport = Double.parseDouble(pro_priceImport);
                    double priceSell = Double.parseDouble(pro_priceSell);

                    //will get id of current staff
                    long miliSeconds = System.currentTimeMillis();
                    Date currentDate = new Date(miliSeconds);
                    int prId = d.getProduct().get(d.getProduct().size() - 1).getProduct_id() + 1;
                    Product pro = new Product(
                            prId, discount,
                            brand_id, proName,
                            category_name, image_raw,
                            productDesc, priceImport,
                            priceSell, currentDate,
                            quantity);
//                  request.setAttribute("data", pro);
                    d.addProduct(pro);
                    response.sendRedirect("Manage");
                }
            }

            if (service.equals("Delete")) {
                String pid_raw = request.getParameter("pid");
                int pid = Integer.parseInt(pid_raw);
                int rs = d.deleteProduct(pid);
                String mess;
                if (rs == 0) {
                    mess = "Delete Unsuccess";
                } else {
                    mess = "Delete Success";
                }
                request.setAttribute("mess", mess);
                response.sendRedirect("Manage");
            }

            if (service.equals("Update")) {
                String submit = request.getParameter("Submit");
                if (submit != null) {
                    String productImage = request.getParameter("productImage");
                    if (productImage.equals("") || productImage == null) {
                        productImage = request.getParameter("beforeImage");
                    }
                    String productId = request.getParameter("productId");
                    String proName = request.getParameter("productName");
                    String category_name = request.getParameter("category");
                    String brand = request.getParameter("brand");
                    String price_import_raw = request.getParameter("price_import");
                    String price_sell_raw = request.getParameter("price_sell");
                    String discount_raw = request.getParameter("discount");
                    String productDesc = request.getParameter("productDesc");
                    String quantity_raw = request.getParameter("quantity");
                    int quantity = Integer.parseInt(quantity_raw);
                    int discount = Integer.parseInt(discount_raw);
                    int proId = Integer.parseInt(productId);
                    int brandId = Integer.parseInt(brand);
                    double price_import = Double.parseDouble(price_import_raw);
                    double price_sell = Double.parseDouble(price_sell_raw);

                    Product pro = new Product(productImage, proId, proName, category_name, brandId, price_import,
                            price_sell, discount, productDesc, quantity);
                    d.updateProduct(pro);
                    setCommonAttributes(request, d);
                    request.setAttribute("mess", "update success");
                    response.sendRedirect("Manage");
                } else {
                    handleUpdateRequest(request, response, d);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    private void handleUpdateRequest(HttpServletRequest request, HttpServletResponse response, DAO d) throws IOException, ServletException {
        int pid = 0;
        try {
            pid = Integer.parseInt(request.getParameter("pid"));
            Product pro = d.getProductById(pid);
            request.setAttribute("product", pro);
            setCommonAttributes(request, d);
            request.getRequestDispatcher("/Views/UpdateProduct.jsp").forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("Views/Loi.jsp");
        }
    }

    public String getFormatDate() {
    return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
}

    private void setCommonAttributes(HttpServletRequest request, DAO d) throws SQLException {
        Vector<String> list_category = d.getValueOfAtribute("category_name");
        Vector<Brand> list_brand = d.getBrand();
        int[] salePercent = {1, 10, 20, 30, 40};
        request.setAttribute("product_brand", list_brand);
        request.setAttribute("product_category", list_category);
        request.setAttribute("salePercent", salePercent);
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

    public static void main(String[] args) throws SQLException {
        DAO d = new DAO();
        DAOOrder dp = new DAOOrder();
        DAOOrderItem doi = new DAOOrderItem();
        Vector<OrderItem> list = doi.getAllOrderItem();
        for (OrderItem orderItem : list) {
            System.out.println(orderItem);
        }
    }
}
