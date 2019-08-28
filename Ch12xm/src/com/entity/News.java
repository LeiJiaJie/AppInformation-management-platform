package com.entity;

import java.util.Date;

public class News {
	private int nid; //新闻编号
	private int ntid; //主题编号
	private String ntitle;	//标题
	private String nauthor; //作者
	private Date time; //时间
	private	String ncontent; //内容
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public int getNtid() {
		return ntid;
	}
	public void setNtid(int ntid) {
		this.ntid = ntid;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNauthor() {
		return nauthor;
	}
	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getNcontent() {
		return ncontent;
	}
	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}
	public News(int nid, int ntid, String ntitle, String nauthor, Date time, String ncontent) {
		this.nid = nid;
		this.ntid = ntid;
		this.ntitle = ntitle;
		this.nauthor = nauthor;
		this.time = time;
		this.ncontent = ncontent;
	}
	public News() {
		
	}
}
