package com.fintechapp.model.dto.balance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BalanceDetailsDto {
    private String account_id;
    private BalanceDto balances;
    private String mask;
    private String name;
    private String official_name;
    private String subtype;
    private String type;
}
