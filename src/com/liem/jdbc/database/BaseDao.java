package com.liem.jdbc.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JDBC �����û������ӿ�
 * @author Lin Li-PO
 *
 */
public interface BaseDao  {

	/**
   	 *========================================================================================
  	 *||=========================����----��----��----��----��----�� ��=======================||
  	 *========================================================================================
  	 */
	public interface Add{
		/**
		 * ����һ�������Զ��������
		 * @param obj
		 * @return
		 */
		public static int insert(Object obj) {
			return  BaseDatabase.installSQLAction(obj);
		}
		/**
		 * �Զ��崫��sql,�ɽ���Object���͵Ķ����
		 * @param sql
		 * @param params
		 * @return
		 */
		public static int insert(String sql, Object... params) {
			return BaseDatabase.update(sql, params);
		}
		/**
		 * �Զ�Ҳ����sql,�ɽ���Object���͵�List����
		 * @param sql
		 * @param params
		 * @return
		 */
		public static int insert(String sql, List<Object> params) {
			return BaseDatabase.update(sql, params);
		}
		/**
		 * ����һ�������Զ��������,����һ������isKeyΪtrueʱ��������������
		 * @param isKey
		 * @param obj
		 * @return
		 */
		public static int insert(boolean isKey, Object obj) {
			return  BaseDatabase.installSQLAction(isKey , obj);
		}
		/**
		 * �Զ��崫��sql,�ɽ���Object���͵Ķ����,����һ������isKeyΪtrueʱ��������������
		 * @param isKey
		 * @param sql
		 * @param params
		 * @return
		 */
		public static int insert(boolean isKey, String sql, Object... params) {
			return BaseDatabase.update(isKey, sql, params);
		}
		/**
		 * �Զ�������sql,�ɽ���Object���͵�List����,����һ������isKeyΪtrueʱ��������������
		 * @param isKey
		 * @param sql
		 * @param params
		 * @return
		 */
		public static int insert(boolean isKey, String sql, List<Object> params ) {
			return BaseDatabase.update(isKey, sql, params);
		}
		/**
		 * ��������,����һ��Object����List���ϣ��������Ϊÿ30������һ��
		 * ���أ�����������
		 * @param obj
		 * @return
		 */
		public static int insertBatch(List<?> obj) {
			return  BaseDatabase.installSQLAddBatch(obj);
		}

	}
	
	/**
	 *========================================================================================
	 *||========================����----��----ɾ----��----��----�� ��========================||
	 *========================================================================================
	 */
	public interface Delete{
		/**
		 * ͨ��truncateɾ��ָ���������е����ݣ�truncate������������id
		 * @param tableName
		 * @return
		 */
		public static boolean truncateAll(String tableName) {
			return BaseDatabase.update(ConstantsSQL.truncatTableSQL.concat(tableName)) > 0 ? true : false;
		}
		/**
		 * ͨ��deleteɾ��ָ���������е����ݣ�delete���ᱣ����ǰ���ݵ�����id
		 * @param tableName
		 * @return
		 */
		public static boolean deleteAll(String tableName) {
			return BaseDatabase.update(ConstantsSQL.deleteTableSQL.concat(tableName)) > 0 ? true : false;
		}
		/**
		 * ֧���Զ���sql,ͨ���򵥵�SQLֱ�Ӳ���
		 * @param sql
		 * @param params
		 * @return
		 */
		public static boolean deleteOne(String sql) {
			return BaseDatabase.update(sql, new ArrayList<>()) > 0 ? true : false;
		}
		/**
		 * ֧���Զ���sql,��֧��һ����������
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
	 *||=========================����----��----��----��----��----�� ��=======================||
	 *========================================================================================
	 */
	public interface Modify{
		public static int updateOne(String sql, Object... params) {
			return BaseDatabase.update(sql, params);
		}
	}
      
	/**
	 *========================================================================================
	 *||========================����----��----��----ѯ----��----�� ��========================||
	 *========================================================================================
	 */
	public interface Query{
		 /**
	     * ��������һ��������ѯһ������
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
	     * ��ѯȫ������
	     * @param sql
	     * @param params
	     * @param clazz
	     * @return
	     */
		public static <T> List<T> queryAll(String sql, Class<?> clazz) {
	    	return queryAllCommon(sql, clazz);  
	    }
	    
	    /**
	     * ��������һ��������ѯ��������
	     * @param sql
	     * @param params
	     * @param clazz
	     * @return
	     */
		public static <T> List<T> queryAll(String sql, Object params, Class<?> clazz) {
	    	return queryAllCommon(sql, clazz,  params);  
	    }

		/**
	     * ��ѯȫ��������������
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
