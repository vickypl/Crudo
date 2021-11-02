<%@ page errorPage="errorpage.jsp" %>
<jsp:include page="homeheader.jsp"></jsp:include>
<%
	String msg = null;
	if (request.getParameter("msg") != null) {
		msg = request.getParameter("msg");
	}

	String smsg = null;
	if (request.getAttribute("smsg") != null) {
		smsg = (String) request.getAttribute("smsg");
	}
%>
<div id="otpmodal" class="modal fade" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<div class="modal-title" id="otpbox">
					<h4 class="h4">Enter OTP</h4>
				</div>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>
			<div class="modal-body">
				<form method="post" action="sendotp">
					<input type="text" class="form-control" name="otp"
						placeholder="Enter OTP" /> <br>
					<button type="submit" class="btn btn-success btn-block">Confirm
						OTP</button>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
			</div>
		</div>
	</div>
</div>
<div style="margin: 2% auto; padding: 10px; width: 90%;">
	<%
		if (msg != null) {
	%>
	<div
		style="text-align: center; color: red; font-weight: bold; font-family: cursive;">
		<%=msg%>
	</div>
	<%
		}
	%>
	<%
		if (smsg == null) {
	%>
	<div class="row">
		<input type="email" class="form-control" id="otpemail"
			placeholder="Enter email"> <small>Enter Registered
			E-mail</small>
	</div>
	<div class="row">
		<button onclick="sendOtp()" class="btn btn-info btn-block"
			data-toggle="modal" data-target="#otpmodal">Send OTP</button>
	</div>
	<%
		} else {
	%>
	<form action="changenewpassword" method="post">
		<div class="form-group">
			<label for="uname">Enter New Password:</label> <input type="password"
				class="form-control" placeholder="Enter New Password"
				name="pwd" required>
		</div>
		<div class="form-group">
			<label for="pwd">Confirm New Password:</label> <input type="password"
				class="form-control"  placeholder="Confirm New Password"
				name="npwd" required>
		</div>
		<button type="submit" class="btn btn-primary btn-block">Change Password</button>
	</form>
	<%
		}
	%>
</div>
<jsp:include page="homefooter.jsp"></jsp:include>