package com.liem.jdbc.annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target; 


/**
 * 此注解的作用和用法？
 * 1、当你获取外部SQL语句时，不想直接写SQL.MD文件所在的路径，这时可以使用@SQLFilePath("你的文件名")即可
 * 2、默认的路径在【项目根目录下的sql文件夹】和【src根目录下的sql文件夹】里，如果你需要修改路劲则 @SQLFilePath("你的路径/你的文件名") 即可
 * @author Lin Li-PO
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)   
@Documented
public @interface SQLFilePath {   

	/**
	 * 数据库表名称注解，默认值为类名称
	 * @return
	 */
	public String value();

}  