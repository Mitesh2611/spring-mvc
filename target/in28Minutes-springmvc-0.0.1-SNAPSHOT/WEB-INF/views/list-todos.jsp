    <%@ include file="common/header.jspf"%>
    <%@ include file="common/navigation.jspf"%>
	<div class="container">
    		<table class="table table-striped">
    			<caption>Your Todos are</caption>

    			<thead>
    				<tr>
    					<th>Description</th>
    					<th>Date</th>
    					<th>Completed</th>
    				</tr>
    			</thead>

    			<tbody>
    				<c:forEach items="${todos}" var="todo">
    					<tr>
    						<td>${todo.description}</td>
    						<td>
    						    <fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}"/>
    						</td>
    						<td>${todo.done}</td>
    						<td>
    						    <a href="/update-todo?id=${todo.id}"class="btn btn-success">Update</a>
    						    <a href="/delete-todo?id=${todo.id}"class="btn btn-danger">Delete</a>
    						</td>
    					</tr>
    				</c:forEach>
    			</tbody>
    		</table>
    		<div>
    			<a href="/add-todo" class="btn btn-primary">Add</a>
            </div>
    	</div>
	</div>
	<%@ include file="common/footer.jspf"%>