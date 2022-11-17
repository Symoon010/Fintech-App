package com.fintechapp.model.dto.balance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDto {
    private  double available;
    private  double current;
    private  String iso_currency_code;
    private  double limit;
    private  double unofficial_currency_code;
}
