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

	public Article getForPrintArticleById(int id) {
		return articleRepository.getRequestDispatcher(id);
	}

	public ResultDate delete(int id) {
		articleRepository.delete(id);
		
		return ResultDate.from("S-1", Ut.f("%d번 게시물이 삭제되었습니다.", id), "id", id);
	}

	public ResultDate modify(int id, String title, String body) {
		articleRepository.modify(id, title, body);
		
		return ResultDate.from("S-1", Ut.f("%d번 게시물이 수정되었습니다.", id), "id", id);
	}

}
