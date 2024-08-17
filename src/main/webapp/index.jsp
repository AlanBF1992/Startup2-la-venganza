<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
	<jsp:include page="./assets/html/head.jsp"></jsp:include>
	<link rel="stylesheet" type="text/css" href="./assets/css/styles.css"/>
</head>
<body class="d-flex align-items-center justify-content-center">

<main>
	<section class="mb-5">
		<h1 class="text-white">Welcome</h1>
		<p>To this Startup</p>
	</section>
	
	<section>
		<h1>"Navegación"</h1>
		<div class="d-flex justify-content-evenly">
			<a class="btn btn-primary" href="register">Registro</a>
			<a class="btn btn-primary" href="login">Login</a>
		</div>
	</section>
</main>
<script
 src="https://code.jquery.com/jquery-3.7.1.min.js"
 integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
 crossorigin="anonymous"></script>
<script src="//cdn.datatables.net/2.1.2/js/dataTables.min.js"></script>
<script>
$(document).ready(() => {
	$('#tblProveedor').DataTable();
})
</script>
</body>
</html>