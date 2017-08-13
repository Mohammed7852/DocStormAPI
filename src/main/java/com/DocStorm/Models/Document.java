package com.DocStorm.Models;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

import org.json.JSONObject;
import org.json.JSONArray;

@Entity
@Table(name = "document")
public class Document {

	private String docname;
	private String tag;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "docwriter")
	private User user;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int docid;

	@OneToMany(mappedBy = "document", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<DocumentTranslation> documentTranslations;

	public Document(String docname, String tag, Date date, User user) {
		this.docname = docname;
		this.tag = tag;
		this.date = date;
		this.user = user;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Document() {
		// TODO Auto-generated constructor stub
	}

	public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDocid() {
		return docid;
	}

	public void setDocid(int docid) {
		this.docid = docid;
	}

	public Set<DocumentTranslation> getDocumentTranslations() {
		return documentTranslations;
	}

	public void setDocumentTranslations(Set<DocumentTranslation> documentTranslations) {
		this.documentTranslations = documentTranslations;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {

		String str = "";
		str += "<br>Document: " + " Name:" + this.getDocname() + " , ID:" + this.getDocid() + " , Tag:" + this.getTag()
				+ " ,Date:" + this.getDate();
		if (!(this.documentTranslations==null)) {
			str += ", and  have " + this.getDocumentTranslations().size() + " Translation. "
					+ this.getDocumentTranslations();
		}
		return str+"<br>";
	}
}
