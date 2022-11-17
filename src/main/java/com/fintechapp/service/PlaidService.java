package com.fintechapp.service;

import com.fintechapp.helper.AppConstantApi;
import com.fintechapp.model.dto.access_token.AccessTokenRequestDto;
import com.fintechapp.model.dto.access_token.AccessTokenResponseDto;
import com.fintechapp.model.dto.balance.BalanceDetailsRequestDto;
import com.fintechapp.model.dto.balance.BalanceDetailsResponseDto;
import com.fintechapp.model.dto.link_token.LinkTokenRequestDto;
import com.fintechapp.model.dto.link_token.LinkTokenResponseDto;
import com.fintechapp.model.dto.link_token.LinkTokenUserDto;
import com.fintechapp.model.dto.public_token.PublicTokenRequestDto;
import com.fintechapp.model.dto.public_token.PublicTokenResponseDto;
import com.fintechapp.model.dto.transaction.TransactionsDetailsResponseDto;
import com.fintechapp.model.dto.transaction.TransactionsRequestDto;
import com.fintechapp.model.entity.AccessTokenEntity;
import com.fintechapp.repository.AccessTokenRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;

@Service
public class PlaidService {

    @Autowired
    AppConstantApi appConstantApi;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private AccessTokenRepository accessTokenRepository;
    @Autowired
    private  DateTimeService dateTimeService;
    @Autowired
    private ModelMapper modelMapper;

    private  String publicToken = "";
    public  String accessToken = "";


