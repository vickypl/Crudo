<%@ page errorPage="errorpage.jsp" %>
<%@page import="com.crudo.bo.Admin"%>
<jsp:include page="adminheader.jsp"></jsp:include>
<%
	HttpSession httpSession = request.getSession();
	if(httpSession==null || (httpSession!=null && httpSession.getAttribute("admin")==null)) {
		response.sendRedirect("index.jsp?msg=Login Required");
		return;
	}
	
	Admin admin = (Admin)httpSession.getAttribute("admin");

	String msg = null;
	if(request.getAttribute("msg")!=null) {
		msg = (String)request.getAttribute("msg");
	}
%>
<div>
	<span>Last Login: <%=admin.getLastlogin() %></span>
</div>
<div class="maindiv" style="margin: 8% auto;">
<%if(msg!=null) { %>
	<h3 class="h3"><%=msg %></h3>
<%} %>
	<table class="table">
		<h2 class="h2 text-center fa fa-user">&nbsp;User Info</h2>
		<tbody>
			<tr>
				<td>Name:</td>
				<td><%=admin.getFirstname()+" "+admin.getLastname() %></td>
			</tr>
			<tr>
				<td>Username:</td>
				<td><%=admin.getUsername() %></td>
			</tr>
			<tr>
				<td>E-mail:</td>
				<td><%=admin.getEmail() %></td>
			</tr>
		</tbody>
	</table>
</div>
<jsp:include page="adminfooter.jsp"></jsp:include>