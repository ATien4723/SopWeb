/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Order;
import Models.OrderItem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 *
 * @author ADMIN
 */
public class DAOOrderItem extends DBConnect {
    
    public Vector<OrderItem> getAllOrderItem() {
        String sql = "select * from [Order_items]";
        Vector<OrderItem> list = new Vector<>();
        try {
            
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                OrderItem orderItem = new OrderItem(
                        rs.getInt("item_id"),
                        rs.getInt("order_id"),
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getInt("quantity"),
                        rs.getDouble("price_import"),
                        rs.getDouble("price_sell")
                );
                list.add(orderItem);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
