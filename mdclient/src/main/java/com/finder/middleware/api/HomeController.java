package com.finder.middleware.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finder.middleware.domain.ResultViewModel;
import com.finder.middleware.domain.ResultViewModelUtil;
import com.finder.middleware.service.AccountReadPlatformService;

@RestController
@RequestMapping("/api/v1")
public class HomeController {
	
	@Autowired
	private AccountReadPlatformService service;

	@RequestMapping("/rpc")
	public ResultViewModel<?> test() {
		try {
			String name = service.getAccounts("theinlwin");
			return ResultViewModelUtil.success(name);
		} catch (Exception e) {
			return ResultViewModelUtil.error(500, e.getMessage());
		}
	}
	
	
}
