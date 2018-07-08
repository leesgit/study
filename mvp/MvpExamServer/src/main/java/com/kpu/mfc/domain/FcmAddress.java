package com.kpu.mfc.domain;

public class FcmAddress {
	
	
	public String to;
	public Data data;
	
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	

	
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	public void setTitle(String title){
		if(data == null)
			data = new Data();
		data.setTitle(title);
	}
	
	public void setMessage(String message){
		if(data == null)
			data = new Data();
		data.setMessage(message);
	}

	class Data{
		String title;
		String message;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
}
