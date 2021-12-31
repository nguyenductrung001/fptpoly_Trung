<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="/views/admin/users/menu.jsp"></jsp:include>
	<div class="col-8 offset-2">

		<div class="mt-5 row">
			<div class="col-6">
				<a href="/PT15304/themmoi" class="btn btn-success">Thêm mới</a>
			</div>
			<div class="col-4"></div>
			<div class="col-2 d-flex justify-content-end">
				<select class="form-select">
					<option value="10" selected>10</option>
					<option value="10">20</option>
					<option value="10">50</option>
					<option value="10">100</option>
				</select>
			</div>
		</div>
		<div class="mt-5 table-responsive">

			<table class="table table-striped">

				<thead>

					<tr>

						<td>Id</td>

						<td>Title</td>
						<td>Poster</td>
						<td>Views</td>
						<td>Description</td>
						<td>Active</td>
						<td colspan="2">Action</td>

					</tr>

				</thead>

				<tbody>
					<c:forEach items="${ listVideo }" var="video">
						<tr>

							<td>${video.id}</td>

							<td>${video.title}</td>
							<td>${video.poster}</td>
							<td>${video.views}</td>
							<td>${video.description}</td>
							<td>${video.active}</td>



							<td><a href="/PT15304/admin/users/update-video?id=${video.id}"
								class="btn btn-primary">Update</a></td>

							<td><a href="/PT15304/admin/deleteVideo?id=${video.id}"
								class="btn btn-danger">Delete</a></td>

						</tr>

					</c:forEach>


				</tbody>

			</table>

			<ul class="pagination">
				<li class="page-item"><a
					href="/PT15304/admin/danhsach?page=${ page - 1 }" class="page-link">Previous</a>
				</li>
				<li class="page-item"><a class="page-link">1</a></li>
				<li class="page-item"><a
					href="/PT15304/admin/danhsach?page=${ page + 1 }" class="page-link">Next</a>
				</li>
			</ul>


		</div>

	</div>
</body>
</html>