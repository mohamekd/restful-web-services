package com.kood.restful_web_services.entitys;

public class FullName {
	public String fName;
	public String sName;
	public FullName(String fName, String sName) {
		super();
		this.fName = fName;
		this.sName = sName;
	}
	public String getfName() {
		return fName;
	}
	public String getsName() {
		return sName;
	}
	@Override
	public String toString() {
		return "FullName [fName=" + fName + ", sName=" + sName + "]";
	}
}
