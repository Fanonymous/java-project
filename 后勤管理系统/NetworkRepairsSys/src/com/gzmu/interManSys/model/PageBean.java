package com.gzmu.interManSys.model;

/**
 * @author Administrator
 *
 */
public class PageBean {
	private int page; // 页数
	private int rows; // 每页大小，行数
	private int start; // 开始页数
	
	public PageBean() {
		super();
	}
	//构造方法
	public PageBean(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getStart() {
		return (page - 1) * rows;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
}
