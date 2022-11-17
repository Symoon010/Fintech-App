package com.fintechapp.model.dto.link_token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkTokenRequestDto {

    private  String client_id;
    private  String secret;
    private  String client_name;
    private List<String> country_codes;
    private  String language;
    private LinkTokenUserDto user;
    private List<String> products;
}
