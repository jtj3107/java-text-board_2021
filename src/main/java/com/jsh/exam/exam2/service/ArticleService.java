package com.jsh.exam.exam2.service;

import java.util.List;

import com.jsh.exam.exam2.container.Container;
import com.jsh.exam.exam2.dto.Article;
import com.jsh.exam.exam2.dto.ResultDate;
import com.jsh.exam.exam2.repository.ArticleRepository;
import com.jsh.exam.exam2.util.Ut;

public class ArticleService {
	private ArticleRepository articleRepository = Container.articleRepository;
	
	public ResultDate write(String title, String body) {
		int id = articleRepository.write(title, body);
		
		return ResultDate.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), "id", id);
	}

	public List<Article> getForPrintArticles() {
		return articleRepository.getForPrintArticles();
	}

}
