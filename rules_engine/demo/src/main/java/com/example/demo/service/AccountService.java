package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Account;

@Service
public class AccountService {

    public Account getAccountDetails(String accountId) {
        Account account = new Account();
        char lastChar = accountId.charAt(accountId.length() - 1);
        account.setUid(accountId);
        account.setAccountName("Demo account" + lastChar);
        account.setPerOrderAmountLimit(lastChar == '1' ? 100 : 10000);
        account.setAllowedSymbols(lastChar == '1' ? List.of("TSL", "APPL") : List.of("TSL", "APPL", "ETH", "ABC"));

        return account;
    }

}
