<%-- 
    Document   : ConstituencyCandidateList
    Created on : May 27, 2018, 11:27:41 PM
    Author     : Welcome
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
        <title>Constituency List</title>
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
        <h1>Candidates!</h1>
        <form action="CandidateListC" method="post">
            <div class="form-group">
                <div>
                    <button type="submit" class="btn btn-default ">Get Party List</button>
                </div>
              
                    <div>
                        <a class="btn btn-default" href="ConfirmVote.jsp">NEXT</a>
                    </div>
                </div>

        </form>
    </body>
</html>
