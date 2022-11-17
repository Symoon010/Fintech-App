package com.fintechapp.model.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TransactionsDto {

    private  String account_id;
    private  String account_owner;
    private  double amount;
    private  String authorized_date;
    private  String authorized_datetime;
    private  String category_id;
    private  String check_number;
    private  String date;
    private  String datetime;
    private  String iso_currency_code;
    private  String merchant_name;
    private  String name;
    private  String payment_channel;
    private  Boolean pending;
    private  String pending_transaction_id;
    private  String personal_finance_category;
    private  String transaction_code;
    private  String transaction_id;
    private  String transaction_type;
    private  String unofficial_currency_code;

    public TransactionsDto() {
    }

    public TransactionsDto(String account_id, String account_owner, double amount, String authorized_date, String authorized_datetime, String category_id, String check_number, String date, String datetime, String iso_currency_code, String merchant_name, String name, String payment_channel, Boolean pending, String pending_transaction_id, String personal_finance_category, String transaction_code, String transaction_id, String transaction_type, String unofficial_currency_code) {
        this.account_id = account_id;
        this.account_owner = account_owner;
        this.amount = amount;
        this.authorized_date = authorized_date;
        this.authorized_datetime = authorized_datetime;
        this.category_id = category_id;
        this.check_number = check_number;
        this.date = date;
        this.datetime = datetime;
        this.iso_currency_code = iso_currency_code;
        this.merchant_name = merchant_name;
        this.name = name;
        this.payment_channel = payment_channel;
        this.pending = pending;
        this.pending_transaction_id = pending_transaction_id;
        this.personal_finance_category = personal_finance_category;
        this.transaction_code = transaction_code;
        this.transaction_id = transaction_id;
        this.transaction_type = transaction_type;
        this.unofficial_currency_code = unofficial_currency_code;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public String getAccount_owner() {
        return account_owner;
    }

    public void setAccount_owner(String account_owner) {
        this.account_owner = account_owner;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAuthorized_date() {
        return authorized_date;
    }

    public void setAuthorized_date(String authorized_date) {
        this.authorized_date = authorized_date;
    }

    public String getAuthorized_datetime() {
        return authorized_datetime;
    }

    public void setAuthorized_datetime(String authorized_datetime) {
        this.authorized_datetime = authorized_datetime;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCheck_number() {
        return check_number;
    }

    public void setCheck_number(String check_number) {
        this.check_number = check_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getIso_currency_code() {
        return iso_currency_code;
    }

    public void setIso_currency_code(String iso_currency_code) {
        this.iso_currency_code = iso_currency_code;
    }

    public String getMerchant_name() {
        return merchant_name;
    }

    public void setMerchant_name(String merchant_name) {
        this.merchant_name = merchant_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayment_channel() {
        return payment_channel;
    }

    public void setPayment_channel(String payment_channel) {
        this.payment_channel = payment_channel;
    }

    public Boolean getPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public String getPending_transaction_id() {
        return pending_transaction_id;
    }

    public void setPending_transaction_id(String pending_transaction_id) {
        this.pending_transaction_id = pending_transaction_id;
    }

    public String getPersonal_finance_category() {
        return personal_finance_category;
    }

    public void setPersonal_finance_category(String personal_finance_category) {
        this.personal_finance_category = personal_finance_category;
    }

    public String getTransaction_code() {
        return transaction_code;
    }

    public void setTransaction_code(String transaction_code) {
        this.transaction_code = transaction_code;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getUnofficial_currency_code() {
        return unofficial_currency_code;
    }

    public void setUnofficial_currency_code(String unofficial_currency_code) {
        this.unofficial_currency_code = unofficial_currency_code;
    }
}
