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
				<form method="POST" action="/PT15304/themmoi">
					<div class="mt-3">
						<label for="title" class="form-label">Title</label> <input
							type= "text" class="form-control" id="title" name="title" />
					</div>
					<div class="mt-3">
						<label for="poster" class="form-label">Poster</label> <input
							type="url" class="form-control" id="poster" name="poster" />
					</div>
					<div class="mt-3">
						<label for="views" class="form-label">Views</label> <input
							type="text" class="form-control" id="views" name="views" />
					</div>
					<div class="mt-3">
						<label for="description" class="form-label">description</label> <input
							type="text" class="form-control" id="description"
							name="description" />
					</div>
					<div class="mt-3">
						<label for="active" class="form-label">active</label> <select
							class="form-select" name="active">

							<option selected value="1">Hien</option>

							<option value="0">An</option>

						</select>

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