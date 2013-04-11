<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Waiter Table Page</title>
	<!-- <link rel="stylesheet" type="text/css" href="/waitermate/src/main/webapp/resources/styles/styles.css" media="screen" /> -->
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
	<td><a href="/waitermate/exitTable">Exit Table</a></td>
	<td><a href="/waitermate/exitWaiter">Exit Waiter</a></td>
	</tr>
	</table>
	<br />
	
	<a href="/waitermate/addCheck">ADD A NEW CHECK</a>
	
	<br />
	<br />

			<c:forEach items="${currentTable.checkList}" var="check">
				<table>
					<tr>
						<td>Check ID: ${check.ID}</td>
						<td><a href="/waitermate/addOrder?checkId=${check.ID}">Add Order</a></td>
					</tr>
					<c:forEach items="${check.ordersList}" var="order">
						<tr>
							<td><a href="/waitermate/cancelOrderOnCheck?checkId=${check.ID}&orderId=${order.ID}">XXX</a></td>
							<td>${order.name}</td>
							<td>${order.price}</td>
							<td>${order.comment}</td>
						</tr>
					</c:forEach>
				</table>
				<table>
					<tr>
						<td>SubTotal: ${check.subtotal}</td>
						<td>Tax: ${check.tax}</td>
						<td>Tip: ${check.tip}</td>
						<td>Total: ${check.total}</td>
					</tr>
				</table>
				<table>
					<tr>
						<td><a href="/waitermate/payCheck?checkId=${check.ID}">PAYCHECK</a></td>
						<td><a href="/waitermate/addTip?checkId=${check.ID}">ADD TIP</a></td>
						<c:if test="${check.open == false}">
							<td><a>CLOSE CHECK</a></td>
						</c:if>
					</tr>
				</table>
				<br />
				<br />
			</c:forEach>

			
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