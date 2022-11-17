package com.fintechapp.helper;

import org.springframework.stereotype.Component;

@Component
public class BaseResponse  <T>{
    private T balance;
    private String statusMessage;
    private int statusCode;

    public T getBalance() {
        return balance;
    }
    public void setBalance(T balance) {
        this.balance = balance;
    }
    public String getStatusMessage() {
        return statusMessage;
    }
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
