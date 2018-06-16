<%-- 
    Document   : start.jsp
    Created on : Jun 14, 2018, 1:09:22 PM
    Author     : Kumaresan
--%>

<%@page import="DAO.SearialPort"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <%
       SearialPort.readSerial();
       response.sendRedirect("homepage.jsp");
       %>
    </body>
</html>
