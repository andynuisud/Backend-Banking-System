package com.BankManager.bank.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    private double balance; 

    private String userName;
    private String password; 
    private String email; 

    public User() {}

    public User(String userName, String password, String email, double balance) {
        this.userName = userName;
        this.password = password; 
        this.email = email; 
        this.balance = balance; 
    }

    public String getUserName() { return userName; }

    public String getPassword() { return password; }

    public String getEmail() { return email; }

    public long getId(){ return id; }

    public double getBalance() { return balance; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setPassword(String password) { this.password = password; }

    public void setEmail(String email) { this.email = email; }

    public void setId(long id) { this.id = id; }

    public void setBalance(double balance) { this.balance = balance; }
}
