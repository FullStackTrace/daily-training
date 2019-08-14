package com.zsy.exception;

public class Throws {
	
	public static void serviceException(Throwable e) {
		throw new ServiceException(e);
	}
	
	public static void serviceException(String msg) {
		throw new ServiceException(msg);
	}
}
