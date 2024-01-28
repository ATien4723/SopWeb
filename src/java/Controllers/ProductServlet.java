/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import DAL.DAO;
import Models.Account;
import Models.Brand;
import Models.Paging;
import Models.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author HP
 */
@WebServlet(name = "ProductServlet", urlPatterns = {"/ProductURL"})
public class ProductServlet extends HttpServlet {
    private static final String LIST_PRODUCT_ATTRIBUTE = "listProduct";
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
        PrintWriter out = response.getWriter();
//        lấy đối tượng PrintWriter để ghi dữ liệu vào phản hồi HTTP?
        DAO d = new DAO();
        try {
            String service = request.getParameter("Service");
            if (service == null) {
                service = "getAll";
            }

            int numPP = 8; //số lượng sản phẩm 1 trang
            int index = 0;  //start page = 0
            String index_raw = request.getParameter("index");
            if (index_raw != null) {
                index = Integer.parseInt(index_raw);
            }
            int currentStart = index * numPP;  // sản phẩm bắt đầu 1 trang
            request.setAttribute("currentIndex", index);
            Paging p = new Paging();

//            Service chỉ được truyền vs tham số service = ProductDetail nên nếu sản phẩm không
//            được nhấn thì service == null và nó được gán là getAll
            if (service.equals("getAll")) {
                Vector<Product> list = new Vector<>();
                list = d.getProduct(currentStart + "", numPP + "");

                p = new Paging(numPP, index, d.getProduct().size());
                p.calc();
                request.setAttribute("page", p);

                request.setAttribute(LIST_PRODUCT_ATTRIBUTE, list);
                setCommonAttributes(request, d);
                request.getRequestDispatcher("Views/Home.jsp").forward(request, response);
            }
                if(service.equals("clearfilter")) {
                response.sendRedirect("ProductURL");
            }
            if (service.equals("filter")) {
                // Phần này lấy dữ liệu từ các biến khi nhấn filter và trả về các biến 
                //đó để khi ấn áp dụng những cái mình chọn sẽ giữ nguyên ở đó
                String category = request.getParameter("catFilter");
                String discount = request.getParameter("disFilter");

                request.setAttribute("category", category);
                request.setAttribute("discount", discount);
//                    list = d.getProduct();
                Vector<Product> list = new Vector<>();
                setCommonAttributes(request, d);
                list = d.filter(category, discount);
                request.setAttribute(LIST_PRODUCT_ATTRIBUTE, list);
                request.getRequestDispatcher("Views/Home.jsp").forward(request, response);
                //list chứa những sản phẩm sau khi đã lọc
            }

            if (service.equals("ProductDetail")) {
                try {
                    String pid_raw = request.getParameter("pid");
                    int pid = Integer.parseInt(pid_raw);
                    Product currentP = d.getProductById(pid);
                    request.setAttribute("currentProduct", currentP);
                    request.getRequestDispatcher("Views/ProductDetail.jsp").forward(request, response);
                }catch(Exception e){
                        response.sendRedirect("Views/Loi.jsp");
                }
            }
            if (service.equals("search")) {
                    String nameTxt = request.getParameter("keyword");
                    Vector<Product> list = d.getProductByName(nameTxt);
                    request.setAttribute(LIST_PRODUCT_ATTRIBUTE, list);
                    setCommonAttributes(request, d);
                    request.getRequestDispatcher("/Views/Home.jsp").forward(request, response);
                }
            }catch (SQLException e) {
            System.out.println(e);
        }
        }
        // Lấy dữ liệu từ database, phần này dùng để hiển thị lên thanh filter bên trái
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

//    public static void main(String[] args) {
//        DAO d = new DAO();
//        try {
//            Vector<Product> list_color = d.filter("nam", null, null, null, null, null);
//            for (Product string : list_color) {
//                System.out.println(string);
//            }
//            System.out.println(list_color.size());
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }
}
