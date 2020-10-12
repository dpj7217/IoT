<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
<div class="register">
	<h2>Register</h2>
	<form:form method= "POST" modelAttribute="user" action="registerSuccess">
		<table> 
			<tr>
				<td><form:label path="username">Username:</form:label></td>
				<td><form:input placeholder="Enter Username" path="username"/><form:errors path="username"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Password:</form:label></td>
				<td><form:password placeholder="Enter Password" path="password"/><form:errors path="password"/></td>
			</tr>
			<tr>
				<td colspan="2"> 
					<input type = "submit" value = "Submit"/>
				</td>
			</table>
				<td>
				<p>Already have an account? Sign in <a href="login">here</a></p>
				</td>
		<font color= "red"><form:errors path="*"/></font>
	</form:form>
</div>
</body>
</html>