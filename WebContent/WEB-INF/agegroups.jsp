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
		    <c:forEach items="${requestScope.ageGroup }" var="item">
		        <tr>
		        	<td>${item.groupName}</td>
		        	<td>${item.malePopulation}</td>
		        	<td>${item.femalePopulation}</td>
		        	<td>${item.year}</td>
		        </tr>
		    </c:forEach>
	    </tbody>
    </table>
</div>
</body>
</html>