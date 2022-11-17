package com.fintechapp.model.dto.transaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class TransactionsDetailsResponseDto {
    private TransactionsDto []transactions;

    public TransactionsDetailsResponseDto(TransactionsDto[] transactions) {
        this.transactions = transactions;
    }

    public TransactionsDetailsResponseDto() {
    }

    public TransactionsDto[] getTransactions() {
        return transactions;
    }

    public void setTransactions(TransactionsDto[] transactions) {
        this.transactions = transactions;
    }
}
