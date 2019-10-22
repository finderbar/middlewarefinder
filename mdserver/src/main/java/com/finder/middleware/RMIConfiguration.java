package com.finder.middleware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.support.RemoteExporter;

import com.finder.middleware.service.AccountReadPlatformService;

@Configuration
public class RMIConfiguration {
	@Autowired private AccountReadPlatformService accountReadPlatformService;
	@Bean(name = "/rmiEvent")
	RemoteExporter exporterHassian() {
		final HessianServiceExporter hessianExpoter = new HessianServiceExporter();
		hessianExpoter.setService(accountReadPlatformService);
		hessianExpoter.setServiceInterface(AccountReadPlatformService.class);
		return hessianExpoter;
	}
}
