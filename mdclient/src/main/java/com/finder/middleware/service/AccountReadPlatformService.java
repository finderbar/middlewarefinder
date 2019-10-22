package com.finder.middleware.service;

import com.finder.middleware.domain.Account;

/**
 * @author JamesLwin
 * @createdAt Oct 13, 2019
 */
public interface AccountReadPlatformService {
    public Long insertAccount(Account account);
    public String getAccounts(String name);
}
