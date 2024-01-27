/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

public class Customer {
    int customer_id,  account_id;
    String first_name, last_name, customer_name, 
            email, phone_number, customer_image, address;

    public Customer() {
    }

    public Customer(int customer_id, int account_id, String first_name, String last_name, String customer_name, String email, String phone_number) {
        this.customer_id = customer_id;
        this.account_id = account_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.customer_name = customer_name;
        this.email = email;
        this.phone_number = phone_number;
    }

    
    public Customer(int customer_id, int account_id, String first_name, String last_name, String customer_name, String email, String phone_number, String customer_image, String address) {
        this.customer_id = customer_id;
        this.account_id = account_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.customer_name = customer_name;
        this.email = email;
        this.phone_number = phone_number;
        this.customer_image = customer_image;
        this.address = address;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCustomer_image() {
        return customer_image;
    }

    public void setCustomer_image(String customer_image) {
        this.customer_image = customer_image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
