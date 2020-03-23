<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee Report</h1>
	<table width="50%">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Salary</th>
			</tr>
		</thead>
		
		<tbody align="center">
		<c:forEach items="${List}" var="emp">
		<tr>
			<td><c:out value="${emp.id}"/></td>
			<td><c:out value="${emp.name}"/></td>
			<td><c:out value="${emp.salary}"/></td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>