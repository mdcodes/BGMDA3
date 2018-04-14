<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
		<style>
			.container{
				max-width: 50%;
				margin:auto;
			}
		</style>
		<title>Login</title>
	</head>
<body>
	<div class="container align-middle">
		<form action="./LoginServlet" method="post">
			<input class="center" type="text" name="username" placeholder="Username"/><br>
			<input type="password" name="password" placeholder="Password"/><br>
			<button type="submit" value="Login">Login</button>
		</form>
	</div>
</body>
</html>