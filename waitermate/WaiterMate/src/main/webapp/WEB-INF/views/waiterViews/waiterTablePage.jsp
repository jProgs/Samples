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
	
	<!-- CLICK THESE TO EXIT THE TABLE OR WAITER -->
	<table>
	<tr>
	<td><a>Exit Table</a></td>
	<td><a>Exit Waiter</a></td>
	</tr>
	</table>
	
	<c:forEach items="${currentTable.checkList}" var="check">		
		<table>
			<c:forEach items="${check.ordersList}" var="order">
			
				<tr>		
					<td><a href="/waiterMate/cancelItemOnCheck?checkId=${check.ID}&orderId=${order.ID}">XXX</a></td>					
					<td>${order.name}</td>
					<td>${order.price}</td>
					<td>${order.comment}</td>
				</tr>
			</c:forEach>
		</table>
		<table>
		<tr>
		<td>SubTotal: ${check.subtotal} </td>
		<td>Tax: ${check.tax} </td>
		<td>Tip: ${check.tip} </td>
		<td>Total: ${check.subtotal + check.tax + check.tip} </td>
		</tr>
		</table>
		<table>
		<tr><td><a>PAY CHECK</a></td><td><a>ADD TIP</a></td><td><a>CLOSE CHECK</a></td></tr>
		</table>
		<br />
		<br />
	</c:forEach>
	
	<!--  <tr><td><a href="/waiterMate/SelectTableOfWaiter?tableId=${table.id}">Table # ${table.id}</a></td></tr> -->		
	<!-- <td><a href="/waiterMate/cancelItemOnCheck?checkId=${check.Id}&orderId=${order.ID}">XXX</a></td> -->
	<p id="waiterTablesServing" class="instructions"></p>
	<br />
	
	<!--  CREATE A COLUMN OF ALL OF THE TABLES WHICH THE SERVER HAS -->
	
	<table>
		<c:forEach items="${waiterTableList}" var="table">
		<tr><td><a href="/waiterMate/SelectTableOfWaiter?tableId=${table.ID}">Table # ${table.ID}</a></td></tr>		
	</c:forEach>
	
	</table>
	
	
	</section>
	<section id="divFooter">
		<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
	</section>

</article>

</body>
</html>