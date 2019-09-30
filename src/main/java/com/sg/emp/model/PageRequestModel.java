package com.sg.emp.model;

import java.io.Serializable;

public class PageRequestModel implements Serializable {
	
	private static final long serialVersionUID = -5819263702787802199L;
	
	Integer pageNum = 0;
	Integer count = 10;
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
}
