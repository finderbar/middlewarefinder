package com.finder.middleware;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianProxyFactoryBean;

import com.finder.middleware.service.AccountReadPlatformService;

@Configuration
public class RMIConfiguration {
	@Bean
	public HessianProxyFactoryBean exporter() {
		HessianProxyFactoryBean b = new HessianProxyFactoryBean();
		b.setServiceUrl("http://localhost:8081/rmiEvent");
		b.setServiceInterface(AccountReadPlatformService.class);
		return b;
	}
}
