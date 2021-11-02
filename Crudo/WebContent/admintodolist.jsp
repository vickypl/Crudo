<%@ page errorPage="errorpage.jsp" %>
<%@page import="com.crudo.bo.Todo"%>
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
	
	ArrayList<Todo> todoList = null;
	if(request.getAttribute("todoList")!=null) {
		todoList = (ArrayList<Todo>)request.getAttribute("todoList");
	}

%>
<div class="maindiv">
	<center>Todo List</center>
	<table id="mytable" class="table table-striped">
		<thead>
			<tr>
				<th>S.no.</th>
				<th>UserId</th>
				<th>Title</th>
				<th>Details</th>
				<th>AddOn</th>
				<th>Priority</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
		<%if(todoList!=null) {%>
			<%int count=1; for(Todo todo: todoList) {%>
			<tr>
				<td><%=count %></td>
				<td><%=todo.getUserId() %></td>
				<td><%=todo.getTitle() %></td>
				<td><%=todo.getDetails() %></td>
				<td><%=todo.getAddedOn() %></td>
				<td><%=todo.getPriority() %></td>
				<td><%=todo.getStatus() %></td>
			</tr>
			<%count++;} %>
			<%} %>
		</tbody>
	</table>
</div>
<jsp:include page="adminfooter.jsp"></jsp:include>