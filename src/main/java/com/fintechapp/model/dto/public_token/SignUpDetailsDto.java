package com.fintechapp.model.dto.public_token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDetailsDto {
    private  String userName;
    private  String userEmail;
    private  String userPassword;
}
