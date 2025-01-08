<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.ty.hibernateservlet.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Person and Aadhaar Information</h2>
    
  <%
    Person person = (Person) request.getAttribute("person");
    if (person != null) {
%>
	<table border="1">
	
	<tr>
	<th>PersonID</th>
	<th>Name</th>
	<th>Age</th>
	<th>Gender
	<th>AadharID</th>
	<th>Address</th>
	</tr>

    <tr>
        <td><%= person.getId() %></td>
        <td><%= person.getName() %></td>
        <td> <%= person.getAge() %></td>
        <td> <%= person.getGender() %></td>
        <td> <%= person.getAadhar().getNumber() %></td>
        <td> <%= person.getAadhar().getAddress() %></td>
        
    </tr>
    </table>
<%
    } else {
%>
    <p>No person found with the given ID.</p>
<%
    }
%>
    
</body>
</html>