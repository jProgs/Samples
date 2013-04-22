<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Menu Add Comment</title>
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
	
	<h2>ADD COMMENTS</h2>
	
	<form:form method="POST" action="readyToAddOrder.html">
		<table>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name" value="${currentOrder.name}" readonly="true" /> </td>
			</tr>
			<tr>
				<td><form:label path="price">Price:</form:label></td>
				<td><form:input path="price" value="${currentOrder.price}" readonly="true" /> </td>
			</tr>
			<tr>
				<td><form:label path="category">Category:</form:label></td>
				<td><form:input path="category" value="${currentOrder.category}" readonly="true" /> </td>
			</tr>
			
			<tr>
				<td><form:label path="comment">Comment:</form:label></td>
				<td><form:input  path="comment" size="150" /> </td>
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