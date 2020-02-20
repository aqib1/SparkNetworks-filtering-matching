<%@ include file="head.jsp" %>
<body>
<div class="container">
<%@ include file="header.jsp"%>
	<form:form action="/login" method="post" modelAttribute="loginModel">
		<table class="table">
			<tbody>
				<tr>
					<td><label>Name</label></td>
					<td><form:input path="name" class="form-control"
						 /></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><form:input path="password" class="form-control" />
						</td>
				</tr>
				<tr>
					<td><button class="btn btn-primary" type="submit">Search</button></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</div>
<%@ include file="footer.jsp"%>
</body>