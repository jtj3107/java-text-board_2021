package com.jsh.exam.exam2.dto;

import java.util.Map;

import com.jsh.exam.exam2.util.Ut;

import lombok.Getter;
import lombok.ToString;

@ToString
public class ResultDate {
	@Getter
	private String msg;
	@Getter
	private String resultCode;
	@Getter
	private Map<String, Object> body;
	
	private ResultDate() {
		
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
