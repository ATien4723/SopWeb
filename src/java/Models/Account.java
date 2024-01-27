/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class Account {
    private int account_id;
    private String email, password, username, first_name, last_name, phone_number, account_image, address;
    private boolean is_admin;

    public Account() {
    }

    public Account(int account_id, String email, String password, String username, String first_name, String last_name, String phone_number, String account_image, String address, boolean is_admin) {
        this.account_id = account_id;
        this.email = email;
        this.password = password;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.account_image = account_image;
        this.address = address;
        this.is_admin = is_admin;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAccount_image() {
        return account_image;
    }

    public void setAccount_image(String account_image) {
        this.account_image = account_image;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    @Override
    public String toString() {
        return "Account{" + "account_id=" + account_id + ", email=" + email + ", password=" + password + ", usename=" + username + ", first_name=" + first_name + ", last_name=" + last_name + ", phone_number=" + phone_number + ", account_image=" + account_image + ", address=" + address + ", is_admin=" + is_admin + '}';
    }

}
