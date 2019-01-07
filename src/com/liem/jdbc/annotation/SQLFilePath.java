package com.liem.jdbc.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target; 


/**
 * ��ע������ú��÷���
 * 1�������ȡ�ⲿSQL���ʱ������ֱ��дSQL.MD�ļ����ڵ�·������ʱ����ʹ��@SQLFilePath("����ļ���")����
 * 2��Ĭ�ϵ�·���ڡ���Ŀ��Ŀ¼�µ�sql�ļ��С��͡�src��Ŀ¼�µ�sql�ļ��С���������Ҫ�޸�·���� @SQLFilePath("���·��/����ļ���") ����
 * @author Lin Li-PO
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)   
@Documented
public @interface SQLFilePath {   

	/**
	 * ���ݿ������ע�⣬Ĭ��ֵΪ������
	 * @return
	 */
	public String value();

}  