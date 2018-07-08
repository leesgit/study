package com.example.lkoon.movieboja.model;

/**
 * Created by lkoon on 2017-03-17.
 */


public class Address {

    public String to;
    //Data data;
    public String message;

    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Address(String to, String message) {
        this.to = to;
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