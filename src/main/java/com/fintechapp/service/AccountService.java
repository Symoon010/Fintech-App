package com.fintechapp.service;

import com.fintechapp.helper.AppConstantApi;
import com.fintechapp.model.ClientDetails;
import com.fintechapp.helper.TokenService;
import com.fintechapp.helper.BaseResponse;
import com.plaid.client.model.AccountsBalanceGetRequest;
import com.plaid.client.model.AccountsGetResponse;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;

@Service
public class AccountService {
    @Autowired
    private TokenService tokenService;
    @Autowired
    AppConstantApi appConstantApi;

    @Autowired
    private BaseResponse<Object> baseResponse;

    public BaseResponse<Object> getBalance(){
        ClientDetails client = new ClientDetails();
        client.setClientId(appConstantApi.getClintId());
        client.setClientSecret(appConstantApi.getSecretId());
        client.setInsId("ins_3");

        String accessToken = null;
        try{
            accessToken = tokenService.getAccessToken(client);
        } catch (Exception e){
            baseResponse.setBalance(null);
            baseResponse.setStatusMessage("You are not verified!!");
            baseResponse.setStatusCode(404);
        }
        if(accessToken != null){

            try {
                Object balance = getAccountBalance(accessToken,tokenService.getClient());
                baseResponse.setBalance(balance);
                baseResponse.setStatusMessage("You are verified!!");
                baseResponse.setStatusCode(200);
            }catch (Exception e){
                baseResponse.setBalance(null);
                baseResponse.setStatusMessage(e.getMessage());
                baseResponse.setStatusCode(500);
            }
        }
        return baseResponse;
    }

    private Object getAccountBalance(String accessToken, PlaidApi client) throws IOException {
        AccountsBalanceGetRequest request = new AccountsBalanceGetRequest()
                .accessToken(accessToken);
        Response<AccountsGetResponse> response = client
                .accountsBalanceGet(request)
                .execute();
        return response.body().getAccounts();
    }
}
