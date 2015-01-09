package com.hackathon.pierama;

public class Hall {
private String name;
private String status;

public Hall(String name,String status) {
this.setName(name);
this.setStatus(status);
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}
}
