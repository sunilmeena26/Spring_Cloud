package com.telusko.SpringMVCDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien {
	
	 public Alien() {
		super();
	}
	public Alien(int aid, String aname) {
		super();
		this.aid = aid;
		this.aname = aname;
	}
	@Id
	 private int aid;
	 private String aname;
	   
	   
    @Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + "]";
	}
   public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
}
