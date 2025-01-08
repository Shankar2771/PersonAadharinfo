<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@ page import="com.ty.hibernateservlet.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>All Person and Aadhaar Information</h2>
    
<%
    List<Person> personList = (List<Person>) request.getAttribute("personList");
    if (personList != null && !personList.isEmpty()) {
%>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
            <th>Aadhar Id</th>
            <th>Aadhar Number</th>
            <th>Address</th>
        </tr>
        <%
            for (Person person : personList) {
        %>
        <tr>
            <td><%= person.getId() %></td>
            <td><%= person.getName() %></td>
            <td><%= person.getAge() %></td>
            <td><%=person.getGender() %></td>
            <td><%=person.getAadhar().getAid() %></td>
            <td><%=person.getAadhar().getNumber() %></td>
            <td><%=person.getAadhar().getAddress() %></td>
        </tr>
        <%
            }
        %>
    </table>
<%
    } else {
%>
    <p>No persons found in the database.</p>
<%
    }
%>

</body>
</html>