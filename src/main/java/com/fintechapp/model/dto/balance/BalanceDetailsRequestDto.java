package com.fintechapp.model.dto.balance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceDetailsRequestDto {
    private  String client_id;
    private  String secret;
    private  String access_token;
}
