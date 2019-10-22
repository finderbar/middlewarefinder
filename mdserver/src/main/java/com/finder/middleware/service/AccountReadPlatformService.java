package com.finder.middleware.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.finder.middleware.domain.Account;


/**
 * @author JamesLwin
 * @createdAt Oct 13, 2019
 */
public interface AccountReadPlatformService extends Remote{
    public Long insertAccount(Account account) throws RemoteException;
    public String getAccounts(String name) throws RemoteException;
}
