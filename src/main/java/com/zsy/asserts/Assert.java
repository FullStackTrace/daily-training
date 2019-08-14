package com.zsy.asserts;

import java.util.Collection;
import java.util.Map;

import com.zsy.exception.AssertsException;

public class Assert {

	public static void notNull(Object obj, String msg) {
		if(obj == null) throwException(msg);
	}
	
	public static void notEmpty(Object obj, String msg) {
		Assert.notNull(obj, msg);
		if((obj instanceof String && "".equals(obj)) || (obj instanceof Collection && ((Collection<?>)obj).size() <= 0)
				|| (obj instanceof Map && ((Map<?, ?>)obj).isEmpty())) {
			throwException(msg);
		} else if("".equals(obj.toString())){
			throwException(msg);
		}
	}
	
	private static void throwException(String msg) {
		throw new AssertsException(msg);
	}
}
