<%@ page errorPage="errorpage.jsp" %>
<%@page import="com.crudo.bo.Todo"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="userheader.jsp"></jsp:include>
<%! @SuppressWarnings("unchecked") %>
<%
	//session
	HttpSession httpSession = request.getSession();
	if(httpSession==null || (httpSession!=null && httpSession.getAttribute("user")==null)) {
		response.sendRedirect("index.jsp?msg=Login Required");
		return;
	}
	
	ArrayList<Todo> todoList = null;
	if(httpSession.getAttribute("todoList")!=null) {
		todoList = (ArrayList<Todo>)httpSession.getAttribute("todoList");
	}

	String msg = null;
	if(request.getParameter("msg")!=null) {
		msg = request.getParameter("msg");
	}
	
%>
      <!--add todo Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel"><h4 class="h4">Add New Todo</h4></h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form method="post" action="addusertodo">
              <div class="form-group">
                <label for="exampleInputEmail1">Title</label>
                <input type="text" name="title" maxlength="20" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Title">
              </div>
              <div class="form-group">
                  <label for="exampleInputEmail1">Details</label>
                  <textarea type="text" name="details" maxlength="200" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Details"></textarea>
              </div>
              <div class="form-group">
                  <label for="exampleInputEmail1">Priority</label>
                  <select class="form-control" name="priority" id="">
                      <option value="high">High</option>
                      <option value="mid">Medium</option>
                      <option value="low">Low</option>
                  </select>
              </div>
              <div class="form-group">
                <label for="exampleInputEmail1">Status</label>
                <select class="form-control" name="status" id="">
                    <option value="pending">Pending</option>
                    <option value="done">Done</option>
                    <option value="progress">Progress</option>
                </select>
            </div>
              <button type="submit" class="btn btn-success btn-block">Add Todo</button>
            </form>
        </div>
        <div class="modal-footer">
        </div>
      </div>
    </div>
  </div>
    <!--update todo Modal -->
    <div class="modal fade" id="updatemodal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">
                        <h4 class="h4">Update Todo</h4>
                    </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body" id="updatetodoformbox">

                </div>
                <div class="modal-footer">
                </div>
            </div>
        </div>
    </div>
<div class="maindiv">
<% if(msg!=null) {%>
	<center><span style="color: red; font-weight: bold;"><%=msg %></span></center>
<%} %>
	<button class="btn btn-outline-primary addtodobtn" data-toggle="modal"
		data-target="#exampleModal" data-whatever="@mdo">Add New Todo</button>
	<table id="mytable" class="table table-striped">
		<thead>
			<tr>
				<th>S.no.</th>
				<th>Title</th>
				<th>Details</th>
				<th>AddOn</th>
				<th>Priority</th>
				<th>Status</th>
				<th>options</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<%if(todoList!=null) {%>
		<%int count=1; for(Todo todo: todoList) {%>
			<tr>
				<td><%=count %></td>
				<td><%=todo.getTitle() %></td>
				<td><%=todo.getDetails() %></td>
				<td><%=todo.getAddedOn() %></td>
				<td><%=todo.getPriority() %></td>
				<td><%=todo.getStatus() %></td>
				<td><button class="btn btn-primary btn-block"
						data-toggle="modal" data-target="#updatemodal"
						data-whatever="@mdo" onclick="getUserTodoToUpdate(<%=todo.getId() %>)" >Edit</button></td>
				<td><a href="deletetodo?id=<%=todo.getId()%>"><button class="btn btn-danger btn-block">Delete</button></a></td>
			</tr>
			<%count++; } %>
			<%} %>
		</tbody>
	</table>
</div>
<jsp:include page="userfooter.jsp"></jsp:include>