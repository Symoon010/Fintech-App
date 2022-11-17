package com.fintechapp.model.dto.balance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceDetailsResponseDto {
    private List<BalanceDetailsDto> accounts;
}
