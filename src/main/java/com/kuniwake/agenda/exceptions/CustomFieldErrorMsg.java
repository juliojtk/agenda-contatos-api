package com.kuniwake.agenda.exceptions;

import java.io.Serializable;

public class CustomFieldErrorMsg implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fildName;
	private String msg;

	public CustomFieldErrorMsg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomFieldErrorMsg(String fildName, String msg) {
		super();
		this.fildName = fildName;
		this.msg = msg;
	}

	public String getFildName() {
		return fildName;
	}

	public void setFildName(String fildName) {
		this.fildName = fildName;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
