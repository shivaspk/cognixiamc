package com.cognixia.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Todo {
	
	@GeneratedValue
	@Id
	private int id;
	
	@NotNull
	@NotBlank
	@Size(min = 3, max = 25, message = "Username should be between 3 and 25" )
	private String user;
	
	private boolean done;
	
	@Size(max = 250, message = "Des should cannot be longer than 250" )
	private String des;
	
	private Date targetDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	@Override
	public String toString() {
		return "Todo [user=" + user + ", done=" + done + ", des=" + des + ", targetDate=" + targetDate + "]";
	}
	
	
	
	
}
