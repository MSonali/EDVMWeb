<%-- 
    Document   : homepage
    Created on : May 28, 2018, 2:36:40 PM
    Author     : Welcome
--%>

<%@page import="Model.FingerPrint"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script type="text/javascript">
            var request;
            function sendInfo()
            {

                var url = "scanfinger.jsp";

                if (window.XMLHttpRequest) {
                    request = new XMLHttpRequest();
                } else if (window.ActiveXObject) {
                    request = new ActiveXObject("Microsoft.XMLHTTP");
                }

                try
                {
                    request.onreadystatechange = getInfo;
                    request.open("GET", url, true);
                    request.send();
                } catch (e)
                {
                    alert("Unable to connect to server");
                }
            }
            function getInfo() {
                if (request.readyState == 4) {
                    var val = request.responseText;
                    document.getElementById('links').innerHTML = val;
                   
                    if(val!=null && val!=""){
//                        window.location='VoterDetails.jsp';
                    }
//                    alert(val);
                }else{
                    document.getElementById('links').innerHTML = "";
                }
            }

            setInterval(function () {
                sendInfo();
            }, 1000)
/*
function loadData(url, callback){
var xhttp = new XMLHttpRequest();
xhttp.onreadystatechange = function(){
 if(this.readyState == 4 && this.status == 200){
 callback.apply(xhttp);
 }
};
xhttp.open("GET", url, true);
xhttp.send();
}
function updateData(){
 document.getElementById("links").innerHTML = this.responseText;
}*/
        </script>

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
                        <a class="navbar-brand" href="index.jsp">VotingApp</a>
                    </div>
                </div>
            </nav>
        </div>
        <h1>Scan FingerPrint</h1>
        <div class="container">
            <form action ="VoterDetails.jsp" method="post">
                <div class="form-group">
                    <a href="VoterDetails.jsp">
                        <h1>Scan Finger</h1>
                        <img src="https://media.kasperskydaily.com/wp-content/uploads/sites/92/2015/12/06023350/fingerprints-FB-1.jpg" class="img_responsive" alt="Cinque Terre" height="100">
                    </a>
                </div>
            </form>
        </div>
       
        <div id="links">
            
            
        </div>
        <%
            String fs = (String) session.getAttribute("fno");
            FingerPrint f=new FingerPrint();
            String s = f.getFingerPrint();
            if(s!=null){
//                out.println(s);
            }
            //out.println("Press icon");
//           out.println(fs);
            if(fs!=null){
//       String fingetPrint =   fs.getFingerPrint();
//       out.println(fingetPrint);
//             if (fingetPrint != null && fingetPrint != "" && !fingetPrint.equals("0")) {
////                response.sendRedirect("VoterDetails.jsp");
//              
//            }
//            out.println(fs);
            }
            %>
    </body>
</html>
