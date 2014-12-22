package com.hackathon.pierama;

public class Theatre {

	private int id;
	private String movie_id;
	private String name;
	private String status;
	private String hall_id;
	public Theatre()
	{
		//TODO
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHall_id() {
		return hall_id;
	}

	public void setHall_id(String hall_id) {
		this.hall_id = hall_id;
	}

}
