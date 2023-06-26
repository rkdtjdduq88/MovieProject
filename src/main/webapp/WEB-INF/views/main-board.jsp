<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include2/header.jsp"%>

<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
</div>
<div id="content1">
	<%-- get 방식으로 주소줄에 총 4개의 변수를 보낸다. page=1, amount=10, type=, keyword= --%>
	<div class="header">
		<ol class="breadcrumb">
			<li><a href="/main-board">Main</a></li>
			<li><a href="/list?page=1&amount=10&type=&keyword=">Dashboard</a></li>
			<li><a href="/blog">Blog</a></li>
		</ol>
	</div>

	<%-- 메인 방문자수 --%>
	<div class="dashboard-cards">
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-3">
				<div class="card horizontal cardIcon waves-effect waves-dark">
					<div class="card-stacked red">
						<div class="card-content">
							<h3>84,198</h3>
						</div>
						<div class="card-action">
							<strong>총 방문자 수</strong>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3">
				<div class="card horizontal cardIcon waves-effect waves-dark">
					<div class="card-stacked orange">
						<div class="card-content">
							<h3>36,540</h3>
						</div>
						<div class="card-action">
							<strong>일일 방문자 수</strong>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3">
				<div class="card horizontal cardIcon waves-effect waves-dark">
					<div class="card-stacked blue">
						<div class="card-content">
							<h3>24,225</h3>
						</div>
						<div class="card-action">
							<strong>총 댓글 수</strong>
						</div>
					</div>
				</div>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-3">
				<div class="card horizontal cardIcon waves-effect waves-dark">
					<div class="card-stacked green">
						<div class="card-content">
							<h3>${totalPosts}</h3>
						</div>
						<div class="card-action">
							<strong>총 게시물 수</strong>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="include2/footer.jsp"%>