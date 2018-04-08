package cn.weicao.register.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Member implements Serializable{
	private String id ;
	private String password ;
	private Integer fid ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public Integer getFid() {
		return fid;
	}
	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", fid=" + fid + "]";
	}
	
}
