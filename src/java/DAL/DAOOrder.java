/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Account;
import Models.Order;
import Models.Product;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class DAOOrder extends DBConnect {
    public Vector<Order> getAllOrder() {
        String sql = "select * from Orders";
        Vector<Order> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Order order = new Order(
                        rs.getInt("order_id"),
                        rs.getInt("account_id"),
                        rs.getDate("order_date"),
                        rs.getDate("recieve_date"),
                        rs.getString("status")
                );
                list.add(order);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void changeStatus(String status, int orderId) {
        String sql = "UPDATE [dbo].[Orders]\n"
                + "   SET [status] = ?\n"
                + " WHERE [order_id] = ?";
        Vector<Order> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, status);
            st.setInt(2, orderId);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
//     public void filterByStatus(String status, int orderId) {
//       String sql = "SELECT * FROM Products WHERE status like N'%" + status + "%'";
//        Vector<Order> list = new Vector<>();
//        try {
//            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, status);
//            st.setInt(2, orderId);
//            st.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//    }
    
    //checkount
      public void checkcount(Account acc, Vector<Product> listItem) {
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        String formattedDate = myDateObj.format(myFormatObj); 
        int newOrderId = getAllOrder().get(getAllOrder().size() - 1).getOrder_id() + 1;
        try {
            String sql1 = "INSERT INTO [dbo].[Orders]\n"
                    + "           ([order_id]\n"
                    + "           ,[account_id]\n"
                    + "           ,[order_date]\n"
                    + "           ,[status])\n"
                    + "     VALUES(?, ?, ?, ?)\n";
            PreparedStatement st = connection.prepareStatement(sql1);
            st.setInt(1, newOrderId);
            st.setInt(2, acc.getAccount_id());
            st.setTimestamp(3, Timestamp.valueOf(formattedDate));
            st.setString(4, "wait");
            st.executeUpdate();
            //insert into order item
            String sql2 = "SELECT TOP 1 order_id FROM [Orders] ORDER BY order_id DESC";
            PreparedStatement st2 = connection.prepareStatement(sql2);
            ResultSet rs = st2.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                DAOOrderItem Dod = new DAOOrderItem();
                //get last order Item
                int newOrderItemId = Dod.getAllOrderItem().get(Dod.getAllOrderItem().size() - 1).getItem_id() + 1;
                //add all order in cart to database
                for (Product item : listItem) {
                    String sql3 = "INSERT INTO [dbo].[Order_items]\n"
                            + "           ([item_id]\n"
                            + "           ,[order_id]\n"
                            + "           ,[product_id]\n"
                            + "           ,[price_import]\n"
                            + "           ,[price_sell]\n"
                            + "           ,[discount]\n"
                            + "           ,[quantity])\n"
                            + "     VALUES(?, ?, ?, ?, ?, ?, ?)";
                    PreparedStatement st3 = connection.prepareStatement(sql3);
                    st3.setInt(1, newOrderItemId);
                    st3.setInt(2, orderId);
                    st3.setInt(3, item.getProduct_id());
                    st3.setDouble(4, item.getPrice_import());
                    st3.setDouble(5, item.getPrice_sell());
                    st3.setInt(6, item.getDiscount());
                    st3.setInt(7, item.getQuantity());
                    st3.executeUpdate();
                    newOrderItemId++;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
