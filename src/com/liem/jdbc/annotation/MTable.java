package com.liem.jdbc.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target; 


/**
 * 此注解的作用和用法？
 * 当你数据库的表名和实体类名无法映射时（忽略大小写），那么可以使用@MTable("你的表名")即可
 * @author Lin Li-PO
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)   
@Documented
public @interface MTable {   

	/**
	 * 数据库表名称注解，默认值为类名称
	 * @return
	 */
	public String value();

}  