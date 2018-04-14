<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-8">
    <table class="table-responsive">
		<thead>
			<tr>
				Geographic Name
			</tr>
		</thead>
	    <tbody>	
			<c:forEach items="${areas}" var="areas">
				<c:if test="${areas.level==0}">
					<tr>
						<td><a href="./AreaDetail?areaId=${areas.geographicAreaID}&level=${areas.level}&altCode=${areas.alternativeCode}">${areas.name}</a></td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<table class="table-responsive">
		<thead>
			<tr>
				Geographic Name
			</tr>
		</thead>
	    <tbody>	
			<c:forEach items="${areas}" var="areas">
				<c:if test="${areas.level==1}">
					<tr>
						<td><a href="./AreaDetail?areaId=${areas.geographicAreaID}&level=${areas.level}&altCode=${areas.alternativeCode}">${areas.name}</a></td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<table class="table-responsive">
		<thead>
			<tr>
				Geographic Name
			</tr>
		</thead>
	    <tbody>	
			<c:forEach items="${areas}" var="areas">
				<c:if test="${areas.level==2}">
					<tr>
						<td><a href="./AreaDetail?areaId=${areas.geographicAreaID}&level=${areas.level}&altCode=${areas.alternativeCode}">${areas.name}</a></td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<br>
	<table class="table-responsive">
		<thead>
			<tr>
				Geographic Name
			</tr>
		</thead>
	    <tbody>	
			<c:forEach items="${areas}" var="areas">
				<c:if test="${areas.level==3}">
					<tr>
						<td><a href="./AreaDetail?areaId=${areas.geographicAreaID}&level=${areas.level}&altCode=${areas.alternativeCode}">${areas.name}</a></td>
					</tr>
				</c:if>
			</c:forEach>
		</tbody>
    </table>
</div>
</body>
</html>