    public LinkTokenResponseDto getLinkTokenResponse(LinkTokenResponseDto linkTokenResponseDto) {

        LinkTokenRequestDto linkTokenRequestDto = new LinkTokenRequestDto();
        linkTokenRequestDto = initLinkTokenRequestDto(linkTokenRequestDto);
        try {
            linkTokenResponseDto = restTemplate.postForObject(appConstantApi.getCreateLinkToken(),linkTokenRequestDto, LinkTokenResponseDto.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
     return  linkTokenResponseDto;
    }

    private LinkTokenRequestDto initLinkTokenRequestDto(LinkTokenRequestDto linkTokenRequestDto) {

        linkTokenRequestDto.setClient_id(appConstantApi.getClintId());
        linkTokenRequestDto.setSecret(appConstantApi.getSecretId());
        linkTokenRequestDto.setClient_name(appConstantApi.getClintName());
        linkTokenRequestDto.setCountry_codes(new ArrayList<>(Collections.singleton("US")));
        linkTokenRequestDto.setLanguage("en");
        linkTokenRequestDto.setUser(new LinkTokenUserDto("0"));
        linkTokenRequestDto.setProducts(new ArrayList<>(Collections.singleton("auth")));
        return linkTokenRequestDto;
    }

    public PublicTokenResponseDto getPublicTokenResponse(PublicTokenResponseDto publicTokenResponseDto) {
        PublicTokenRequestDto publicTokenRequestDto = new PublicTokenRequestDto();
        publicTokenRequestDto = initPublicTokenRequestDto(publicTokenRequestDto);
        try {
            publicTokenResponseDto = restTemplate.postForObject(appConstantApi.getCreatePublicToken(),publicTokenRequestDto,PublicTokenResponseDto.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        publicToken = publicTokenResponseDto.getPublic_token();
        return publicTokenResponseDto;

    }

    private PublicTokenRequestDto initPublicTokenRequestDto(PublicTokenRequestDto publicTokenRequestDto) {

        publicTokenRequestDto.setClient_id(appConstantApi.getClintId());
        publicTokenRequestDto.setSecret(appConstantApi.getSecretId());
        publicTokenRequestDto.setInstitution_id("ins_3");
        publicTokenRequestDto.setInitial_products(new ArrayList<>(Collections.singleton("auth")));
        return publicTokenRequestDto;
    }

    public AccessTokenResponseDto getAccessTokenResponse(AccessTokenResponseDto accessTokenResponseDto){
        AccessTokenRequestDto accessTokenRequestDto =  new AccessTokenRequestDto();
        AccessTokenEntity accessTokenEntity = new AccessTokenEntity();
        accessTokenRequestDto = initAccessTokenRequestDto(accessTokenRequestDto);
        try {
            accessTokenResponseDto = restTemplate.postForObject(appConstantApi.getCreateAccessToken(),accessTokenRequestDto,AccessTokenResponseDto.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try {
            accessTokenEntity = modelMapper.map(accessTokenResponseDto, AccessTokenEntity.class);
            accessTokenRepository.save(accessTokenEntity);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        accessToken = accessTokenResponseDto.getAccess_token();
        return accessTokenResponseDto;
    }

    private AccessTokenRequestDto initAccessTokenRequestDto(AccessTokenRequestDto accessTokenRequestDto) {
        accessTokenRequestDto.setClient_id(appConstantApi.getClintId());
        accessTokenRequestDto.setSecret(appConstantApi.getSecretId());
        accessTokenRequestDto.setPublic_token(publicToken);
        return  accessTokenRequestDto;
    }


    public TransactionsDetailsResponseDto getTransactionDetailsResponse(TransactionsDetailsResponseDto transactionsDetailsResponseDto) {
        TransactionsRequestDto transactionsRequestDto = new TransactionsRequestDto();
        transactionsRequestDto = initTransactionsRequestModel(transactionsRequestDto);
        try {
//            RestTemplate restTemplate = new RestTemplate();
//            HttpEntity<TransactionsDetailsResponseDto> request = new HttpEntity<>(new TransactionsDetailsResponseDto());
//            ResponseEntity<TransactionsDetailsResponseDto> response = restTemplate
//                    .exchange(appConstantApi.getRetrieveTransactions(), HttpMethod.POST, request,TransactionsDetailsResponseDto.class);
          transactionsDetailsResponseDto = restTemplate.postForObject(appConstantApi.getRetrieveTransactions(),transactionsRequestDto, TransactionsDetailsResponseDto.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
     return transactionsDetailsResponseDto;
    }

    private TransactionsRequestDto initTransactionsRequestModel(TransactionsRequestDto transactionsRequestDto) {
        transactionsRequestDto.setClient_id(appConstantApi.getClintId());
        transactionsRequestDto.setSecret(appConstantApi.getSecretId());
        transactionsRequestDto.setAccess_token(accessToken);
//        transactionsRequestDto.setStart_date(dateTimeService.previousDateString(dateTimeService.getCurrentDate()));
//         transactionsRequestDto.setEnd_date(dateTimeService.getCurrentDate());
        transactionsRequestDto.setStart_date("2021-01-01");
        transactionsRequestDto.setEnd_date("2021-12-10");
        return transactionsRequestDto;
    }

    public BalanceDetailsResponseDto getBalanceDetailsResponseDto(BalanceDetailsResponseDto balanceDetailsResponseDto) {
        BalanceDetailsRequestDto balanceDetailsRequestDto = new BalanceDetailsRequestDto();
        balanceDetailsRequestDto = initBalanceDetailsRequestDto(balanceDetailsRequestDto);
        try {
            balanceDetailsResponseDto = restTemplate.postForObject(appConstantApi.getRetrieveBalance(),balanceDetailsRequestDto,BalanceDetailsResponseDto.class);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return  balanceDetailsResponseDto;
    }

    private BalanceDetailsRequestDto initBalanceDetailsRequestDto(BalanceDetailsRequestDto balanceDetailsRequestDto) {
        balanceDetailsRequestDto.setClient_id(appConstantApi.getClintId());
        balanceDetailsRequestDto.setSecret(appConstantApi.getSecretId());
        balanceDetailsRequestDto.setAccess_token(accessToken);
        return balanceDetailsRequestDto;
    }
    public    String checkAccessToken(){
        return accessToken;
    }
}
