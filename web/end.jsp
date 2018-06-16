<%-- 
    Document   : end
    Created on : May 29, 2018, 12:18:34 PM
    Author     : Shyamil
--%>

<%@page import="Model.CastVote"%>
<%@page import="Model.FingerPrint"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            body{
                background-image: url(https://thumbs.dreamstime.com/z/hand-voting-sign-india-illustration-39269631.jpg)  ;
                background-size: cover;
                background-repeat: no-repeat;
            }
        </style>
        <title>End</title>
    </head>
    <body>
        <h1>Thank You!</h1>
        <%!
       static{
       FingerPrint fn = new FingerPrint();

        fn.setFp("0");
        }

        %>
        <%
        session.invalidate();
       %>
        <a class="btn btn-default" href="index.jsp">EXIT</a>
    </body>
</html>
