<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Waiter Home</title>
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
	
	<h2>${waiterFname} ${waiterLname}</h2>
	
	<a href="/waterMate/waiterAddTable">Add a Table to Serve</a>
	
	<p id="waiterTablesServing" class="instructions"></p>
	<br />
	
	<!--  CREATE A COLUMN OF ALL OF THE TABLES WHICH THE SERVER HAS -->
	<h3>Tables You Are Serving:</h3>
	<table>
		<c:forEach items="${waiterTableList}" var="table">
		<tr><td><a href="/waiterMate/SelectTableOfWaiter?tableId=${table.ID}">Table # ${table.ID}</a></td></tr>		
	</c:forEach>
	
	<!--  -->
	
	</table>
	
	
	</section>
	<section id="divFooter">
		<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
	</section>

</article>

</body>
</html>