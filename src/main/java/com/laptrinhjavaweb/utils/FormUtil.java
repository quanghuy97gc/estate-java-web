package com.laptrinhjavaweb.utils;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {
	
	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> zClass,HttpServletRequest request) {
		T object = null;
		try {
			object = zClass.newInstance();
			BeanUtils.populate(object, request.getParameterMap());;
		} catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
			System.out.println(e.getMessage());
		}
		return object;
	}
}
