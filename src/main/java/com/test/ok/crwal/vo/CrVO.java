package com.test.ok.crwal.vo;

import java.util.List;

public class CrVO {
	private String page;
	private List<String> crwlList;
	

	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public List<String> getCrwlList() {
		return crwlList;
	}
	public void setCrwlList(List<String> crwlList) {
		this.crwlList = crwlList;
	}
	@Override
	public String toString() {
		return "CrVO [page=" + page + ", crwlList=" + crwlList + "]";
	}
	
	
	
	
}
