package com.jsh.exam.exam2.dto;

import java.util.Map;

import com.jsh.exam.exam2.util.Ut;

public class ResultDate {
	private String msg;
	private String resultCode;
	private Map<String, Object> body;

	public String getMsg() {
		return msg;
	}

	public String getResultCode() {
		return resultCode;
	}

	public Map<String, Object> getBody() {
		return body;
	}
	
	public boolean isSuccess() {
		return resultCode.startsWith("S-1");
	}

	public boolean isFail() {
		return !isSuccess();
	}
	
	public static ResultDate from(String resultCode, String msg, Object... bodyArgs) {
		ResultDate rd = new ResultDate();
		
		rd.resultCode = resultCode;
		rd.msg = msg;
		rd.body = Ut.mapOf(bodyArgs);
		
		return rd;
	}

}
