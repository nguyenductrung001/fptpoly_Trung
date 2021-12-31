<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous"> --%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js" integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js" integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
 rel="stylesheet" 
 integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
  crossorigin="anonymous">
 <style>
 .items{
  max-width: 1000px;
  margin: auto;
  margin-top: 20px;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  grid-gap: 20px;
}

 .items .item-title{
  font-size: 20px;
  line-height: 20px;
  margin: 10px 0;
}

 .items .item{
  border: 1px solid #ddd;
  box-shadow: 1px 1px 4px #ddd;
  padding: 10px;
  border-radius: 10px;
}
 
 </style>
</head>
<body>
<jsp:include page="/views/admin/users/menuUser.jsp"></jsp:include>
		<%-- <nav class="row">
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
								</div>
								</c:forEach>
							</div>
						
					</div>
				</div>
			</div>


		</section> --%>
		<div class="items">
		<c:forEach items="${listVideo}" var="video">
		
                    <div class="item">
                        <div class="item-thumb">
                            <img src="${video.poster }" width="200px" height="300px" alt=""
										class="img fluid">
                        </div>
                        
                        <h2 class="item-title">${video.title } </h2>
                    <a href="/pt15304-ud/user/delete?id=${ video.id }" class="btn btn-primary">UnLike</a>
    				<a href="#" class="btn btn-primary">Share</a>
                    </div>
                    </c:forEach>
                </div>
		<footer class="row">
			<div class="col text-center border-top">
				<strong>FPT Polytechnic &copy;2021. All rights reserved.</strong>
			</div>
		</footer>
	</main>
</body>
</html>