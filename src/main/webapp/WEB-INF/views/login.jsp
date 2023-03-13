<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:if test="${msg ne  null}">
	<h3 style="border: 2px solid blue; color: red; width: 150px">
		<c:out value="${msg}" />
	</h3>
</c:if>
<hr>

<form:form action="userLogin" method="post" modelAttribute="loginBean">
	<table>
		<tr>
			<td>Email</td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="SUBMIT"></td>
			<td colspan="2"><input type="reset" value="RESET"></td>
		</tr>
	</table>

</form:form>