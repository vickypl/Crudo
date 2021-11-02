<%@page import="com.crudo.bo.User"%>
<%
	//session
	HttpSession httpSession = request.getSession();
	if (httpSession == null
			|| (httpSession != null && httpSession.getAttribute("user") == null)) {
		response.sendRedirect("index.jsp?msg=Login Required");
		return;
	}
	User user = (User) httpSession.getAttribute("user");
%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<link rel="shortcut icon" href="images/ico.png" type="image/x-icon">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript"
	src="datatable/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="datatable/js/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="datatable/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="datatable/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="datatable/css/responsive.dataTables.min.css">
<link rel="stylesheet" href="css/style.css">
<title>Crudo</title>
</head>
<body class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar-light bg-gradient">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03"
				aria-controls="navbarTogglerDemo03" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Crudo</a>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="userloggedin.jsp">Home</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="getusertodo">TodoList</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page"
						data-toggle="modal" data-target="#userinfoupdate"
						data-whatever="@mdo" href="">Update Info</a></li>
					<li class="nav-item"><a class="nav-link" aria-current="page" href="userlogout">Logout</a></li>
					<li class="nav-item"><a class="nav-link" href="aboutus.jsp">AboutUs</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!--update Modal -->
	<div class="modal fade" id="userinfoupdate" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						<h4 class="h4">Update User Profile</h4>
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form method="POST" action="userinfoupdate">
						<div class="form-group">
							<label for="exampleInputEmail1">First Name</label> <input
								type="text" name="fname" value="<%=user.getFirstname()%>"
								maxlength="20" required class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="First Name">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Last Name</label> <input
								type="text" name="lname" value="<%=user.getLastname()%>"
								maxlength="20" required class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="Last Name">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">E-mail</label> <input
								type="email" name="email" value="<%=user.getEmail()%>"
								maxlength="45" required class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="E-mail">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Username</label> <input
								type="text" name="username" value="<%=user.getUsername()%>"
								readonly="readonly" required class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="Username">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Password</label> <input
								type="password" name="password" value="<%=user.getPassword()%>"
								maxlength="20" required class="form-control"
								id="exampleInputEmail1" aria-describedby="emailHelp"
								placeholder="Password">
						</div>
						<div class="form-group form-check">
							<input type="checkbox" class="form-check-input" required
								id="exampleCheck1"> <label class="form-check-label"
								for="exampleCheck1">I accept the terms and Conditions.</label>
						</div>
						<button type="submit" class="btn btn-primary btn-block">Update</button>
					</form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>