<%@ page errorPage="errorpage.jsp" %>
<%@page import="com.crudo.bo.User"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="adminheader.jsp"></jsp:include>
<%! @SuppressWarnings("unchecked") %>
<%
	//session
	HttpSession httpSession = request.getSession();
	if(httpSession==null || (httpSession!=null && httpSession.getAttribute("admin")==null)) {
		response.sendRedirect("index.jsp?msg=Login Required");
		return;
	}
	
	ArrayList<User> userList = null;
	if(httpSession.getAttribute("userList")!=null) {
		userList = (ArrayList<User>)httpSession.getAttribute("userList");
	}

	String msg=null;
	if(request.getParameter("msg")!=null) {
		msg=request.getParameter("msg");
	}
%>
<div class="maindiv">
<%if(msg!=null){ %>
	<h3 class="h3"><%=msg %></h3>
<%} %>
	<center>Users List</center>
	<table id="mytable" class="table table-striped">
		<thead>
			<tr>
				<th>S.no.</th>
				<th>UserID</th>
				<th>Full Name</th>
				<th>Username</th>
				<th>E-mail</th>
				<th>LastLogin</th>
				<th>Reg.date</th>
				<th>Options</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<%if(userList!=null) {%>
		<%int count=1;	for(User user: userList) {%>
			<tr>
				<td><%=count %></td>
				<td><%=user.getId() %></td>
				<td><%=user.getFirstname()+" "+user.getLastname() %></td>
				<td><%=user.getUsername() %></td>
				<td><%=user.getEmail() %></td>
				<td><%=user.getLastlogin() %></td>
				<td><%=user.getSignup() %></td>
				<td><a href="blockuser?id=<%=user.getId()%>&value=<%=user.getBlocking()%>"><button class="btn btn-secondary btn-block"><%=user.getBlocking() %></button></a></td>
				<td><a href="deleteuser?id=<%=user.getId() %>"><button class="btn btn-danger btn-block">Delete</button></a></td>
			</tr>
			<%count++; } %>
			<%} %>
		</tbody>
	</table>
</div>
<jsp:include page="adminfooter.jsp"></jsp:include>