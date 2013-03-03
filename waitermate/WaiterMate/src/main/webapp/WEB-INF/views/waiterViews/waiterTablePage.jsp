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
		<jsp:include page="/WEB-INF/partials/header.jsp"></jsp:include>
	</section>
	<section id="divNav">
		<aside id="divNav"><jsp:include page="/WEB-INF/partials/nav.jsp"></jsp:include></aside>
	</section>
	<section id="divContent">
	
	<h2>${currentWaiter.fname} ${currentWaiter.lname}</h2>	
	
	<h3> ADD LINKS TO EXIT THE TABLE AND EXIT THE WAITER</h3>
	
	<c:forEach items="${currentTable.checkList}" var="check">
		<table>
			<c:forEach items="currentTable.checkList.ordersList" var="order">
				<tr>
					<td><a href="/waiterMate/cancelItemOnCheck?checkId=${check.ID}&orderId=${order.ID}">XXX</a></td>
					<td><p>${order.name}</p></td>
					<td><p>${order.price}</p></td>
					<td><p>${order.comment}</p></td>
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
		<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
	</section>

</article>

</body>
</html>