<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Pick an item</title>
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
	
	<h2>PICK AN ITEM</h2>

			<table>
				<c:forEach items="${menuBean.menu}" var="item">
					<c:if test="${item.category == currentCategory}">
						<tr>
							<td><a href="/waitermate/orderChosen?orderName=${item.name}">${item.name}</a></td>
						</tr>
					</c:if>
				</c:forEach>
			</table>

		</section>
	<section id="divFooter">
		<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
	</section>

</article>

</body>
</html>