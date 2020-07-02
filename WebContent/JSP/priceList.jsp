<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle Application</title>
<style>
a {
	font-family: Times New Roman;
	color: black;
	font-size: 14pt;
	font-style: normal;
	text-decoration: initial;
	margin-left: 15px;
	margin-right: 15px;
}

div {
	height: 32px;
	text-align: center;
	padding: 5px;
	background: url('JSP/menu.jpg');
	border-top: 1px solid black;
}

p {
	height: 70px;
	text-align: center;
	padding: 5px;
	background: url('JSP/background.jpg');
	border-top: 1px solid black;
}
</style>
</head>
<body>

<center>
<h1 style="color: #0066CC">Vehicle Application</h1>
</center>

<h3>Vehicle Details</h3>
<hr size="4" color="gray"/>
<table>
<tr>
<th>Make Name</th>
<th>Model Name</th>
<th>Model Edition</th>
<th>Price</th>
<th>Options</th>
</tr>
<c:forEach items="${vehicleList}" var="vehicle" varStatus="tagStatus">
    <tr>
        <td>${vehicle.makeName}</td>
        <td>${vehicle.modelName}</td>
        <td>${vehicle.modelEdition}</td>
        <td>${vehicle.price}</td>
        <td>${vehicle.options}</td>
        <td><form:form action="/VehiclePrice/getVehicleDetail.obj?id=${vehicle.id}"><input type="submit" value="Edit"/></form:form></td>
        <td><form:form action="/VehiclePrice/deleteVehicle.obj?id=${vehicle.id}"><input type="submit" value="Delete"/></form:form></td>
    </tr>
</c:forEach>
</table>

<div>
<h3 align="left" >${function} Vehicle Details:</h3>
<form:form method="post" action="/VehiclePrice/${function}Vehicle.obj" modelAttribute="vehicleForm">
			<table>
				<tr>
                    <td><form:label path="id" ></form:label></td>
                    <td><form:input path="id" type="hidden" required="required"/></td>
                </tr>
                <tr>
                    <td><form:label path="makeName">Make Name</form:label></td>
                    <td><form:input path="makeName" required="required"/></td>
                </tr>
                <tr>
                    <td><form:label path="modelName">Model Name</form:label></td>
                    <td><form:input path="modelName" required="required"/></td>
                </tr>
                <tr>
                    <td><form:label path="modelEdition">Model Edition</form:label></td>
                    <td><form:input path="modelEdition" required="required"/></td>
                </tr>
                <tr>
                    <td><form:label path="price">Price</form:label></td>
                    <td><form:input path="price" required="required"/></td>
                </tr>
                <tr>
                     <td><form:label path="options">Options</form:label></td>
                    <%-- <td><form:input path="options"/></td> --%>
                    <td>
                    <form:select  path="options">
				    	<form:option value="1" label="Sunroof"/>
                    	<form:option value="2" label="Heated seats"/>
                    	<form:option value="3" label="Air Con"/>
				    </form:select>
			        </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
</form:form>
</div>
<br>
<br>
<br>
</body>
</html>