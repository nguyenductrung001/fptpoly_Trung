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
		<nav class="row">
		 	<nav class="col navbar navbar-expand-sm navbar-light bg-light">
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
					</ul>
				</div>
			</nav>
		</nav> 

		<section class="row">
			<div class="col-9">
				<div class="row p-2">
					<div class="col-3 mt-2">
						<c:forEach items="${ listVideo }" var="video">
							<div class="card text-center">
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
								</div>
							</div>
						</c:forEach>
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