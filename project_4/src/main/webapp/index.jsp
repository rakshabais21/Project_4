<%@page import="in.co.rays.project_4.controller.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online result System</title>
</head>
<body>
<style>
.style {
    padding-top: 12%;
}
</style>
<div class="style">
	<h1 align="Center" >
       <!--  <img src="img/customLogo.png" width="318" height="127" border="0"> -->
      <a href = "<%= ORSView.WELCOME_CTL %>"></a><img src="img/customLogo.png" width="318" height="127" border="0"></font>
    </h1>

    <h1 align="Center">
        <font size="10px" color="red" ><a  href="<%=ORSView.WELCOME_CTL%>">Online Result System</font>
        <!-- style="text-decoration: none" -->
         <br> <br>
        
    </h1>

</div>
</body>
</html>