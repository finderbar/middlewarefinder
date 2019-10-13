package com.finder.middleware;

import java.rmi.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

import com.finder.middleware.service.AccountReadPlatformService;

/**
 * @author JamesLwin
 * @createdAt Oct 13, 2019
 */
@Configuration
public class RMIConfiguration {
	@Autowired
	private AccountReadPlatformService accountReadPlatformService;
	
	@Bean(name = "/finderEvent")
	RemoteExporter exporterHassian() throws UnknownHostException {
		final HessianServiceExporter hessianExpoter = new HessianServiceExporter();
		hessianExpoter.setService(accountReadPlatformService);
		hessianExpoter.setServiceInterface(AccountReadPlatformService.class);
		/*
		 * hessianExpoter.setInterceptors(Object);
		 * hessianExpoter.setRemoteResolver(Object);
		 */
		return hessianExpoter;
	}
	
	@Bean(name = "/rmiEvent")
	RemoteExporter registerRMIExporter() throws UnknownHostException {
		RmiServiceExporter rmiExporter = new RmiServiceExporter();
		rmiExporter.setServiceName("account");
		rmiExporter.setServiceInterface(AccountReadPlatformService.class);
		rmiExporter.setService(accountReadPlatformService);
		rmiExporter.setRegistryPort(2099);
		
		return rmiExporter;
	}
}
