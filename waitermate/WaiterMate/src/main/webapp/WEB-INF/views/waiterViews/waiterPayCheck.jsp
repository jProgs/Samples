<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Waiter Pay Check</title>

<script type="text/javascript">
	
	var total;
	var tendered;
	var change = 0;
	var tip = 0;
	
	function updateTendered(){
		total =  parseFloat(document.getElementById('total').value);
		tendered = parseFloat (document.getElementById('tendered').value);
		this.updateForm();
	}

	function updateForm(){
		if(tendered != 0)
			{
				if(document.getElementById('yesChange').checked){
					change = tendered - total;
					change = Math.round(change*100);
					change = change/100;
					change = change.toFixed(2);
					document.getElementById('change').value = change;
					document.getElementById('tip').value = 0;
				}else if(document.getElementById('noChange').checked){
					tip = tendered - total;
					tip = Math.round(change*100);
					tip = tip/100;
					tip = tip.toFixed(2);
					document.getElementById('tip').value = tip;
					document.getElementById('change').value = 0;
				}
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
				<input type="hidden" id="total" value="${currentCheck.total}" />
				
				<table>
					<tr>
						<td>AMOUNT TENDERED: <input type="text" id="tendered" name="tendered" onchange="updateTendered()" value="0" /></td>
					</tr>
				</table>
				<table>
					<tr>
						<td>CHANGE WANTED?</td>
						<td>YES <input id="yesChange" class="changeRadio" onclick="updateForm()" type="radio" name="changeWanted" value="yes" checked/></td>
						<td>NO <input id="noChange" class="changeRadio" onclick="updateForm()" type="radio" name="changeWanted" value="no" /></td>
					</tr>					
				</table>
				<table>
					<tr>
						<td>CHANGE TO GIVE:</td>
						<td><input type="text" id="change" value="0" /></td>
					</tr>
				</table>
			</form>

			<table>
				<form:form method="POST" action="payCheckCompleted">
					<tr>
						<td><form:label path="tip" >TIP: </form:label></td>
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