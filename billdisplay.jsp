<this is diaplay page wich after excuting code the info of the consumer shown of this page>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String consumerno = (String) session.getAttribute("consumerno");
	String consumername = (String) session.getAttribute("consumername");
	float billAmt = (float) session.getAttribute("billAmt");
	
	out.println("Total Bill Amount for Consumer no:" + consumerno + " & Consumer name: " + consumername + " is = " + billAmt + " rs.");
	%>

</body>
</html>