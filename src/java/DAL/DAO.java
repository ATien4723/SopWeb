/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Models.Account;
import Models.Brand;
import Models.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Vector;

/**
 *
 * @author HP
 */
public class DAO extends DBConnect {

    public Vector<Product> getProduct() throws SQLException {
        String sql = "SELECT * FROM Products";
        Vector<Product> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getInt("brand_id"),
                        rs.getString("product_name"),
                        rs.getString("category_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("price_import"),
                        rs.getDouble("price_sell"),
                        rs.getDate("date_added"),
                        rs.getInt("quantity")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Vector<Product> getProductManage() {
        String sql = "Select * from Products P\n"
                + "left join Brands B on P.brand_id = B.brand_id";
        Vector<Product> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand(
                        rs.getInt("brand_id"),
                        rs.getString("brand_name"),
                        rs.getString("brand_phone"),
                        rs.getString("brand_email"),
                        rs.getString("address")
                );

                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getInt("brand_id"),
                        rs.getString("product_name"),
                        rs.getString("category_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("price_import"),
                        rs.getDouble("price_sell"),
                        rs.getDate("date_added"),
                        brand,
                        rs.getInt("quantity")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public Product getProductManageById(int id) {
        String sql = "Select * from Products P\n"
                + "join Brands B on P.brand_id = B.brand_id where P.product_id = ?";
        Product p = new Product();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand(
                        rs.getInt("brand_id"),
                        rs.getString("brand_name"),
                        rs.getString("brand_phone"),
                        rs.getString("brand_email"),
                        rs.getString("address")
                );

                p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getInt("brand_id"),
                        rs.getString("product_name"),
                        rs.getString("category_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("price_import"),
                        rs.getDouble("price_sell"),
                        rs.getDate("date_added"),
                        brand,
                        rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return p;
    }

    public Vector<Product> getProduct(String start, String numPP) throws SQLException {
        String sql = "SELECT * FROM Products P WHERE 1=1"
                + " ORDER BY P.product_id "
                + " OFFSET " + start + " ROWS FETCH NEXT " + numPP + " ROWS ONLY";
        Vector<Product> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getInt("brand_id"),
                        rs.getString("product_name"),
                        rs.getString("category_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("price_import"),
                        rs.getDouble("price_sell"),
                        rs.getDate("date_added"),
                        rs.getInt("quantity")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Product getProductById(int id) {
        String sql = "Select * from Products where product_id = ?";
        Product p = new Product();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getInt("brand_id"),
                        rs.getString("product_name"),
                        rs.getString("category_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("price_import"),
                        rs.getDouble("price_sell"),
                        rs.getDate("date_added"),
                        rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return p;
    }

    public Vector<String> getValueOfAtribute(String properties) throws SQLException {
        String sql = "Select DISTINCT " + properties + " from Products\n"
                + "where " + properties + " IS NOT NULL";
        Vector<String> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
//            st.setString(1, properties);
//            st.setString(2, properties);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(properties));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Vector<Brand> getBrand() {
        Vector<Brand> list = new Vector<>();
        String sql = "Select * from Brands";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Brand brand = new Brand(
                        rs.getInt("brand_id"),
                        rs.getString("brand_name"),
                        rs.getString("brand_phone"),
                        rs.getString("brand_email"),
                        rs.getString("address")
                );
                list.add(brand);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Vector<Product> getProductByName(String name) {
        String sql = "SELECT * FROM Products WHERE product_name like N'%" + name + "%'";
        Vector<Product> list = new Vector<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getInt("brand_id"),
                        rs.getString("product_name"),
                        rs.getString("category_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("price_import"),
                        rs.getDouble("price_sell"),
                        rs.getDate("date_added"),
                        rs.getInt("quantity")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Vector<Product> filter(String category_name, String discount) {
        Vector<Product> list = new Vector<Product>();
        String sql = "Select P.* from Products P where 1=1";

        if (category_name != null && category_name != "") {
            sql += " and P.category_name = N'" + category_name + "'";
        }
        
        if (discount != null && discount != "") {
            sql += " and P.discount > " + discount;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product(
                        rs.getInt("product_id"),
                        rs.getInt("discount"),
                        rs.getInt("brand_id"),
                        rs.getString("product_name"),
                        rs.getString("category_name"),
                        rs.getString("product_img"),
                        rs.getString("product_desc"),
                        rs.getDouble("price_import"),
                        rs.getDouble("price_sell"),
                        rs.getDate("date_added"),
                        rs.getInt("quantity")
                );
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Account login(String username, String password) {
        String sql = "Select * from Accounts acc\n"
                + " WHERE acc.username = ? and acc.password = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account(
                        rs.getInt("account_id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("username"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getString("account_image"),
                        rs.getString("address"),
                        rs.getBoolean("is_admin")
                );
                return account;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addProduct(Product pro) {
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([product_id]\n"
                + "           ,[product_name]\n"
                + "           ,[price_import]\n"
                + "           ,[price_sell]\n"
                + "           ,[discount]\n"
                + "           ,[category_name]\n"
                + "           ,[brand_id]\n"
                + "           ,[product_img]\n"
                + "           ,[date_added]\n"
                + "           ,[product_desc]\n"
                + "           ,[quantity])\n"
                + "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pro.getProduct_id());
            st.setString(2, pro.getProduct_name());
            st.setDouble(3, pro.getPrice_import());
            st.setDouble(4, pro.getPrice_sell());
            st.setInt(5, pro.getDiscount());
            st.setString(6, pro.getCategory_name());
            st.setInt(7, pro.getBrand_id());
            st.setString(8, pro.getProduct_img());
            st.setTimestamp(9, Timestamp.valueOf(pro.getDate_added()+" 00:00:00"));
            st.setString(10, pro.getProduct_desc());
            st.setInt(11, pro.getQuantity());
            st.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void updateProduct(Product pro) throws SQLException {
        String sql = "UPDATE [dbo].[Products]\n"
                + "SET [product_img] = ? \n"
                + "      ,[product_name] = ? \n"
                + "      ,[category_name] = ? \n"
                + "      ,[brand_id] = ? \n"
                + "      ,[price_import] = ? \n"
                + "      ,[price_sell] = ? \n"
                + "      ,[discount] = ? \n"
                + "      ,[product_desc] = ? \n"
                + "      ,[quantity] = ? \n"
                + " WHERE [product_id] = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pro.getProduct_img());
            st.setString(2, pro.getProduct_name());
            st.setString(3, pro.getCategory_name());
            st.setInt(4, pro.getBrand_id());
            st.setDouble(5, pro.getPrice_import());
            st.setDouble(6, pro.getPrice_sell());
            st.setInt(7, pro.getDiscount());
            st.setString(8, pro.getProduct_desc());
            st.setInt(9, pro.getQuantity());
            st.setInt(10, pro.getProduct_id());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public int deleteProduct(int pid) {
        String sql = "DELETE FROM [dbo].[Products]\n"
                + "      WHERE product_id = ?\n";
        int n = 0;
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, pid);
            n = st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return n;
    }

    public Account checkAccountExist(String username) {
        String sql = "select * from Accounts\n"
                + "where [username] = ?\n";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt("account_id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("username"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getString("account_image"),
                        rs.getString("address"),
                        rs.getBoolean("is_admin")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public Account checkAccountExist1(String email) {
        String sql = "select * from Accounts\n"
                + "where [email] = ?\n";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt("account_id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("username"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getString("account_image"),
                        rs.getString("address"),
                        rs.getBoolean("is_admin")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void signup(String email, String user, String pass, String firstName, String lastName, String phone, String role) {
        String sql = "insert into Accounts\n"
                + "([account_id]\n"
                + "           ,[email]\n"
                + "           ,[username]\n"
                + "           ,[password]\n"
                + "           ,[first_name]\n"
                + "           ,[last_name]\n"
                + "           ,[phone_number]\n"
                + "           ,[is_admin])"
                + "values(?,?,?,?,?,?,?,?)";
        int n = getAllAccount().get(getAllAccount().size() - 1).getAccount_id();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, n + 1);
            ps.setString(2, email);
            ps.setString(3, user);
            ps.setString(4, pass);
            ps.setString(5, firstName);
            ps.setString(6, lastName);
            ps.setString(7, phone);
            ps.setString(8, role);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Vector<Account> getAllAccount() {
        String sql = "select * from Accounts";
        Vector<Account> list = new Vector<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Account a = new Account(
                        rs.getInt("account_id"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("username"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("phone_number"),
                        rs.getString("account_image"),
                        rs.getString("address"),
                        rs.getBoolean("is_admin")
                );
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public void change(Account a){
        String sql = "Update Accounts set password=? where username=?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, a.getPassword());
            ps.setString(2, a.getUsername());
            ps.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }

//    public Vector<Customer> getAllCustomer()){
//        String sql = "Select * from Customers_HE172023";
//        Vector<Customer> list = new Vector<>();
//        try{
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                Customer a = new Customer(0, 0, sql, sql, sql, sql, sql, sql, sql)
//                list.add(a);
//            }
//        }catch(SQLException e){
//            System.out.println(e);
//        }
//        return list;
//    }
    public int getNumberCus() {
        String sql = "Select top 1 customer_id from Customers\n"
                + " order by customer_id desc";
        int cusLast = -1;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cusLast = rs.getInt("customer_id");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return cusLast;
    }

//    public int getAccountId(String email) {
//     String sql = "Select account_id from Accounts_HE172023\n" +
//                  " where email = ?";
//       int n = -1;
//        try{
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, email);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                n = rs.getInt("account_id");
//            }
//            ps.executeUpdate();
//        }catch(SQLException e){
//            System.out.println(e);
//        }
//        return n;
//    }
//    
//    public void InsertCustomer(
//            String email, String first_name, 
//            String last_name, String customer_name, 
//            String phone){
//        String sql = "INSERT INTO [dbo].[Customers_HE172023]\n" +
//"           ([customer_id]\n" +
//"           ,[account_id]\n" +
//"           ,[first_name]\n" +
//"           ,[last_name]\n" +
//"           ,[customer_name]\n" +
//"           ,[email]\n" +
//"           ,[phone_number]\n" +
//"     VALUES (?,?,?,?,?,?,?)";
//        int accountId = getAccountId(email);
//        int customerId = getNumberCus()+1;
//        try{
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, customerId);
//            ps.setInt(2, accountId);
//            ps.setString(3, first_name);
//            ps.setString(4, last_name);
//            ps.setString(5, customer_name);
//            ps.setString(6, email);
//            ps.setString(7, phone);
//            ps.executeUpdate();
//        }catch(SQLException e){
//            System.out.println(e);
//        }
//    }
//    public Customer getAccount(String account_id){
//        String sql = "select * from Customers_HE172023 where account_id = ?";
//        try{
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setString(1, account_id);
//            ResultSet rs = ps.executeQuery();
//            if(rs.next()){
//                return new Customer(rs.getInt("customer_id"))
//            }
//        }catch(SQLException e){
//            System.out.println(e);
//        }
//    }
    
    
    
    
    public static void main(String[] args) {
        DAO d = new DAO();
        Product b = d.getProductManageById(1);
            System.out.println(b);

    }
}
