package com.DocStorm.Models;

import java.util.Date;

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
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "documenttranlation", schema = "docstorm", catalog = "")
public class DocumentTranslation {

	private String LangCode;
	private String Translation;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Createdate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transid;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Docid")
	private Document document;

	public DocumentTranslation() {
	}

	public DocumentTranslation(String LangCode, String Translation, Date Createdate, Document document) {
		this.LangCode = LangCode;
		this.Translation = Translation;
		this.Createdate = Createdate;
		this.document = document;
	}

	public String getLangCode() {
		return LangCode;
	}

	public void setLangCode(String langCode) {
		LangCode = langCode;
	}

	public String getTranslation() {
		return Translation;
	}

	public void setTranslation(String translation) {
		Translation = translation;
	}

	public Date getCreatedate() {
		return Createdate;
	}

	public void setCreatedate(Date createdate) {
		Createdate = createdate;
	}

	public int getTransid() {
		return transid;
	}

	public void setTransid(int transid) {
		this.transid = transid;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	@Override
	public String toString() {
		return "<br>Translation : " + "  Date:" + this.getCreatedate() + " , Translation:"
				+ this.getTranslation() + " , LangCode:" + this.getLangCode() + " , TransID:" + this.getTransid()
				+ "<br>";
	}

}
