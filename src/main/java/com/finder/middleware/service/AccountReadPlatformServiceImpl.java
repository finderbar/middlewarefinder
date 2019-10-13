package com.finder.middleware.service;

import java.rmi.RemoteException;
import java.util.Collection;

import org.springframework.stereotype.Service;

import com.finder.middleware.domain.Account;

/**
 * @author JamesLwin
 * @createdAt Oct 13, 2019
 */
@Service
public class AccountReadPlatformServiceImpl implements AccountReadPlatformService {

	@Override
	public void insertAccount(Account account) throws RemoteException {

	}

	@Override
	public Collection<Account> getAccounts(String name) throws RemoteException {
		return null;
	}

}
