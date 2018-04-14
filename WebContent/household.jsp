<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<p>${sessionScope.output}</p>
	<table class="table table-striped">
		<tr>
			<th>Geographic Area Name</th>
			<th> Median Total Income</th>
		</tr>
		<c:forEach items="${houseData}" var="items">
			<tr>
				<td>${items.geographicArea.name}</td>
				<c:if test="${items.totalIncome.id ==  22}">
				<td>${items.numberReported}</td>
				</c:if>
			</tr>
		</c:forEach>
	</table>
</body>
</html>