<c:if test="${not empty ERROR_ATTR_UNAUTH}">
	<div class="alert alert-danger" role="alert">
		<c:out value="${ERROR_ATTR_UNAUTH}"></c:out>
	</div>
</c:if>
