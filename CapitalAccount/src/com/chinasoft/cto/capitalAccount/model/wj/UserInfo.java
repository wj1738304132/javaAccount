package com.chinasoft.cto.capitalAccount.model.wj;

import java.util.Date;

public class UserInfo {
	
	private String personid;
	private String accountid;
	private String realname;
	private String birthday;
	private String sex;
	private String cardid;
	public String getAccountid() {
		return accountid;
	}
	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}
	private String address;
	private String telephone;
	private String mail;
	public String getPersonid() {
		return personid;
	}
	public void setPersonid(String personid) {
		this.personid = personid;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public UserInfo() {
		super();
	}
	@Override
	public String toString() {
		return "UserInfo [personid=" + personid + ", accountid=" + accountid
				+ ", realname=" + realname + ", birthday=" + birthday
				+ ", sex=" + sex + ", cardid=" + cardid + ", address="
				+ address + ", telephone=" + telephone + ", mail=" + mail + "]";
	}
	
}
