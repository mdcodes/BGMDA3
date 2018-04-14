<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp"></jsp:include>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    <h1>Largest Total Income Group</h1>
    <p>${sessionScope.output}</p>
    <div class="col-md-8">
		<table class="table-responsive">
			<thead>
				<tr>
					<th style="padding-right: 20px;">Name</th>
					<th style="padding-right: 20px;">Code</th>
					<th style="padding-right: 20px;">Level</th>
					<th style="padding-right: 20px;">Alternative Code</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.geoDetails}" var="item">
					<tr>
						<td>${item.name}</td>
						<td>${item.code}</td>
						<td>${item.level}</td>
						<td>${fn:substring(item.alternativeCode, 0, 5)}<td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<table class="table-responsive">
			<thead>
				<tr>
					<th style="padding-right: 20px;">Age Group</th>
					<th style="padding-right: 20px;">Census Year</th>
					<th style="padding-right: 20px;">Combined Population</th>
					<th style="padding-right: 20px;">Male Population</th>
					<th style="padding-right: 20px;">Female Population</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.ageDetails}" var="item">
					<tr>
						<td>${item.ageGroup.description}</td>
						<td>${item.censusYear.censusYear}</td>
						<td>${item.male}</td>
						<td>${item.female}</td>
						<td>${item.combined}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<c:if test="${param.level == 0 || param.level == 1}">
			<table class="table-responsive">
				<thead>
					<tr>
						<th style="padding-right: 20px;">Household Count</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.householdDetails}" var="item">
						<tr>
							<td>${item.numberReported} </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
		<br>
		<c:choose>
			<c:when test="${param.level == 2}">
				<table class="table-responsive">
					<thead>
						<tr>
							<th style="padding-right: 20px;">Name</th>
							<th style="padding-right: 20px;">Code</th>
							<th style="padding-right: 20px;">Level</th>
							<th style="padding-right: 20px;">Alternative Code</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.subLevelCity}" var="item">
							<c:if test="${fn:substring(item.alternativeCode, 0, 5) == param.altCode}">
								<tr>
									<td>${item.name}</td>
									<td>${item.code}</td>
									<td>${item.level}</td>
									<td>${item.alternativeCode}</td>	
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			
			<c:when test="${param.level == 1}">
				<table class="table-responsive">
					<thead>
						<tr>
							<th style="padding-right: 20px;">Name</th>
							<th style="padding-right: 20px;">Code</th>
							<th style="padding-right: 20px;">Level</th>
							<th style="padding-right: 20px;">Alternative Code</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.subLevelProvince}" var="item">
							<c:if test="${fn:substring(item.alternativeCode, 0, 2) == param.altCode}">
								<tr>
									<td>${item.name}</td>
									<td>${item.code}</td>
									<td>${item.level}</td>
									<td>${item.alternativeCode}</td>	
								</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
			
			<c:when test="${param.level == 0}">
				<table class="table-responsive">
					<thead>
						<tr>
							<th style="padding-right: 20px;">Name</th>
							<th style="padding-right: 20px;">Code</th>
							<th style="padding-right: 20px;">Level</th>
							<th style="padding-right: 20px;">Alternative Code</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.subLevelCountry}" var="item">
							<tr>
								<td>${item.name}</td>
								<td>${item.code}</td>
								<td>${item.level}</td>
								<td>${item.alternativeCode}</td>	
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:when>
		</c:choose>
	</div>
</body>
</html>