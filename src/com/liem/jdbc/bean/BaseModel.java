package com.liem.jdbc.bean;

import java.util.Date;

/**
 * ������
 * @author Lin Li-PO
 *
 */
public class BaseModel {
	/**
	 * Ψһ��ʾ
	 */
	private Long id;
	/**
	 * ״̬��
	 */
	private Integer state;
	/**
	 * ����
	 */
	private String memo;
	/**
	 * ����ʱ��
	 */
	private Date createTime;
	/**
	 * ����ʱ��
	 */
	private Date updateTime;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	
}
