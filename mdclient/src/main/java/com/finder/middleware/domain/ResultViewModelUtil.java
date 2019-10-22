package com.finder.middleware.domain;

public class ResultViewModelUtil {
	
	public static ResultViewModel<Object> success(Object object) {
		ResultViewModel<Object> view = new ResultViewModel<Object>();
		view.setCode(0);
		view.getMessage();
		view.setData(object);
		return view;
	}

	public static ResultViewModel<String> success(String msg) {
		ResultViewModel<String> view = new ResultViewModel<String>();
		view.setCode(0);
		view.getMessage();
		view.setData(msg);
		return view;
	}

	public static ResultViewModel<Object> error(Integer code, String message) {
		ResultViewModel<Object> resultViewModel = new ResultViewModel<Object>();
		resultViewModel.setCode(code);
		resultViewModel.setMessage(message);
		resultViewModel.setData(null);
		return resultViewModel;
	}
	
}
