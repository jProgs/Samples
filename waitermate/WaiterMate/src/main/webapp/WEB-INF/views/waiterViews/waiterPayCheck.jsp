<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Waiter Pay Check</title>
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
	
	<p class="instructions">Bill: </p>
	<p class="billAmount">${currentCheck.subtotal}</p>
	<br />
	<p class="instructions">Tax: </p>
	<p class="taxAmount">${currentCheck.tax} </p>
	<br />
	<p class="instructions">Total: </p>
	<p class="billTotal">${currentCheck.subtotal + currentCheck.tax} </p>
	 
		
	<form:form method="POST" action="payCheckSubmitted.html">
		<table>
			<tr>
				<td><form:label path="">Social Last 5: </form:label></td>
				<td><form:input path="ID" /> </td>
			</tr>
			
			<tr><td><input type="submit" value="Enter" /></td></tr>
		
		</table>
	</form:form>
	
	
	</section>
	<section id="divFooter">
		<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
	</section>

</article>

</body>
</html>