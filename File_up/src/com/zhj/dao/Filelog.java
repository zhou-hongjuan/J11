package com.zhj.dao;

public class Filelog {
	private int fid;
	private String fusername;
	private String fcreatetime;
	private String fname;
	private String fpath;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFusername() {
		return fusername;
	}
	public void setFusername(String fusername) {
		this.fusername = fusername;
	}
	public String getFcreatetime() {
		return fcreatetime;
	}
	public void setFcreatetime(String fcreatetime) {
		this.fcreatetime = fcreatetime;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFpath() {
		return fpath;
	}
	public void setFpath(String fpath) {
		this.fpath = fpath;
	}
	public Filelog(int fid, String fusername, String fcreatetime, String fname, String fpath) {
		super();
		this.fid = fid;
		this.fusername = fusername;
		this.fcreatetime = fcreatetime;
		this.fname = fname;
		this.fpath = fpath;
	}
	public Filelog() {
		super();
	}
}
