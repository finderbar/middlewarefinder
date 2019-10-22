package com.finder.middleware.exception;

public class BaseException extends RuntimeException {
	private Integer code;

	public BaseException(BaseException ex) {
		super(ex.getMessage());
		this.code = ex.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
