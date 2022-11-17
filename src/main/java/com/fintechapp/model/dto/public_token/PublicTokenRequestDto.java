package com.fintechapp.model.dto.public_token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublicTokenRequestDto {
    private  String client_id;
    private  String  secret;
    private  String  institution_id;
    private List<String>initial_products;
}
