package com.kuniwake.agenda.exceptions;

public class StandardError {

	private Long time;
	private Integer status;
	private String msg;

	public StandardError() {
		super();
	}

	public StandardError(Long time, Integer status, String msg) {
		super();
		this.time = time;
		this.status = status;
		this.msg = msg;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
