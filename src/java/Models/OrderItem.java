/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

public class OrderItem {
         private int item_id, order_id, product_id, discount, quantity;
         private double price_import, price_sell;

    public OrderItem(int item_id, int order_id, int product_id, int discount, int quantity, double price_import, double price_sell) {
        this.item_id = item_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.discount = discount;
        this.quantity = quantity;
        this.price_import = price_import;
        this.price_sell = price_sell;
    }

    public OrderItem() {
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "OrderItem{" + "item_id=" + item_id + ", order_id=" + order_id + ", product_id=" + product_id + ", discount=" + discount + ", quantity=" + quantity + ", price_import=" + price_import + ", price_sell=" + price_sell + '}';
    }
         
}
