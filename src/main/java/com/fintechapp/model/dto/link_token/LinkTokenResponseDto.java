package com.fintechapp.model.dto.link_token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTokenResponseDto {
    private  String expiration;
    private  String link_token;
    private  String request_id;
}
