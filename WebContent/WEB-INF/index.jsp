<jsp:include page="header.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form action="./GeographicArea" method="get">
    <input type="radio" name="level" id="level-country" value="0"/>
    <label for="level-country" class="first">0 - The Country of Canada</label><br>

    <input type="radio" name="level" id="level-province" value="1">
    <label for="level-province">1 - Provinces and Territories</label><br>

    <input type="radio" name="level" id="level-CMA" value="2">
    <label for="level-CMA">2 - Census Metropolitan Areas and Census Agglomerations</label><br>

    <input type="radio" name="level" id="level-splitCMACM" value="3">
    <label for="level-splitCMACM" class="last">3 - One CMA and three CAs are divided between adjacent provinces</label><br>
    <input type="submit" value="Submit" class="segmented-button"/>
</form>
	<div align="center" class="col-md-4">
		<table class="table-responsive">
			<thead>
				<tr>
					<th>
						Geographic Name
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.gabList}" var="area">
				<tr>
					<td><a href="./AreaDetail?name=${area.name}">${area.name}</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>