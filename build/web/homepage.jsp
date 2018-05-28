<%-- 
    Document   : homepage
    Created on : May 28, 2018, 2:36:40 PM
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
        <title>Welcome</title>
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
        <h1>Scan FingerPrint</h1>
        <div class="container">
            <form action ="VoterDetails.jsp" method="post">
                <div class="form-group">
                    <a href="VoterDetails.jsp">
                    <img src="https://media.kasperskydaily.com/wp-content/uploads/sites/92/2015/12/06023350/fingerprints-FB-1.jpg" class="img_responsive" alt="Cinque Terre" height="100">
                    </a>
                </div>
            </form>
        </div>
        
    </body>
</html>
