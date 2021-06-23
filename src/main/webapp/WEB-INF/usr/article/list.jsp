<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>

<c:set var="pageTitle" value="게시물 리스트" />
<%@ include file="../part/head.jspf"%>

<section class="section section-article-write">
	<div class="container mx-auto">

		<div class="card bordered shadow-lg">
			<div class="card-title">
				<a href="javascript:history.back();" class="cursor-pointer"> <i
					class="fas fa-chevron-left"></i>
				</a> <span>게시물 리스트</span>
			</div>

			<div class="px-4 py-4">
				<c:forEach items="${articles}" var="article">
					<div>
						<a class="hover:underline cursor-pointer block">
						 <span class="badge badge-outline">제목</span>
							<div class="line-clamp-3">
								Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque ad accusantium alias optio nesciunt ipsum quaerat quas deleniti quae porro aliquam officiis excepturi delectus praesentium a soluta beatae illo hic.
								Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque ad accusantium alias optio nesciunt ipsum quaerat quas deleniti quae porro aliquam officiis excepturi delectus praesentium a soluta beatae illo hic.
								Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque ad accusantium alias optio nesciunt ipsum quaerat quas deleniti quae porro aliquam officiis excepturi delectus praesentium a soluta beatae illo hic.
								Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque ad accusantium alias optio nesciunt ipsum quaerat quas deleniti quae porro aliquam officiis excepturi delectus praesentium a soluta beatae illo hic.
							</div>
						</a>
						<!--
							번호 : ${article.id}
							<br>
							작성 : ${article.regDate}
							<br>
							갱신 : ${article.updateDate}
							<br>
							제목 : ${article.title}
							<br>
							내용 : ${article.body}
							<br>
							-->
					</div>
					<hr />
				</c:forEach>
			</div>
		</div>
	</div>
</section>
<%@ include file="../part/foot.jspf"%>