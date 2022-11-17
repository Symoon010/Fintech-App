package com.fintechapp.helper;

import com.fintechapp.model.ClientDetails;
import com.plaid.client.ApiClient;
import com.plaid.client.model.*;
import com.plaid.client.request.PlaidApi;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Component
public class TokenService {
    private String clientId;
    private String clientSecret;
    private String insId;

    public String getAccessToken(ClientDetails clientDetails) throws IOException {
        this.clientId = clientDetails.getClientId();
        this.clientSecret = clientDetails.getClientSecret();
        this.insId = clientDetails.getInsId();

        PlaidApi client = getClient();
        String publicKey = getPublicKey(client);
        String accessKey = getAccessKey(client, publicKey);
        return accessKey;
    }

    public PlaidApi getClient(){
        HashMap<String, String> apiKeys = new HashMap<>();
        apiKeys.put("clientId", clientId);
        apiKeys.put("secret", clientSecret);
        ApiClient apiClient = new ApiClient(apiKeys);
        apiClient.setPlaidAdapter(ApiClient.Sandbox); // or equivalent, depending on which environment you're calling into
        PlaidApi client = apiClient.createService(PlaidApi.class);
        return client;
    }
    private String getPublicKey(PlaidApi client) throws IOException {
        SandboxPublicTokenCreateRequest createResponse = new SandboxPublicTokenCreateRequest();
        createResponse.setClientId(clientId);
        createResponse.setSecret(clientSecret);
        createResponse.setInstitutionId(insId);
        createResponse.setInitialProducts(List.of(Products.AUTH));

        Call<SandboxPublicTokenCreateResponse> response = client.sandboxPublicTokenCreate(createResponse);
        String publicKey =  response.execute().body().getPublicToken();

        return publicKey;
    }
    private String getAccessKey(PlaidApi client, String publicKey) throws IOException {
        ItemPublicTokenExchangeRequest request = new ItemPublicTokenExchangeRequest().publicToken(String.valueOf(publicKey));
        Response<ItemPublicTokenExchangeResponse> response = client
                .itemPublicTokenExchange(request).execute();
        String accessToken = response.body().getAccessToken();

        return accessToken;
    }

}
