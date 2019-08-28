package com.entity;

public class topic {
	private int tid;
	private String tname;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public topic(int tid, String tname) {
		this.tid = tid;
		this.tname = tname;
	}
}
