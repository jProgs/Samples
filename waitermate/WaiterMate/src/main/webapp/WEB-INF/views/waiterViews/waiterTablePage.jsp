<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Waiter Table Page</title>
	<link rel="stylesheet" type="text/css" href="/finalLab/src/main/webapp/resources/styles/style.css" media="screen" />
</head>
<body>
<article id="divPage">
	<section id="divHeader">
		<jsp:include page="/partials/header.jsp"></jsp:include>
	</section>
	<section id="divNav">
		<aside id="divNav"><jsp:include page="/partials/nav.jsp"></jsp:include></aside>
	</section>
	<section id="divContent">
	
	
	<h2> ADD LINKS TO EXIT THE TABLE AND EXIT THE WAITER</h2>
	
	<c:forEach items="${tableCheckList}" var="check">
		<table>
			<c:forEach items="tableCheckList.menuItems" var="menuItem">
				<tr>
					<td><a href="/waiterMate/cancelItemOnCheck?checkId=${check.checkId}&menuItemId=${menuItem.menuItemId}">XXX</a></td>
					<td><p>${menuItem.name}</p></td>
					<td><p>${menuItem.price}</p></td>
					<td><p>	${menuItem.comment}</p></td>
			</c:forEach>
		</table>
		<table>
		<tr><td>PAY CHECK</td><td>ADD TIP</td><td>CLOSE CHECK</td></tr>
		</table>
	</c:forEach>
	
	<!--  <tr><td><a href="/waiterMate/SelectTableOfWaiter?tableId=${table.id}">Table # ${table.id}</a></td></tr> -->		
	
	<p id="waiterTablesServing" class="instructions"></p>
	<br />
	
	<!--  CREATE A COLUMN OF ALL OF THE TABLES WHICH THE SERVER HAS -->
	
	<table>
		<c:forEach items="${waiterTableList}" var="table">
		<tr><td><a href="/waiterMate/SelectTableOfWaiter?tableId=${table.id}">Table # ${table.id}</a></td></tr>		
	</c:forEach>
	
	</table>
	
	
	</section>
	<section id="divFooter">
		<jsp:include page="/partials/footer.jsp"></jsp:include>
	</section>

</article>

</body>
</html>