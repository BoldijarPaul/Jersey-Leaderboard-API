package com.boldijarpaul.rest.entities;

public class RequestResult {

	private String message;
	private int code;
	private Object data;

	public RequestResult() {

	}

	public RequestResult(String message, int code, Object data) {
		super();
		this.message = message;
		this.code = code;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public static class Codes {
		/* request was successful */
		public static int SUCCESS = 1;
		/* missing parameter */
		public static int PARAMETER_MISSING = 2;
		/* invalid value */
		public static int INVALID_VALUE = 3;
	}

}
