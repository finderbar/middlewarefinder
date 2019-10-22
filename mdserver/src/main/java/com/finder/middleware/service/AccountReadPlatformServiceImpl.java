package com.finder.middleware.service;

import java.rmi.RemoteException;
import org.springframework.stereotype.Service;

import com.finder.middleware.domain.Account;


/**
 * @author JamesLwin
 * @createdAt Oct 13, 2019
 */
@Service
public class AccountReadPlatformServiceImpl implements AccountReadPlatformService {

	@Override
	public Long insertAccount(Account account) throws RemoteException {
		System.out.println(account.getId());
		System.out.println(account.getName());
		return 1l;
	}

	@Override
	public String getAccounts(String name) throws RemoteException {
		System.out.println("hello world");
		return name;
	}

}
