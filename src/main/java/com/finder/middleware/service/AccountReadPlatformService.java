package com.finder.middleware.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

import com.finder.middleware.domain.Account;

/**
 * @author JamesLwin
 * @createdAt Oct 13, 2019
 */
public interface AccountReadPlatformService extends Remote{
    public void insertAccount(Account account) throws RemoteException;
    public Collection<Account> getAccounts(String name) throws RemoteException;
}
