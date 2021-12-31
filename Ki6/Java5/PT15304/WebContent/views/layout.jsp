<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PT15304UD</title>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">PT15304-UD</a>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Home</a>
	        </li>
	      </ul>
	    </div>
	  </div>
	</nav>
	
	<div class="col-12 row">
		<div class="col-2 bg-warning">
			Sidebar
		</div>
		
		<!-- Contents -->
		<div class="col-10">
			<jsp:include page="${ views }" />
		</div>
		<!-- Contents -->
	</div>

	<div class="col-12 bg-danger">
		Footer
	</div>
</body>
</html>