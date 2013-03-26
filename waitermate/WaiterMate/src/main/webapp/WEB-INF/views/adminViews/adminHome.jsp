<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Admin Home</title>
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
	
	<h2>Admin Home</h2>
	
	<a href="/waitermate/adminAddNewWaiter">Add a New Waiter</a>
	<br />
	<a href="/waitermate/adminAddAdminRights">Add Admin Rights to a Waiter</a>
	<br />
	<a href="/waitermate/adminAddNewMenuItem">Add a New Menu Item</a>
	<br />
	<a href="/waitermate/adminChangeMenuItemPrice">Change Menu Item Price</a>
	<br />
	
	
	
	</section>
	<section id="divFooter">
		<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
	</section>

</article>

</body>
</html>