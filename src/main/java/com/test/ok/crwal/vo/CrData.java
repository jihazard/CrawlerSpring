/**
 *
 */
package com.test.ok.crwal.vo;

import com.test.ok.crwal.vo.CrData.CrDataBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ?ㅼ???
 *
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CrData {

	private String subject;
	private String explain;
	private String url;
	private String name;
	private String writer;
	private String date;
	private String hit;
	private String ok;
	private String no;
	private String type;
	private String img;
	private int status;
	private int num;



	public CrData(String subject, String url,String name , String type) {
		super();
		this.subject = subject;
		this.url = url;
		this.type=type;
		this.name=name;
	}

	public CrData(String subject, String url, String name, String date, String hit, String ok ,String no,String type) {
		this.subject = subject;
		this.url = url;
		this.name = name;
		this.date = date;
		this.hit = hit;
		this.ok = ok;
		this.no= no;
		this.type=type;
	}

	public CrData(String subject, String url, String name, String date, String hit, String ok ,String no,String type, int num) {
		this.subject = subject;
		this.url = url;
		this.name = name;
		this.date = date;
		this.hit = hit;
		this.ok = ok;
		this.no= no;
		this.type=type;
		this.num= num;
	}





	@Override
	public String toString() {
		return "CrData [subject=" + subject + ", url=" + url + ", name=" + name + ", date=" + date + ", hit=" + hit
				+ ", ok=" + ok + ", no=" + no + "]";
	}
	/**
	 * @return
	 */
	public int getNum() {
		// TODO Auto-generated method stub
		return num;

	}






}
