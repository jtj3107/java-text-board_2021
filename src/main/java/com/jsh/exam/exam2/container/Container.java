package com.jsh.exam.exam2.container;

import com.jsh.exam.exam2.http.controller.UsrArticleController;
import com.jsh.exam.exam2.http.controller.UsrMemberController;
import com.jsh.exam.exam2.interceptor.BeforeActionInterceptor;
import com.jsh.exam.exam2.interceptor.NeedLoginInterceptor;
import com.jsh.exam.exam2.interceptor.NeedLogoutInterceptor;
import com.jsh.exam.exam2.repository.ArticleRepository;
import com.jsh.exam.exam2.repository.MemberRepository;
import com.jsh.exam.exam2.service.ArticleService;
import com.jsh.exam.exam2.service.MemberService;

public class Container {
	public static BeforeActionInterceptor beforeActionInterceptor;
	public static NeedLoginInterceptor needLoginInterceptor;
	public static NeedLogoutInterceptor needLogoutInterceptor;
	
	public static ArticleRepository articleRepository;
	public static ArticleService articleService;
	public static UsrArticleController usrArticleController;

	public static MemberRepository memberRepository;
	public static MemberService memberService;
	public static UsrMemberController usrMemberController;
	
	public static void init() {
		memberRepository = new MemberRepository();
		articleRepository = new ArticleRepository();

		memberService = new MemberService();
		articleService = new ArticleService();

		beforeActionInterceptor = new BeforeActionInterceptor();
		needLoginInterceptor = new NeedLoginInterceptor();
		needLogoutInterceptor = new NeedLogoutInterceptor();
		
		
		usrMemberController = new UsrMemberController();
		usrArticleController = new UsrArticleController();
	}
}
