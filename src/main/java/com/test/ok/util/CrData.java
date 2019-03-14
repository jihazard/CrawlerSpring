/**
 * 
 */
package com.test.ok.util;

/**
 * @author ?ㅼ???
 *
 */
public class CrData {
	
	private String subject;
	private String url;
	private String name;
	private String date;
	private String hit;
	private String ok;
	private String no;
	
	
	
	
	public CrData() {
		super();
	}


	public CrData(String subject, String url, String name, String date, String hit, String ok ,String no) {
		super();
		this.subject = subject;
		this.url = url;
		this.name = name;
		this.date = date;
		this.hit = hit;
		this.ok = ok;
		this.no= no;
	}
	
	
	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHit() {
		return hit;
	}
	public void setHit(String hit) {
		this.hit = hit;
	}
	public String getOk() {
		return ok;
	}
	public void setOk(String ok) {
		this.ok = ok;
	}
	@Override
	public String toString() {
		return "CrData [subject=" + subject + ", url=" + url + ", name=" + name + ", date=" + date + ", hit=" + hit
				+ ", ok=" + ok + "]";
	}
	
	
	

}