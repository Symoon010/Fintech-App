package com.fintechapp.model.dto.access_token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenRequestDto {
    private  String client_id;
    private  String secret;
    private  String public_token;
}
