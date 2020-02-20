<%@ include file="head.jsp" %>
<c:if test="${not empty USER_SESSION}">
<body>

<div class="container">
	<%@ include file="header.jsp"%>
	<%@ include file="filter.jsp"%>
	<%@ include file="data.jsp"%>
	<%@ include file="footer.jsp"%>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
</body>
</c:if>
</html>