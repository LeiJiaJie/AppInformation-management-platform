package com.entity;

import java.util.Date;

public class News {
	private int nid; //���ű��
	private int ntid; //������
	private String ntitle;	//����
	private String nauthor; //����
	private Date time; //ʱ��
	private	String ncontent; //����
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
