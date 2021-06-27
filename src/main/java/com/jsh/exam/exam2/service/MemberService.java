package com.jsh.exam.exam2.service;

import com.jsh.exam.exam2.container.Container;
import com.jsh.exam.exam2.dto.Member;
import com.jsh.exam.exam2.dto.ResultDate;
import com.jsh.exam.exam2.repository.MemberRepository;

public class MemberService {
	private MemberRepository memberRepository = Container.memberRepository;

	public ResultDate login(String loginId, String loginPw) {
		Member member = memberRepository.getMemberByLoginId(loginId);
		
		if (member == null) {
			return ResultDate.from("F-1","존재하지 않는 회원의 로그인아이디 입니다.");
		}
		
		if(member.getLoginPw().equals(loginPw) == false) {
			return ResultDate.from("F-2", "비밀번호가 일치하지 않습니다.");
		}
		
		return ResultDate.from("S-1","환영합니다.", "member", member);
	}

}
