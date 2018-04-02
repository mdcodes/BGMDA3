<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<div class="col-md-8">
    <table class="table-responsive">
		<thead>
			<tr>
				<th style="padding: 5px;">Description</th>
				<th style="padding: 5px;">Male Population</th>
				<th style="padding: 5px;">Female Population</th>
				<th style="padding: 5px;">Year</th>
			</tr>
		</thead>
	    <tbody>
			    <c:forEach items="${requestScope.ageGroup}" var="item">
			    	<tr>
			        	<td>${item.description}</td>
			        	<c:forEach items="${requestScope.ageList}" var="item">
				    		<td>${item.male}</td>
				    		<td>${item.female}</td>
				    		<td>${item.combined}</td>		
				    	</c:forEach>
				    	<c:forEach items="${requestScope.cenYear}" var="yearItem">
				    			<td>${yearItem.censusYear}</td>
				    	</c:forEach>
				    </tr>
	    		</c:forEach>
	    </tbody>
    </table>
</div>
</body>
</html>