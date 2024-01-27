package Models;

import java.sql.Date;

public class Product {

    private int product_id, discount, brand_id;
    private String product_name, category_name, product_img, product_desc;
    private double price_import, price_sell;
    private Date date_added;
    private int quantity;
    
    private Brand brand;

    public Product() {
    }
    
    public String getBrandName() {
     return brand.getBrand_name();
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Product(int product_id, int discount, String product_name, String product_img, String category_name, double price_import, double price_sell,int quantity, Brand brand) {
        this.product_id = product_id;
        this.discount = discount;
        this.product_name = product_name;
        this.product_img = product_img;
        this.category_name = category_name;
        this.price_import = price_import;
        this.price_sell = price_sell;
        this.quantity = quantity;
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
     
     
     
    public Product(int product_id, int discount, int brand_id, String product_name, String category_name, String product_img, String product_desc, double price_import, double price_sell, Date date_added, int quantity) {
        this.product_id = product_id;
        this.discount = discount;
        this.brand_id = brand_id;
        this.product_name = product_name;
        this.category_name = category_name;
        this.product_img = product_img;
        this.product_desc = product_desc;
        this.price_import = price_import;
        this.price_sell = price_sell;
        this.date_added = date_added;
        this.quantity = quantity;
    }
    
    public Product(String product_img, int product_id, String product_name, String category_name, int brand_id, double price_import, double price_sell, int discount, String product_desc,  int quantity){
        this.product_img = product_img;
        this.product_id = product_id;
        this.product_name = product_name;
        this.category_name = category_name;
        this.brand_id = brand_id;
        this.price_import = price_import;
        this.price_sell = price_sell;
        this.discount = discount;
        this.product_desc = product_desc;
        this.quantity = quantity;
    }

    public Product(int product_id, int discount, int brand_id, String product_name, String category_name, String product_img, String product_desc, double price_import, double price_sell, Date date_added, Brand brand, int quantity) {
        this.product_id = product_id;
        this.discount = discount;
        this.brand_id = brand_id;
        this.product_name = product_name;
        this.category_name = category_name;
        this.product_img = product_img;
this.product_desc = product_desc;
        this.price_import = price_import;
        this.price_sell = price_sell;
        this.date_added = date_added;
        this.brand = brand;
        this.quantity = quantity;
    }
    
    public Product(int product_id, int discount, int brand_id, String product_name, String category_name, String product_img, String product_desc, double price_import, double price_sell) {
        this.product_id = product_id;
        this.discount = discount;
        this.brand_id = brand_id;
        this.product_name = product_name;
        this.category_name = category_name;
        this.product_img = product_img;
        this.product_desc = product_desc;
        this.price_import = price_import;
        this.price_sell = price_sell;
    }
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public String getProduct_desc() {
        return product_desc;
    }

    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }

    public double getPrice_import() {
        return price_import;
    }

    public void setPrice_import(double price_import) {
        this.price_import = price_import;
    }

    public double getPrice_sell() {
        return price_sell;
    }

    public void setPrice_sell(double price_sell) {
        this.price_sell = price_sell;
    }

    public Date getDate_added() {
        return date_added;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public String getProductPrice() {
        double productPrice = price_sell*(1 - discount*0.01);
        String formattedPrice = String.format("%,.0f", productPrice);
        formattedPrice = formattedPrice.replace(",", ".");
        return formattedPrice;
    }
    
    //dung hien thi cho cart
    public double getAfterPrice() {
      return price_sell*quantity*(1-discount*0.01);
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", discount=" + discount + ", brand_id=" + brand_id + ", product_name=" + product_name + ", category_name=" + category_name + ", product_img=" + product_img + ", product_desc=" + product_desc + ", price_import=" + price_import + ", price_sell=" + price_sell + ", date_added=" + date_added + ", quantity=" + quantity + ", brand=" + brand + '}';
    }
    
    
}