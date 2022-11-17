package com.fintechapp.controller;

import com.fintechapp.helper.AppConstantApi;
import com.fintechapp.helper.BaseResponse;
import com.fintechapp.model.ClientDetails;
import com.fintechapp.model.dto.access_token.AccessTokenResponseDto;
import com.fintechapp.model.dto.link_token.LinkTokenResponseDto;
import com.fintechapp.model.dto.public_token.PublicTokenResponseDto;
import com.fintechapp.model.dto.balance.BalanceDetailsResponseDto;
import com.fintechapp.model.dto.transaction.TransactionsDetailsResponseDto;
import com.fintechapp.service.AccountService;
import com.fintechapp.service.PlaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaidController {


    @Autowired
    AppConstantApi appConstantApi;
    @Autowired
    AccountService accountService;
    @Autowired
    private  PlaidService plaidService;


    @GetMapping("/linktoken/get")
    public LinkTokenResponseDto getLinkToken(){
        LinkTokenResponseDto linkTokenResponseDto = new LinkTokenResponseDto();
        return  plaidService.getLinkTokenResponse(linkTokenResponseDto);
    }

    @GetMapping("publictoken/get")
    public PublicTokenResponseDto getPublicToken(){
        PublicTokenResponseDto publicTokenResponseDto = new PublicTokenResponseDto();
        return plaidService.getPublicTokenResponse(publicTokenResponseDto);
    }
    @GetMapping("accesstoken/get")
    public AccessTokenResponseDto getAccessToken(){
        AccessTokenResponseDto accessTokenResponseDto = new AccessTokenResponseDto();
        return plaidService.getAccessTokenResponse(accessTokenResponseDto);
    }

    @GetMapping("/transactions/get")
    public TransactionsDetailsResponseDto getTransactionDetails(){
        TransactionsDetailsResponseDto transactionsDetailsResponseDto = new TransactionsDetailsResponseDto();
        return plaidService.getTransactionDetailsResponse(transactionsDetailsResponseDto);
    }


    @GetMapping("/accounts/balance/get")
    public BalanceDetailsResponseDto getBalanceDetails(){
        BalanceDetailsResponseDto balanceDetailsResponseDto = new BalanceDetailsResponseDto();
        return plaidService.getBalanceDetailsResponseDto(balanceDetailsResponseDto);

    }

    @PostMapping("/balance")
    private BaseResponse<Object> getAllBalance( ){

        return accountService.getBalance();
    }

}
