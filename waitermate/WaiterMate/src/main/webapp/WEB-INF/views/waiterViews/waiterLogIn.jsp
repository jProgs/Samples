<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Waiter Log In</title>
	<link rel="stylesheet" type="text/css" href="css/styles.css" media="screen" />
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
	
	<p id="logInInstructions" class="instructions">ENTER THE LAST 5 DIGITS OF YOUR SOCIAL SECURITY NUMBER</p>
	
	<form:form method="POST" action="waiterHome.html">
		<table>
			<tr>
				<td><form:label path="ID">Social Last 5: </form:label></td>
				<td><form:input path="ID" /> </td>
				<td><input type="submit" value="Enter" /></td>
			</tr>			
					
		</table>
	</form:form>
	
	
	
	
	
	
	</section>
	<section id="divFooter">
		<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
	</section>

</article>

</body>
</html>