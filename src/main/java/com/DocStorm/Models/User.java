package com.DocStorm.Models;

import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import org.json.JSONArray;
import org.json.JSONObject;

@Entity
@Table(name = "user")
public class User {

	private String username;
	private String useremail;
	private String password;
	private String usertype;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Document> Documents;

	public User() {
	}

	public User(String username, String useremail, String password, String usertype) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.password = password;
		this.usertype = usertype;
	}

	public User(String username, String useremail, String password) {
		super();
		this.username = username;
		this.useremail = useremail;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Set<Document> getDocuments() {
		return Documents;
	}

	public void setDocuments(Set<Document> documents) {
		Documents = documents;
	}

	@Override
	public String toString() {

		String str = "";
		str += "<br>User : " + " Name:" + this.getUsername() + " , Email:" + this.getUseremail() + " , UserID:"
				+ this.getUserid() + " , UserType:" + this.getUsertype();
		if(!(this.Documents==null)) {
			str+=" , and  have " + this.getDocuments().size() + " Document." + this.getDocuments();
		}
		return str+"<br>";
	}

}
