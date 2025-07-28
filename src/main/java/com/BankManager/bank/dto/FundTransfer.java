package com.BankManager.bank.dto;

public class FundTransfer {

    private long senderId; 
    private long recipiantId; 
    private double amount; 

    public FundTransfer(){}

    public FundTransfer(long senderId, long recipiantId, double amount){
        this.senderId = senderId; 
        this.recipiantId = recipiantId; 
        this.amount = amount;
    }

    public long getSender() {return senderId;}

    public long getRecipiant() {return recipiantId;}

    public double getAmount() {return amount;}

    public void setSenderId(long senderId) {this.senderId = senderId;}

    public void setRecipiantId(long recipiantId) {this.recipiantId = recipiantId;}

    public void setAmount(double amount) {this.amount = amount;}
}
