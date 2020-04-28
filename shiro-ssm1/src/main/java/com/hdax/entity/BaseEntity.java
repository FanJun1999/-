package com.hdax.entity;

import java.util.Date;

public class BaseEntity {
	protected Integer createdby;
	protected Date creationdate;
	protected Integer modifyby;
	protected Date modifydate;
	public BaseEntity(Integer createdby, Date creationdate, Integer modifyby, Date modifydate) {
		super();
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
	}
	public BaseEntity() {
		super();
	}
	public Integer getCreatedby() {
		return createdby;
	}
	public void setCreatedby(Integer createdby) {
		this.createdby = createdby;
	}
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	public Integer getModifyby() {
		return modifyby;
	}
	public void setModifyby(Integer modifyby) {
		this.modifyby = modifyby;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

}
