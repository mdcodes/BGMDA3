<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<div class="col-md-8">
    <table class="table-responsive">
		<thead>
			<tr>
				Geographic Name
			</tr>
		</thead>
	    <tbody>
				<c:forEach items="${areas}" var="areas">
				<tr>
					<td><a href="./AreaDetail?name=${areas.name}">${areas.name}</a></td>
				</tr>
				</c:forEach>
	    </tbody>
    </table>
</div>
</body>
</html>