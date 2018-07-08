package com.kpu.mfc.domain;

import java.sql.Timestamp;
import java.util.Date;

public class Address {
	
	public String id;
	//Data data;
	public String message;
	public Date date;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTo() {
		return id;
	}
	public void setTo(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	
	
//	public String getTo() {
//		return to;
//	}
//
//
//
//	public void setTo(String to) {
//		this.to = to;
//	}
//
//
//
//	public Data getData() {
//		return data;
//	}
//
//
//
//	public void setData(Data data) {
//		this.data = data;
//	}
//
//	public Address(String to, Data data) {
//		this.to = to;
//		this.data = data;
//	}
//
//
//
//	class Data{
//		String title;
//		String message;
//		public String getTitle() {
//			return title;
//		}
//		public void setTitle(String title) {
//			this.title = title;
//		}
//		public String getMessage() {
//			return message;
//		}
//		public void setMessage(String message) {
//			this.message = message;
//		}
//	
//		public Data(String title, String message) {
//			this.title = title;
//			this.message = message;
//		}
//	}
}