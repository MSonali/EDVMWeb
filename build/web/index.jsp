<%@page import="Model.FingerPrint"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Hello</title>
        <meta charset="UTF-8">
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
    </head>
    <body>
        <div>
            <a class="btn btn-default" href="start.jsp">START</a> 
            <%!
                static {
                    FingerPrint fn = new FingerPrint();

                    fn.setFp("0");
                }
            %>
        </div>
    </body>
</html>
