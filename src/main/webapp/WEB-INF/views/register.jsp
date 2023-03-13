<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>
	<c:if test="${message ne null }">

		<font color='red'> Reason : <c:out value="${message}" />
		</font>

	</c:if>
</h3>
<hr>

<form:form action="save" method="post" modelAttribute="custBean">
	<table>
		<tr>
			<td>First Name</td>
			<td><form:input path="firstName" /></td>
			<td style="color: red;"><form:errors path="firstName" /></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><form:input path="lastName" /></td>
			<td style="color: red;"><form:errors path="lastName" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><form:input path="email" /></td>
			<td style="color: red;"><form:errors path="email" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><form:password path="password" /></td>
			<td style="color: red;"><form:errors path="password" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><form:radiobutton path="gender" value="MALE" label="male" />
				<form:radiobutton path="gender" value="FEMALE" label="female" /> <form:radiobutton
					path="gender" value="OTHER" label="other" /></td>
			<td style="color: red;"><form:errors path="gender" /></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><form:input path="age" /></td>
			<td style="color: red;"><form:errors path="age" /></td>
		</tr>
		<tr>
			<td>Date Of Birth</td>
			<td><form:input type="date" path="dateOfBirth" /></td>
			<td style="color: red;"><form:errors path="dateOfBirth" /></td>
		</tr>
		<tr>
			<td>Contact Number</td>
			<td><form:input path="contactNumber" /></td>
			<td style="color: red;"><form:errors path="contactNumber" /></td>
		</tr>

		<tr>
			<td>Country</td>
			<td><form:select path="country">
					<form:option value="">--select country--</form:option>
					<form:options items="${custBean.countries}" />
				</form:select></td>
			<td style="color: red;"><form:errors path="country" /></td>
		</tr>
		<tr>
			<td colspan="3" align="left"><input type="submit" value="SUBMIT"></td>
			<td colspan="3" align="right"><input type="reset" value="RESET"></td>
		</tr>

	</table>
</form:form>