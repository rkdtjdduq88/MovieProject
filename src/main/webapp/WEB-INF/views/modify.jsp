<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include2/header.jsp" %>
<!-- Page Heading -->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Board Modify</h1>
</div>
<div class="header">
		<ol class="breadcrumb">
			<li><a href="/main-board">Home</a></li>
			<li><a href="/list?page=1&amount=10&type=&keyword=">Dashboard</a></li>
			<li><a href="/blog">Blog</a></li>
		</ol>
</div>
<div class="row">
    <div class="col">
		<form action="" method="post" id="modifyForm">
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" class="form-control" id="title" name="title" value="${dto.title}">
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<textarea class="form-control" id="content" rows="10" name="content">${dto.content}</textarea>
			</div>
			<div class="form-group">
				<label for="writer">User</label>
				<input type="text" class="form-control" id="writer" name="writer" readonly value="${dto.userid}">
			</div>
			<input type="hidden" name="bno" value="${dto.bno}" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			
			<%-- <security:authorize access="isAuthenticated()">
				<security:authentication property="principal.username" var="username"/>
				<c:if test="${username==dto.userid}">
					<button type="submit" class="btn btn-info">수정</button>
					<button type="button" class="btn btn-danger">삭제</button>
				</c:if>
			</security:authorize> --%>
			<button type="submit" class="btn btn-info">수정</button>
			<button type="button" class="btn btn-danger">삭제</button>
			<button type="button" class="btn btn-secondary">목록</button>
		</form>
	</div>
</div>

<!-- 파일 첨부 폼 -->
<div class="row mt-3">
	<div class="col">
		<div class="card">
			<div class="card-header">
				<i class="fa fa-file"></i> 
				파일첨부
			</div>
			<div class="card-body">
				<div class="form-group uploadDiv">
					<input type="file" name="uploadFile" id="uploadFile" multiple />
				</div>
				<div class="uploadResult">
					<ul></ul>
				</div>
			</div>
		</div>
	</div>
</div>

<form action="" id="operForm">
    <input type="hidden" name="bno" value="${dto.bno}" />
    <input type="hidden" name="page" value="${cri.page}" />
    <input type="hidden" name="amount" value="${cri.amount}" />
    <input type="hidden" name="type" value="${cri.type}" />
    <input type="hidden" name="keyword" value="${cri.keyword}" />
    <input type="hidden" name="userid" value="${dto.userid}" />
</form>


<script>
	const bno=${dto.bno};
	const path='${pageContext.request.requestURI}';
	
	// CSRF 토큰 값 생성
	const csrfToken='${_csrf.token}';
</script>
<script src="/js/modify.js"></script>
<script src="/js/upload.js"></script>
<%@ include file="include2/footer.jsp" %>