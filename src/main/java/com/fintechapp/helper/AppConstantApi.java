package com.fintechapp.helper;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
@Data
public class AppConstantApi {

    final String clintId = "632839951364620013bbbbbf";
    final String secretId = "acb23a51705753f3dbcfe59758c217";
    final String clintName = "Fintech-App";

    final String createLinkToken = "https://sandbox.plaid.com/link/token/create";
    final String createPublicToken = "https://sandbox.plaid.com/sandbox/public_token/create";
    final String createAccessToken = "https://sandbox.plaid.com/item/public_token/exchange";
    final String retrieveTransactions = "https://sandbox.plaid.com/transactions/get";
    final String retrieveBalance = "https://sandbox.plaid.com/accounts/balance/get";

}
