package com.liem.jdbc.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JDBC 面向用户操作接口
 * @author Lin Li-PO
 *
 */
public interface BaseDao  {

	/**
   	 *========================================================================================
  	 *||=========================【单----表----新----增----操----作 】=======================||
  	 *========================================================================================
  	 */
	public interface Add{
		/**
		 * 传入一个对象，自动完成新增
		 * @param obj
		 * @return
		 */
		public static int insert(Object obj) {
			return  BaseDatabase.installSQLAction(obj);
		}
		/**
		 * 自定义传入sql,可接受Object类型的多参数
		 * @param sql
		 * @param params
		 * @return
		 */
		public static int insert(String sql, Object... params) {
			return BaseDatabase.update(sql, params);
		}
		/**
		 * 自定也新增sql,可接受Object类型的List集合
		 * @param sql
		 * @param params
		 * @return
		 */
		public static int insert(String sql, List<Object> params) {
			return BaseDatabase.update(sql, params);
		}
		/**
		 * 传入一个对象，自动完成新增,当第一个参数isKey为true时返回自增的主键
		 * @param isKey
		 * @param obj
		 * @return
		 */
		public static int insert(boolean isKey, Object obj) {
			return  BaseDatabase.installSQLAction(isKey , obj);
		}
		/**
		 * 自定义传入sql,可接受Object类型的多参数,当第一个参数isKey为true时返回自增的主键
		 * @param isKey
		 * @param sql
		 * @param params
		 * @return
		 */
		public static int insert(boolean isKey, String sql, Object... params) {
			return BaseDatabase.update(isKey, sql, params);
		}
		/**
		 * 自定义新增sql,可接受Object类型的List集合,当第一个参数isKey为true时返回自增的主键
		 * @param isKey
		 * @param sql
		 * @param params
		 * @return
		 */
		public static int insert(boolean isKey, String sql, List<Object> params ) {
			return BaseDatabase.update(isKey, sql, params);
		}
		/**
		 * 批量新增,传入一个Object对象List集合，处理规则为每30条新增一次
		 * 返回：新增的条数
		 * @param obj
		 * @return
		 */
		public static int insertBatch(List<?> obj) {
			return  BaseDatabase.installSQLAddBatch(obj);
		}

	}
	
	/**
	 *========================================================================================
	 *||========================【单----表----删----除----操----作 】========================||
	 *========================================================================================
	 */
	public interface Delete{
		/**
		 * 通过truncate删除指定表里所有的数据，truncate将会重置自增id
		 * @param tableName
		 * @return
		 */
		public static boolean truncateAll(String tableName) {
			return BaseDatabase.update(ConstantsSQL.truncatTableSQL.concat(tableName)) > 0 ? true : false;
		}
		/**
		 * 通过delete删除指定表里所有的数据，delete将会保留以前数据的自增id
		 * @param tableName
		 * @return
		 */
		public static boolean deleteAll(String tableName) {
			return BaseDatabase.update(ConstantsSQL.deleteTableSQL.concat(tableName)) > 0 ? true : false;
		}
		/**
		 * 支持自定义sql,通过简单的SQL直接操作
		 * @param sql
		 * @param params
		 * @return
		 */
		public static boolean deleteOne(String sql) {
			return BaseDatabase.update(sql, new ArrayList<>()) > 0 ? true : false;
		}
		/**
		 * 支持自定义sql,并支持一个或多个参数
		 * @param sql
		 * @param params
		 * @return
		 */
		public static boolean deleteOne(String sql, Object... params) {
			return BaseDatabase.update(sql, params) > 0 ? true : false;
		}
	}
	
	/**
	 *========================================================================================
	 *||=========================【单----表----修----改----操----作 】=======================||
	 *========================================================================================
	 */
	public interface Modify{
		public static int updateOne(String sql, Object... params) {
			return BaseDatabase.update(sql, params);
		}
	}
      
	/**
	 *========================================================================================
	 *||========================【单----表----查----询----操----作 】========================||
	 *========================================================================================
	 */
	public interface Query{
		 /**
	     * 根据任意一个条件查询一条数据
	     * @param sql
	     * @param params
	     * @param clazz
	     * @return
	     */
	    @SuppressWarnings("unchecked")
		public static <T> T queryOne(String sql, Object params, Class<?> clazz) {
	    	return (T)BaseDatabase.convertMap(clazz, BaseDatabase.findResult(sql, params).get(0));  
	    }
	    
	    /**
	     * 查询全部数据
	     * @param sql
	     * @param params
	     * @param clazz
	     * @return
	     */
		public static <T> List<T> queryAll(String sql, Class<?> clazz) {
	    	return queryAllCommon(sql, clazz);  
	    }
	    
	    /**
	     * 根据任意一个条件查询多条数据
	     * @param sql
	     * @param params
	     * @param clazz
	     * @return
	     */
		public static <T> List<T> queryAll(String sql, Object params, Class<?> clazz) {
	    	return queryAllCommon(sql, clazz,  params);  
	    }

		/**
	     * 查询全部公共操作方法
	     * @param sql
	     * @param params
	     * @param clazz
	     * @return
	     */
	    @SuppressWarnings("unchecked")
		public static <T> List<T> queryAllCommon(String sql, Class<?> clazz,  Object... params){
	    	List<T> result = new ArrayList<>();
	    	List<Map<String, Object>> mapList =  null; 
	    	if(params.length > 0) mapList = BaseDatabase.findResult(sql, params);
	    	if(params.length == 0) mapList = BaseDatabase.findResult(sql, params);
	    	for(int i=0; i < mapList.size(); i++) {
				result.add((T)BaseDatabase.convertMap(clazz, mapList.get(i)));
	    	}
	    	return result;  
	    }
	}
    
    
	
}
