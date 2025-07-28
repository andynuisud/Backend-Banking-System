package com.BankManager.bank.dto;

public class UpdateBalance {

    private double amount; 
    private long id; 
    
    public UpdateBalance(){ }

    public UpdateBalance(double amount, long id){ 
        this.amount = amount;
        this.id = id; 
    }

    public double getAmount() { return amount;}

    public long getId() { return id; }

    public void setBalance(double amount) {this.amount = amount;}

    public void setId(long id) { this.id = id; }

}
