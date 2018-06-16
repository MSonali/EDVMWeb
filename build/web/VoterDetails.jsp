<%-- 
    Document   : VoterDetails
    Created on : May 27, 2018, 11:21:57 PM
    Author     : Welcome
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            body{
                background-image: url(https://thumbs.dreamstime.com/z/hand-voting-sign-india-illustration-39269631.jpg);
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
        <title>Voter Details Page</title>
    </head>
    <body>
        <div class="page-header text-center">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="index.html">VotingApp</a>
                    </div>
                </div>
            </nav>
        </div>
        <h1>Your Details</h1>
        <div class="container">
            <form action ="VoterDetailsC" method="post">
                <div class="form-group">
                    <div>
                    <button type="submit" class="btn btn-default ">Get Info</button>
                </div>
                     <label for="ano">Ano </label>
                     <!--${ano}-->
                     <%
                    String ano = (String)request.getAttribute("ano");
                     if(ano!=null){
                     %>
                     <%=ano%>
                     <%}%>
                </div>
                <div>
                    <label for="const">Constituency </label>
                      <%
                    String const1 = (String)request.getAttribute("const");
                    if(const1!=null){
                     %>
                     <%=const1%>
                    <%}%>
                <div>
                    <a class="btn btn-default" href="ConstituencyCandidateList.jsp">OK</a>
                </div>
                </div>
            </form>
        </div>
    </body>
</html>
