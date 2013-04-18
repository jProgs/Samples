<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Kitchen Home</title>
	<link rel="stylesheet" type="text/css" href="/waitermate/src/main/webapp/resources/styles/styles.css" media="screen" />
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
	
	<h2><a href="/waitermate/kitchenHome">REFRESH</a></h2>
	
		<table border="1">
		<tr>
			<td>COMPLETE</td>
			<td>CHECK</td>
			<td>ORDER NAME</td>
			<td>COMMENTS</td>
		</tr>
			<c:forEach items="${allOrders}" var="order">
				<tr>
					<td><a href="/waitermate/orderUp?orderId=${order.ID}">FINISHED</a></td>
					
					<td>${order.check}</td>
					<td>${order.name}</td>
					<td>${order.comment}</td>					
				</tr>
			</c:forEach>

		</table>
	
	
	</section>
	<section id="divFooter">
		<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
	</section>

</article>

</body>
</html>