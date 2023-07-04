<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include2/header.jsp" %>
<html lang="en">
<div class="d-sm-flex align-items-center justify-content-between mb-4">
	<h1 class="h3 mb-0 text-gray-800">Board Register</h1>
</div>
<div class="header">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/main-board">Main</a></li>
			<li class="breadcrumb-item"><a href="/list?page=1&amount=10&type=&keyword=">Dashboard</a></li>
			<li class="breadcrumb-item"><a href="/blog">Blog</a></li>
		</ol>
</div>
  <head>
    <meta charset="UTF-8">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
  </head>
<body>
<!-- Page Heading -->
<div class="row"> 
    <div class="col">
		<form action="" method="post" id="registerForm" novalidate>
			<div class="form-group">
				<label for="title">Title</label>
				<input type="text" class="form-control" id="title" placeholder="title" name="title" required>
				<div class="invalid-feedback">
					제목을 확인해주세요.
				</div>
			</div>
			<div class="form-group">
				<label for="content">Content</label>
				<textarea class="form-control" id="summernote" rows="10" name="content" placeholder="content" required></textarea>
				<div class="invalid-feedback">
					내용을 확인해주세요.
				</div>
			</div>
			<div class="form-group">
    <label for="userid">User</label>
    <input type="text" class="form-control" id="userid" name="userid" readonly 
			value='<security:authentication property="principal.username"/>'>
    <div class="invalid-feedback">
        작성자를 확인해주세요.
    </div>
</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<button type="submit" class="btn btn-primary">등록</button>
			<button type="button" class="btn btn-secondary">
			<a href="/list?page=1&amount=10&type=&keyword=">
			<div style="color: #ffffff">취소</div>
			</a></button>
		</form>
	</div>
</div>
<div class="row mt-3">
	<div class="col">
		<div class="card">
			<div class="card-header">
				<i class="fa fa-file"></i> 
				파일첨부
			</div>
			<div class="card-body">
				<div class="form-group uploadDiv">
					<input type="file" name="uploadFile" id="uploadFile" multiple/>
				</div>
				<div class="uploadResult">
					<ul></ul>
				</div>
			</div>
		</div>
	</div>
</div>

<script>
$(document).ready(function() {
    $('#summernote').summernote({
      tabsize: 2,
      height: 300,
      toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['insert', ['link', 'picture', 'video']],
          ['view', ['fullscreen', 'codeview', 'help']]
      ]
    });
});
</script>
<script>
	const path='${pageContext.request.requestURI}';
	
	// CSRF 토큰 값 생성
	const csrfToken='${csrf.token}';
</script>
</body>
</html>
<script src="/js/register.js"></script>
<script src="/js/upload.js"></script>

<%@ include file="include2/footer.jsp" %>    
<%@ include file="include2/footer.jsp" %>    

