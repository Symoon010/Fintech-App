package com.fintechapp.model.dto.public_token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicTokenResponseDto {
    public  String public_token;
    public  String request_id;
}
