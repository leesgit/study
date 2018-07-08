package com.kpu.mfc.domain;

public class IdVO {
	String id;
	int point;

	
	public IdVO() {
		super();
	}
	public IdVO(String id, int point) {
		super();
		this.id = id;
		this.point = point;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public IdVO(String id) {
		super();
		this.id = id;
	}

}
