<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp"></jsp:include>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="col-md-8">
	<table class="table-responsive">
		<thead>
			<tr>
				<th style="padding: 5px;">Name</th>
				<th style="padding: 5px;">Code</th>
				<th style="padding: 5px;">Level</th>
				<th style="padding: 5px;">Total Population</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.areaDetails}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.code}</td>
					<td>${item.level}</td>
					<td>${item.totalPopulation}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
</body>
</html>