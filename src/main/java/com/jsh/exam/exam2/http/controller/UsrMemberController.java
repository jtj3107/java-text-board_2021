package com.jsh.exam.exam2.http.controller;

import com.jsh.exam.exam2.container.Container;
import com.jsh.exam.exam2.dto.Member;
import com.jsh.exam.exam2.dto.ResultDate;
import com.jsh.exam.exam2.http.Rq;
import com.jsh.exam.exam2.service.MemberService;
import com.jsh.exam.exam2.util.Ut;

public class UsrMemberController extends Controller {
	private MemberService memberService = Container.memberService;

	@Override
	public void perforAction(Rq rq) {
		switch (rq.getActionMethodName()) {
		case "login":
			actionShowLogin(rq);
			break;
		case "doLogin":
			actionDoLogin(rq);
			break;
		default:
			rq.println("존재하지 않는 페이지입니다.");
			break;
		}
	}

	private void actionDoLogin(Rq rq) {
		String loginId = rq.getParam("loginId", "");
		String loginPw = rq.getParam("loginPw", "");

		if (loginId.length() == 0) {
			rq.historyBack("loginId을 입력해주세요.");
			return;
		}

		if (loginPw.length() == 0) {
			rq.historyBack("loginPw을 입력해주세요.");
			return;
		}

		ResultDate loginRd = memberService.login(loginId, loginPw);
		
		if(loginRd.isFail()) {
			rq.historyBack(loginRd.getMsg());
		}
		
		Member member = (Member)loginRd.getBody().get("member");
		
		rq.setSesstionAttr("loginedMemberJson", Ut.toJson(member, ""));
		rq.replace(loginRd.getMsg(), "../article/list");
	}

	private void actionShowLogin(Rq rq) {
		rq.jsp("usr/member/login");
	}
}
