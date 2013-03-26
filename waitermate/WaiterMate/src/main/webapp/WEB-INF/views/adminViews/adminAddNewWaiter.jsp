<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Admin Add New Waiter</title>
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
	
	<h2>Admin Add Waiter</h2>
	
	<br />
	<br />
	<h3>Taken ID's</h3>
	<table>	
	<c:forEach items="${waiterList}" var="waiter">
		<tr><td>${waiter.ID}</td></tr>
	</c:forEach>
	</table>
	
	<br />
	<h3>NEW WAITER</h3>

			<form:form method="POST" action="adminAddThisWaiter.html">
				<table>
					<tr>
						<td><form:label path="ID">5 Digit ID: </form:label></td>
						<td><form:input path="ID" /></td>
					</tr>
					<tr>
						<td><form:label path="fname">First Name: </form:label></td>
						<td><form:input path="fname" /></td>
					</tr>
					<tr>
						<td><form:label path="lname">Last Name: </form:label></td>
						<td><form:input path="lname" /></td>
					</tr>
					<tr>
						<td><form:label path="admin">Admin?: </form:label></td>
						<td>
							<form:select path="admin">
								<form:option value="true" label="true" />
								<form:option value="false" label="false" />
							</form:select>
					</tr>
					<tr>
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