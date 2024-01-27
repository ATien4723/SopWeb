/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Order {
    private int order_id, account_id;
  private Date order_date, recieve_date;
  private String status;

    public Order() {
    }

    public Order(int order_id, int account_id, Date order_date, Date recieve_date, String status) {
        this.order_id = order_id;
        this.account_id = account_id;
        this.order_date = order_date;
        this.recieve_date = recieve_date;
        this.status = status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public Date getRecieve_date() {
        return recieve_date;
    }

    public void setRecieve_date(Date recieve_date) {
        this.recieve_date = recieve_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" + "order_id=" + order_id + ", account_id=" + account_id + ", order_date=" + order_date + ", recieve_date=" + recieve_date + ", status=" + status + '}';
    }
}
