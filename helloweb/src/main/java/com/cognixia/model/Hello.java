package com.cognixia.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
public class Hello {

	private String message;
	
	private int id;
	
	private boolean done;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	
}
