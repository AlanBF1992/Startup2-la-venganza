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

<main class="justify-items-center">
	<section class="mb-5">
		<h1 class="text-white">Welcome <c:out value="${username}"></c:out></h1>
		<p>Tu correo es <c:out value="${usermail}"></c:out></p>
		<a class="btn btn-primary" href="login?logoff=1">Logoff</a>
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