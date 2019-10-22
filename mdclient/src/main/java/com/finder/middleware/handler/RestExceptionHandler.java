package com.finder.middleware.handler;

import org.springframework.web.bind.annotation.RestController;

import com.finder.middleware.annotation.ExceptionHandler;
import com.finder.middleware.annotation.ExceptionWrapper;
import com.finder.middleware.domain.ResultViewModel;
import com.finder.middleware.domain.ResultViewModelUtil;
import com.finder.middleware.exception.BaseException;


@ExceptionWrapper(annotations = RestController.class)
public class RestExceptionHandler {
	@ExceptionHandler(value = BaseException.class)
    public ResultViewModel girlExceptionHandler(BaseException e) {
        return ResultViewModelUtil.error(e.getCode(), e.getMessage());
    }
}
