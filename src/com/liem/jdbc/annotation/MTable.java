package com.liem.jdbc.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target; 


/**
 * ��ע������ú��÷���
 * �������ݿ�ı�����ʵ�������޷�ӳ��ʱ�����Դ�Сд������ô����ʹ��@MTable("��ı���")����
 * @author Lin Li-PO
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)   
@Documented
public @interface MTable {   

	/**
	 * ���ݿ������ע�⣬Ĭ��ֵΪ������
	 * @return
	 */
	public String value();

}  