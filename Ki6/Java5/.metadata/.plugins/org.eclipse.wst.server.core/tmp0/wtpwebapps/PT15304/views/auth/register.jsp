<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">PT15304-UD</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<ul class="navbar-nav me-auto mb-2 mb-lg-0">

					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="row">
	
		<div class="col-12">
			<div class="col-6 offset-3">
				<form method="POST" action="/PT15304/register">
					<div class="mt-3">
						<label for="name" class="form-label">Name</label> <input
							type= "text" class="form-control" id="name" name="name" />
					</div>
					<div class="mt-3">
						<label for="number" class="form-label">Number</label> <input
							type="number" class="form-control" id="number" name="number" />
					</div>
					<div class="mt-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email" />
					</div>
					<div class="mt-3">
						<label for="password" class="form-label">Password</label> <input
							type="password" class="form-control" id="password"
							name="password" />
					</div>
					<div class="mt-3">
						<label for="gender" class="form-label">Gender</label> <select
							class="form-select" name="gender">

							<option selected value="1">Male</option>

							<option value="0">Female</option>

						</select>

					</div>
					<div class="mt-3">
						<label for="role" class="form-label">Role</label> <select
							class="form-select" name="role">

							<option selected value="1">Admin</option>

							<option value="0">NhanVien</option>

						</select>

					</div>

					<div class="form-check mt-3">

						<input class="form-check-input" type="checkbox" value=""
							id="flexCheckChecked" checked> <label
							class="form-check-label" for="flexCheckChecked"> Receive
							email? </label>

					</div>

					<div class="mt-3">

						<button type="submit" class="btn btn-primary mb-3">

							Submit</button>

					</div>

				</form>

			</div>

		</div>

	</div>
</body>
</html>