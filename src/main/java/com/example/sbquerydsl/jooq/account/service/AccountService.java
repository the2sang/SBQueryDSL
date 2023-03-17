package com.example.sbquerydsl.jooq.account.service;

import com.example.sbquerydsl.jooq.account.persistent.AccountEntity;
import com.example.sbquerydsl.jooq.account.persistent.AccountReadRepository;
import com.example.sbquerydsl.jooq.account.persistent.AccountWriteRepository;
import com.example.sbquerydsl.jooq.article.persistence.ArticleEntity;
import com.example.sbquerydsl.jooq.article.persistence.ArticleReadRepository;
import com.example.sbquerydsl.jooq.article.persistence.ArticleWriteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import com.example.sbquerydsl.jooq.account.model.Account;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountReadRepository accountReadRepository;
    private final AccountWriteRepository accountWriteRepository;

    public AccountEntity save(Account account) {
        if (accountReadRepository.existsUserInfo(account.getEmail(), account.getUsername())) {
            throw new RuntimeException("This account states is duplicated");
        }
        return accountWriteRepository.save(account.toEntity());
    }


    public AccountEntity findOne(String username) {
        final AccountEntity targetAccount = accountReadRepository.findByUsername(username);
        Assert.notNull(targetAccount, format("account is not Found || username = %s || dateTime = %s", username, LocalDateTime.now()));
        return targetAccount;
    }

    public String fetchAccountPageAndMetadata(int limit, int offset) {
        return accountReadRepository.fetchAccountPageAndMetadata(limit, offset);
    }

    public List<AccountEntity> saveAccounts(List<Account> accounts) {
       return accountWriteRepository.saveAll(accounts.stream().map(Account::toEntity ).collect(Collectors.toList()));
    }
}
