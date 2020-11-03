package com.slianOAsys.service.httpModels;

public class MessageSendBean {
	
	private String employeeName;
	
	private String username;
	
	private String Password;
	
	private String Phone;
	
	private String Content;
	
	private String SendTime;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getSendTime() {
		return SendTime;
	}

	public void setSendTime(String sendTime) {
		SendTime = sendTime;
	}
	
	public MessageSendBean(){}
	
    public MessageSendBean(String username , String Password , String Phone 
            , String Content){ 
            this.username = username;
            this.Password = Password;
            this.Phone = Phone;
            this.Content = Content;            
        }

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	
}
