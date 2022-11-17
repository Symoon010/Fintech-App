package com.fintechapp.model.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class TransactionsRequestDto {
    private  String client_id;
    private  String secret;
    private  String access_token;
    private  String start_date;
    private  String end_date;

    public TransactionsRequestDto() {
    }

    public TransactionsRequestDto(String client_id, String secret, String access_token, String start_date, String end_date) {
        this.client_id = client_id;
        this.secret = secret;
        this.access_token = access_token;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
