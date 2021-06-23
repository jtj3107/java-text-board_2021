package com.jsh.exam.exam2.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsh.exam.exam2.http.Rq;
import com.jsh.exam.exam2.http.controller.Controller;
import com.jsh.exam.exam2.http.controller.UsrArticleController;
import com.jtj.mysqlutil.MysqlUtil;
import com.jtj.mysqlutil.SecSql;

@WebServlet("/usr/*")
public class DispatcherServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		Rq rq = new Rq(req,resp);
		
		if (rq.isInvalid()) {
			rq.print("올바른 요청이 아닙니다.");
		}
			
		Controller controller = null;
		
		switch (rq.getControllerTypeName()) {
		case "usr":
			switch (rq.getControllerName()) {
			case "article":
				controller = new UsrArticleController();
				break;
			}
			
			break;
		}
		
		if( controller != null) {
			MysqlUtil.setDBInfo("localhost", "sbsst", "sbs123414", "jsp_board");
			MysqlUtil.setDevMode(true);
			
			controller.perforAction(rq);			
			
			MysqlUtil.closeConnection();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
