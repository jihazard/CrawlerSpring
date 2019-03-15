package com.test.ok.util;

public class CrVO {
	private boolean isTodayHumor = true;
	private boolean isClien = true;
	private boolean isPpomppu = true;
	private boolean isHumorUniv = true;
	
	private int callPageNum = 3;
	

	public boolean isHumorUniv() {
		return isHumorUniv;
	}

	public void setHumorUniv(boolean isHumorUniv) {
		this.isHumorUniv = isHumorUniv;
	}

	public boolean isTodayHumor() {
		return isTodayHumor;
	}

	public void setTodayHumor(boolean isTodayHumor) {
		this.isTodayHumor = isTodayHumor;
	}

	public boolean isClien() {
		return isClien;
	}

	public void setClien(boolean isClien) {
		this.isClien = isClien;
	}

	public boolean isPpomppu() {
		return isPpomppu;
	}

	public void setPpomppu(boolean isPpomppu) {
		this.isPpomppu = isPpomppu;
	}

	public int getCallPageNum() {
		return callPageNum;
	}

	public void setCallPageNum(int callPageNum) {
		this.callPageNum = callPageNum;
	}

	@Override
	public String toString() {
		return "CrVO [isTodayHumor=" + isTodayHumor + ", isClien=" + isClien + ", isPpomppu=" + isPpomppu
				+ ", callPageNum=" + callPageNum + "]";
	}
	
	
}
