package com.jsh.exam.exam2.interceptor;

import com.jsh.exam.exam2.http.Rq;

public class NeedLogoutInterceptor extends Interceptor{

	@Override
	public boolean runBeforeAction(Rq rq) {
		return true;
	}
	
}
