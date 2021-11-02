<%@ page errorPage="errorpage.jsp" %>
<%@page import="com.crudo.bo.User"%>
<jsp:include page="userheader.jsp"></jsp:include>
<%
	HttpSession httpSession = request.getSession();
	if(httpSession==null || (httpSession!=null && httpSession.getAttribute("user")==null)) {
		response.sendRedirect("index.jsp?msg=Login Required");
		return;
	}
	
	User user = (User)httpSession.getAttribute("user");

	String msg = null;
	if(request.getAttribute("msg")!=null) {
		msg = (String)request.getAttribute("msg");
	}
	
	if(request.getParameter("msg")!=null) {
		msg = request.getParameter("msg");
	}
	
%>
<div>
	<span>Last Login: <%=user.getLastlogin() %></span>
</div>
<div class="maindiv" id="maindiv" style="margin: 5% auto;">
<%if(msg!=null) { %>
	<h3 class="h3"><%=msg %></h3>
<%} %>
	<table class="table">
		<h2 class="h2 text-center fa fa-user">&nbsp;User Info</h2>
		<tbody>
			<tr>
				<td>Name:</td>
				<td><%=user.getFirstname()+" "+user.getLastname() %></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><%=user.getUsername() %></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><%=user.getEmail() %></td>
			</tr>
		</tbody>
	</table>
	<div style="margin-top: 90px; margin-bottom: 90px;">
		<button onclick="deleteMyAccount()" class="btn btn-danger btn-block">Delete My Account</button>
	</div>
</div>
<jsp:include page="userfooter.jsp"></jsp:include>