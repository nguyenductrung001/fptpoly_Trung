
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="login.css">
</head>
<body>
	<h1>Login</h1>
	<form action="<%=request.getContextPath()%>/login"  
		method="post">

		<div class="container">
			<div class="d-flex justify-content-center h-100">
				<div class="card">
					<div class="card-header">
						<h3>Sign In</h3>
						<div class="d-flex justify-content-end social_icon">
							<span><i class="fab fa-facebook-square"></i></span> <span><i
								class="fab fa-google-plus-square"></i></span> <span><i
								class="fab fa-twitter-square"></i></span>
						</div>
					</div>
					<div class="card-body">
						<form>
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-user"></i></span>
								</div>
								<input type="text" class="form-control" placeholder="username" name ="txtUser" value="">

							</div>
							<div class="input-group form-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-key"></i></span>
								</div>
								<input type="password" class="form-control"
									placeholder="password" name="txtPass" value="">
							</div>
							<div class="row align-items-center remember">
								<input type="checkbox">Remember Me
							</div>
							<div class="form-group">
								<input type="submit" name="login"
									class="btn float-right login_btn" value="Login">
							</div>
						</form>
					</div>
					<div class="card-footer">
						<div class="d-flex justify-content-center links">
							Don't have an account?<a href="#">Sign Up</a>
						</div>
						<div class="d-flex justify-content-center">
							<a href="#">Forgot your password?</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	 	<p>${lg}</p>
</body>
</html>