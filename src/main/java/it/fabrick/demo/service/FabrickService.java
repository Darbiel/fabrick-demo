package it.fabrick.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.fabrick.demo.entity.AccountTransactionEntity;
import it.fabrick.demo.entity.AccountTransactionTypeEntity;
import it.fabrick.demo.model.*;
import it.fabrick.demo.repository.TransactionRepository;
import it.fabrick.demo.webclient.GenericRestClient;
import it.fabrick.demo.webclient.WebClientOption;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;
import java.util.Map;

@Service
public class FabrickService {

    @Autowired
    GenericRestClient genericRestClient;

    @Autowired
    TransactionRepository repo;

    @Value("${base.url}")
    String baseUrl;

    @Value("${api.key}")
    private String apiKey;

    @Value("${auth.schema}")
    private String authSchema;


    public AccountBalanceResponse getCashAccountBalance(String accountId){
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("accountId", accountId);

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Auth-Schema", authSchema);
        headers.add("Api-Key", apiKey);

        WebClientOption webClientOption = new WebClientOption<>()
                .method(HttpMethod.GET)
                .clazz(FabrickResponseModel.class)
                .uri("/api/gbs/banking/v4.0/accounts/{accountId}/balance")
                .baseUrl(baseUrl)
                .pathParams(pathParams)
                .headers(headers)
                .body(null);

        FabrickResponseModel result = (FabrickResponseModel) genericRestClient.getResult(webClientOption);
        ObjectMapper om = new ObjectMapper();
        AccountBalanceResponse accountBalanceResponse = om.convertValue(result.getPayload(), AccountBalanceResponse.class);

        return accountBalanceResponse;

    }

    public AccountTransactionsResponse getCashAccountTransactions(String accountId, String fromAccountingDate, String toAccountingDate){
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("accountId", accountId);

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Auth-Schema", authSchema);
        headers.add("Api-Key", apiKey);

        MultiValueMap<String, String> queryParam = new LinkedMultiValueMap<>();
        queryParam.add("fromAccountingDate",fromAccountingDate);
        queryParam.add("toAccountingDate",toAccountingDate);

        WebClientOption webClientOption = new WebClientOption<>()
                .method(HttpMethod.GET)
                .clazz(FabrickResponseModel.class)
                .uri("/api/gbs/banking/v4.0/accounts/{accountId}/transactions")
                .baseUrl(baseUrl)
                .pathParams(pathParams)
                .queryParams(queryParam)
                .headers(headers)
                .body(null);

        FabrickResponseModel result = (FabrickResponseModel) genericRestClient.getResult(webClientOption);
        ObjectMapper om = new ObjectMapper();
        AccountTransactionsResponse accountTransactionsResponse = om.convertValue(result.getPayload(), AccountTransactionsResponse.class);

        for (AccountTransactionModel accountTransactionModel : accountTransactionsResponse.getList()) {
            AccountTransactionEntity accountTransactionEntity = new AccountTransactionEntity();
            BeanUtils.copyProperties(accountTransactionModel, accountTransactionEntity);
            AccountTransactionTypeEntity accountTransactionTypeEntity = new AccountTransactionTypeEntity();
            AccountTransactionType type = accountTransactionModel.getType();
            BeanUtils.copyProperties(type, accountTransactionTypeEntity);
            accountTransactionEntity.setAccountTransactionTypeEntity(accountTransactionTypeEntity);
            repo.save(accountTransactionEntity);
        }

        return accountTransactionsResponse;

    }

}
