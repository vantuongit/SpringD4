<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>upload file in spring</h2>

	<form method="post"	enctype="multipart/form-data">
		<p>
		<form:errors cssStyle="color: red" path="userError.name"></form:errors><br/>
			<label>Tên: </label> <input type="text" name="name" />
		</p>
		<p>
		<form:errors cssStyle="color: red" path="userError.address"></form:errors><br/>
			<label>Địa chỉ: </label> <input type="text" name="address" />
		</p>
		<p>
		<form:errors cssStyle="color: red" path="userError.picture"></form:errors><br/>
			<label>Avatar: </label> <input type="file" name="pic" />
		</p>
		<p>
			<input type="submit" name="submit" />
		</p>
	</form>

	<c:if test="${not empty fileName}">
			<c:url value="/resources/uploads/${fileName}" var="image"></c:url>
			<img width="300px" alt="" src="${image}">
	</c:if>
</body>
</html>