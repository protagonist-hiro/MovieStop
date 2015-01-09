package com.hackathon.pierama;

public class Time {
	private String movie_id;
	private String hall_id;
	private String startTime;
	private String endTime;
	private String status;

	public Time(String movie_id, String hall_id, String startTime,
			String endTime, String status) {
		this.setMovie_id(movie_id);
		this.setHall_id(hall_id);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
		this.setStatus(status);
	}

	public String getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}

	public String getHall_id() {
		return hall_id;
	}

	public void setHall_id(String hall_id) {
		this.hall_id = hall_id;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
