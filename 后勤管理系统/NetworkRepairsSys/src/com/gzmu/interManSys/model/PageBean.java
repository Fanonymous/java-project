package com.gzmu.interManSys.model;

/**
 * @author Administrator
 *
 */
public class PageBean {
	private int page; // ҳ��
	private int rows; // ÿҳ��С������
	private int start; // ��ʼҳ��
	
	public PageBean() {
		super();
	}
	//���췽��
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
