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
		<jsp:include page="/partials/header.jsp"></jsp:include>
	</section>
	<section id="divNav">
		<aside id="divNav"><jsp:include page="/partials/nav.jsp"></jsp:include></aside>
	</section>
	<section id="divContent">
	
	<p class="instructions">Bill: </p>
	<p class="billAmount">${check.bill}</p>
	<br />
	<p class="instructions">Tax: </p>
	<p class="taxAmount">${check.tax} </p>
	<br />
	<p class="instructions">Total: </p>
	<p class="billTotal">${check.total} </p>
	
	<table>
	<tr>
        <td><form:label path="amountPaid">Amount Paid:</form:label></td>
        <td><form:input path="amountPaid"/></td> 
    </tr>
    <tr>
        <td><form:label path="changeQuestion">Did They Ask for Change?</form:label></td>
        <td><form:checkbox  path="changeQuestion" /></td> 
    </tr>
    <tr>
        <td><form:label path="change">Change to Give:</form:label></td>
        <td><form:input path="change"/></td> 
    </tr>
    <tr>
        <td><form:label path="tip">Tip:</form:label></td>
        <td><form:input path="tip"/></td> 
    </tr>
    
	
	</table>
	
	
	</section>
	<section id="divFooter">
		<jsp:include page="/partials/footer.jsp"></jsp:include>
	</section>

</article>

</body>
</html>