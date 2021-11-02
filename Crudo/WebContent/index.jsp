<%@ page errorPage="errorpage.jsp"%>
<jsp:include page="homeheader.jsp"></jsp:include>
<%
	//session
	HttpSession httpSession = request.getSession();
	if (httpSession != null && httpSession.getAttribute("user") != null) {
		response.sendRedirect("userloggedin.jsp");
		return;
	}

	if (httpSession != null
			&& httpSession.getAttribute("admin") != null) {
		response.sendRedirect("adminloggedin.jsp");
		return;
	}

	String msg = null;
	if (request.getAttribute("msg") != null) {
		msg = (String) request.getAttribute("msg");
	}

	if (request.getParameter("msg") != null) {
		msg = request.getParameter("msg");
	}
%>
<%
	if (msg != null) {
%>
<center>
	<h3 class="h3"><%=msg%></h3>
</center>
<%
	}
%>
<div class="row">
	<div class="col-md-6">
		<div class="mycontainerleft">
			<div class="animtextbox" id="animtext"></div>
			<div>
				<button class="btn btn-outline-info" data-toggle="modal"
					data-target="#adminlogin">Admin Login</button>
			</div>
		</div>
	</div>
	<div class="col-md-6">
		<div class="mycontaineright">
			<h2 class="h3">Login With</h2>
			<!--goolgle auth  -->
			<div class="g-signin2" data-onsuccess="onSignIn" id="myP"></div>
			<img id="myImg"><br>
			<button class="btn btn-outline-info" onclick="myFunction()">SignOut Google</button>
			<p id="name"></p>
			<div id="status"></div>
			<script>
			function myFunction() {
					gapi.auth2.getAuthInstance().disconnect();
					location.reload();
			 }
			</script>
			<!--goolgle auth  -->
		</div>
	</div>
</div>
<jsp:include page="homefooter.jsp"></jsp:include>