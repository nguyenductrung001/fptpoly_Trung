<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<%-- <link rel="stylesheet"
	href="<%=request.getContextPath()%>/views/admin/users/menu.css"> --%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script> 
</head>
<body>


	<%-- <header>
		<img alt="/"
			src="https://i1.wp.com/lapmangfptsieutoc.net/wp-content/uploads/2016/12/Banner-fpt.png?fit=964%2C358&ssl=1">
	</header>
	<nav>
		<ul>
			<li><a href='/PT15304/admin/users	'>Trang chủ</a></li>

			<li><a href='/'>Tư vấn</a></li>
			<li class='sub-menu'><a href="/products" class='sub-menu'>Quản
					lý</a>
			<li><a href='<%=request.getContextPath()%>/PT15304/login'>Login</a></li>
			<ul class='sub-menu'>
				<li><a href="/products">Product</a></li>
				<li><a href="/categories">Categories</a></li>
				<li><a href="/oder">Oder</a></li>
			</ul>
			</li>

		</ul>
	</nav> --%>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Xin chào Trung!
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/PT15304/admin/danhsach">QuanLySanPham</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> My Account </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a  href="<%=request.getContextPath()%>/login">Login</a> 
						<a
							class="dropdown-item" href="/PT15304/logout">Logout</a>
						<div class="dropdown-divider"></div> 
						<!-- <a class="dropdown-item" href="#">Registration/a> -->
					</div></li>
				<li class="nav-item"><a class="nav-link" href="/PT15304/admin/users">QuanLyUser</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/PT15304/User">My Favorites</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav> 






</body>
</html>