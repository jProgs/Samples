<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Waiter Pay Check</title>

<script type="text/javascript">
	var subtotal = parseFloat('${currentCheck.subtotal}');
	var tax = parseFloat('{currentCheck.tax}');
	var total = parseFloat('{currentCheck.total}');
	float tendered = 0;
	
	function updateTendered(){
		tendered = document.getElementById('tendered').value.parseFloat();		
	}

	function updateForm(){
		if(tendered != 0)
			{
				alert(tendered);
			}		
			
			
		
				
	}
		
		
		
		
	
</script>

</head>
<body>
	<article id="divPage">
		<section id="divHeader">
			<jsp:include page="/WEB-INF/partials/header.jsp"></jsp:include>
		</section>
		<section id="divNav">
			<aside id="divNav"><jsp:include
					page="/WEB-INF/partials/nav.jsp"></jsp:include></aside>
		</section>
		<section id="divContent">
<!-- TOTALS FOR THE BILL -->
			<table>
				<tr><td>Subtotal: </td><td>${currentCheck.subtotal}</td></tr>
				<tr><td>Tax: </td><td>${currentCheck.tax}</td></tr>
				<tr><td>Total: </td><td>${currentCheck.total}</td></tr>				
			</table>
<!-- FORMS FOR AMOUNT TENDERED, ADDING A TIP -->
			<form>
				<table>
					<tr>
						<td>AMOUNT TENDERED: <input type="text" id="tendered" name="tendered" onchange="updateTendered()" /></td>
					</tr>
				</table>
				<table>
					<tr>
						<td>CHANGE WANTED?</td>
						<td>YES <input id="yesChange" class="changeRadio" onclick="updateForm()" type="radio" name="changeWanted" value="yes" /></td>
						<td>NO <input id="noChange" class="changeRadio" onclick="updateForm()" type="radio" name="changeWanted" value="no" /></td>
					</tr>					
				</table>
				<table>
					<tr>
					<td>
					<input type="text" id="change" /> 
					</td>
					</tr>
				</table>
			</form>

			<table>
				<form:form method="POST" action="payCheckCompleted">
					<tr>
						<td><form:label path="tip" >Tip: </form:label></td>
						<td><form:input path="tip" id="tip" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Enter" /></td>
					</tr>
				</form:form>
			</table>
		</section>
		<section id="divFooter">
			<jsp:include page="/WEB-INF/partials/footer.jsp"></jsp:include>
		</section>

	</article>

</body>
</html>