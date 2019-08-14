package com.zsy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.zsy.asserts.Assert;
import com.zsy.exception.Throws;

public class PropertiesUtil {
	
	public static Properties properties(String path) {
		Assert.notEmpty(path, "路径不能为空！");
		path = path.trim();
		Properties pro = new Properties();
		if(path.startsWith("file://")) {
			loadPropertiesFromFileSystem(pro, path);
		} else if(path.startsWith("classpath://")) {
			loadPropertiesFromClassPath(pro, path);
		} else {
			try {
				loadPropertiesFromFileSystem(pro, path);
			} catch (Exception e) {
				loadPropertiesFromClassPath(pro, path);
			}
		}
		return pro;
	}
	
	private static void loadPropertiesFromFileSystem(Properties pro, String path) {
		path = path.replaceFirst("file://", "");
		try {
			File file = new File(path);
			pro.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			Throws.serviceException(e);
		} catch (IOException e) {
			Throws.serviceException(e);
		}
	}
	
	private static void loadPropertiesFromClassPath(Properties pro, String path) {
		path = path.replaceFirst("classpath://", "");
		try {
			pro.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(path));
		} catch (IOException e) {
			Throws.serviceException(e);
		}
	}
}
