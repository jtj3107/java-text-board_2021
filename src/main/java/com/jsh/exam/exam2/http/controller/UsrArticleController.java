package com.jsh.exam.exam2.http.controller;

import java.util.List;

import com.jsh.exam.exam2.container.Container;
import com.jsh.exam.exam2.dto.Article;
import com.jsh.exam.exam2.dto.ResultDate;
import com.jsh.exam.exam2.http.Rq;
import com.jsh.exam.exam2.service.ArticleService;

public class UsrArticleController extends Controller{
	private ArticleService articleService = Container.articleService;
	
	@Override
	public void perforAction(Rq rq) {
		switch (rq.getActionMethodName()) {
		case "list":
			actionShowList(rq);
			break;
		case "write":
			actionShowWrite(rq);
			break;
		case "doWrite":
			actionDoWrite(rq);
			break;
		default:
			rq.println("존재하지 않는 페이지입니다.");
			break;
		}
	}

	private void actionShowList(Rq rq) {
		List<Article> articles = articleService.getForPrintArticles();
	
		rq.setAttr("articles", articles);
		
		rq.jsp("usr/article/list");
	}

	private void actionDoWrite(Rq rq) {
		String title = rq.getParam("title", "");
		String body = rq.getParam("body", "");
		String redirectUri = rq.getParam("redirectUri", "../article/list");
		
		if(title.length() == 0) {
			rq.historyBack("title을 입력해주세요.");
			return;
		}
		
		if(body.length() == 0) {
			rq.historyBack("body을 입력해주세요.");
			return;
		}
		
		ResultDate writeRd = articleService.write(title, body);
		int id = (int)writeRd.getBody().get("id");
		
		redirectUri = redirectUri.replace("[NEW_ID]", id + "");
		
		rq.replace(writeRd.getMsg(), redirectUri);
	}

	private void actionShowWrite(Rq rq) {
		rq.jsp("usr/article/write");
	}
	
}
