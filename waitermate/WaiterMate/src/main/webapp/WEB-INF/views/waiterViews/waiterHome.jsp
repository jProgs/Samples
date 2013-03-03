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
	
	
	<h2>${currentWaiter.fname} ${currentWaiter.lname}</h2>
	
	<form:form method="POST" action="waiterTablePagePost.html">
		<table>
			<tr>
				<td><form:label path="ID">New Table Number: </form:label></td>
				<td><form:input path="ID" /> </td>
				
				<form:hidden path="waiterID" value="${waiterID}"/>
			</tr>
			
			<tr><td><input type="submit" value="Enter" /></td></tr>
		
		</table>
	</form:form>
	
	<!--  <a href="/waterMate/waiterAddTable">Add a Table to Serve</a>  -->
	
	<p id="waiterTablesServing" class="instructions"></p>
	<br />
	
	<!--  CREATE A COLUMN OF ALL OF THE TABLES WHICH THE SERVER HAS -->
	<h3>Tables You Are Serving:</h3>
	<table>
		<c:forEach items="${currentWaiter.currentTables}" var="table">
			<tr><td><a href="/waitermate/waiterTablePage?tableId=${table.ID}">Table # ${table.ID}</a></td></tr>		
		</c:forEach>
	
	<!--/waitermate/waiterLogIn  -->
	
	</table>
	
	
	</section>
	<section id="divFooter">
		<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
	</section>

</article>

</body>
</html>