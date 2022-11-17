package com.fintechapp.model.dto.access_token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccessTokenResponseDto {
    private  String access_token;
    private  String item_id;
    private  String request_id;
}
