package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {


    @Id
    private long id;
    private long accountNumber;
    private String action;
    private double amount;
    private String reason;


    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                ", action='" + action + '\'' +
                ", amount=" + amount +
                ", reason='" + reason + '\'' +
                '}';
    }
}
