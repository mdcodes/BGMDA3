<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <table class="table table-striped">
		<thead>
			<tr>
				<th style="padding: 5px;">Description</th>
				<th style="padding: 5px;">Male Population</th>
				<th style="padding: 5px;">Female Population</th>
				<th style="padding: 5px;">Combined</th>
				<th style="padding: 5px;">Year</th>
			</tr>
		</thead>
	    <tbody>
		    <c:forEach items="${requestScope.ageList}" var="item">
			    <c:if test="${item.censusYear.censusYear == 2011}">
		        	<tr>
		        		<td>${item.ageGroup.description}</td>
			    		<td>${item.male}</td>
			    		<td>${item.female}</td>
			    		<td>${item.combined}</td>	
			    		<td>${item.censusYear.censusYear}</td>
				    </tr>
    	    	</c:if>
    		</c:forEach>
    		<c:forEach items="${requestScope.ageList}" var="item">
    		<c:if test="${item.censusYear.censusYear == 2016 }">
    	    		<tr>
		        		<td>${item.ageGroup.description}</td>
			    		<td>${item.male}</td>
			    		<td>${item.female}</td>
			    		<td>${item.combined}</td>	
			    		<td>${item.censusYear.censusYear}</td>
				    </tr>
    	    	</c:if>
    	    </c:forEach>
	    </tbody>
    </table>
</body>
</html>