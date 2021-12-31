<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
<jsp:include page="/views/admin/users/menu.jsp"></jsp:include>
	<main class="container">
		<!-- <header class="row pt-5 pb-0">
			<div class="col-9">
				<h1>Cửa Hàng Điện Thoại Iphone Độc</h1>
			</div>
			<div class="col-3 text-right">
				<img src="../images/LogoPoly.jpg" alt="" class="mr-4">
			</div>
		</header> -->
		<nav class="row">
		 	<nav class="col navbar navbar-expand-sm navbar-light bg-light">
				<!-- <a class="navbar-brand" href="#">ONE</a> -->
				<button class="navbar-toggler d-lg-none" type="button"
					data-toggle="collapse" data-target="#collapsibleNavId"
					aria-controls="collapsibleNavId" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="collapsibleNavId">
					<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
						<li class="nav-item active"><a class="nav-link" href="#">
								<i class="fa fa-home" aria-hidden="true"></i> <span
								class="sr-only">(current)</span>
						</a></li>
						<!-- <li class="nav-item"><a class="nav-link" href="#"> <i
								class="fa fa-id-info" aria-hidden="true"></i> About Us
						</a></li> -->
						<!-- <li class="nav-item"><a class="nav-link" href="#"> <i
								class="fa fa-id-card" aria-hidden="true"></i> Contact Us
						</a></li> -->
						<!-- <li class="nav-item"><a class="nav-link" href="#"> <i
								class="fa fa-comments" aria-hidden="true"></i> My Favorites
						</a></li> -->
						<!-- <li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdownId"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="fa fa-user" aria-hidden="true"></i> My Acount
						</a> -->
							<!-- <div class="dropdown-menu" aria-labelledby="dropdownId">
								<a class="dropdown-item" href="#">Login</a> <a
									class="dropdown-item" href="#">Forgot PassWord</a> <a
									class="dropdown-item" href="#">Registration</a> <a
									class="dropdown-item" href="#">Logoff</a> <a
									class="dropdown-item" href="#">Change PassWord</a> <a
									class="dropdown-item" href="#">Edit Profile</a>
							</div> --></li>
					</ul>
				</div>
			</nav>
		</nav> 

		<section class="row">
			<div class="col-9">
				<div class="row p-2">
					<div class="col-3 mt-2">
						
							<div class="card text-center">
								<c:forEach items="${ listVideo }" var="video">
								<div class="card-body">
									<img src="${video.poster }" width="90%" alt=""
										class="img fluid">
									<div class="row border-top mt-2">
										<p>${video.title}</p>
									</div>
								</div>
								<div class="card-footer">
									<a href="" class="btn btn-success">Like</a>
									<button href="" class="btn btn-info">Share</button>
									<div class="col-6">
										<a href="/PT15304/admin/deleteVideo?id=${video.id}"
											class="btn btn-success">Delete</a>
									</div> 
								</div>
								</c:forEach>
							</div>	
						
					</div>
				</div>
			</div>


		</section>
		<footer class="row">
			<div class="col text-center border-top">
				<strong>FPT Polytechnic &copy;2021. All rights reserved.</strong>
			</div>
		</footer>
	</main>
</body>
</html>