<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Dashboard</title>


<!-- Custom fonts for this template -->
<link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/sb-admin-2.min.css" rel="stylesheet">
<link href="/css/bootswatch.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="/vendor/jquery/jquery.min.js"></script>
<!-- Modal 창을 띄우기 위한 코드 -->
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- lightbox -->
<link href="/css/lightbox/lightbox.min.css" rel="stylesheet">
<script src="/js/lightbox/lightbox.min.js"></script>

<!-- upload css -->
<link href="/css/upload.css" rel="stylesheet">
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<ul
			class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
			id="accordionSidebar">

			<!-- Sidebar - Brand -->
			<a class="sidebar-brand d-flex align-items-center justify-content-center" href="/list?page=1&amount=10&type=&keyword=">
				<div class="sidebar-brand-text mx-3">Admin Board</div>
			</a>

			<!-- Divider -->
			<hr class="sidebar-divider my-0">

			<!-- Nav Item - Dashboard -->
			<li class="nav-item active"><a class="nav-link"
				href='<c:url value="/"/>'> <i
					class="fas fa-fw fa-tachometer-alt"></i> <span>Movie Home</span></a></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

			<!-- Heading -->
			<div class="sidebar-heading">메인</div>

			<!-- Nav Item - Pages Collapse Menu -->
			<li class="nav-item"><a class="nav-link collapsed" href="#"
				data-toggle="collapse" data-target="#collapseTwo"
				aria-expanded="true" aria-controls="collapseTwo"> <i
					class="fas fa-fw fa-folder"></i> <span>전체 게시물</span>
			</a>
				<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
					data-parent="#accordionSidebar">
					<div class="bg-white py-2 collapse-inner rounded">
						<a class="collapse-item" href="/list?page=1&amount=10&type=&keyword=">게시물</a>
					</div>
				</div></li>

			<!-- Divider -->
			<hr class="sidebar-divider">

		</ul>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Navbar -->
					<ul class="navbar-nav ml-auto">
						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-600 small"> <security:authorize
										access="isAuthenticated()">
										<security:authentication
											property="principal.memberDTO.userid" />
									</security:authorize>
							</span> <img class="img-profile rounded-circle"
								src="/img/undraw_profile.svg">
						</a> 
						<!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								
									<!-- 인증 정보 여부에 따라 Login / Logout 메뉴 설정 -->
								<security:authorize access="isAnonymous()">
									<a class="dropdown-item" href="/login"> <i
										class="fas fa-sign-in-alt fa-sm fa-fw mr-2 text-gray-400"></i>
										Login
									</a>
								</security:authorize>

								<security:authorize access="isAuthenticated()">
								<form action="/logout" method="post">
									<button class="dropdown-item" href="#" data-toggle="modal"
										data-target="#logoutModal" type="submit"> <i
										class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
										Logout
									</button>
								</form>
								</security:authorize>
								
							</div>
						</li>
					</ul>

				</nav>
				<!-- End of Topbar -->
				<div class="container-fluid">
