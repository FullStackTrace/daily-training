package com.zsy.exception;

public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String msg;
	public ServiceException(Throwable e) {
		super(e);
	}
	public ServiceException(String msg) {
		super(msg);
		this.msg = msg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
