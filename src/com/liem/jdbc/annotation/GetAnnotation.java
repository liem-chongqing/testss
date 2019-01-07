package com.liem.jdbc.annotation;

import java.lang.annotation.Annotation;

public class GetAnnotation {

	/**
	 * ��ȡ���ϵ�ע��
	 * @param clazz
	 * @return
	 */
	public static String getMTableAnnottionValue(Class<?> clazz) {
		// ��ȡ���ϵ�ע��
    	Annotation[] annotations = clazz.getAnnotations();
    	if(annotations.length > 0) {
    		MTable table = clazz.getAnnotation(MTable.class);
        	return table.value();
    	}
    	return "";
	}

	public static String getSQLFilePathAnnottionValue(Class<?> clazz) {
		// ��ȡ���ϵ�ע��
    	Annotation[] annotations = clazz.getAnnotations();
    	if(annotations.length > 0) {
    		SQLFilePath table = clazz.getAnnotation(SQLFilePath.class);
        	return table.value();
    	}
    	return "";
	}
	
 
}
