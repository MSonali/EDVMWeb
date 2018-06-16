
<%@page import="Model.FingerPrint"%>
<%@page import="DAO.SearialPort"%>

        <%
//            out.print("hello");
//            FingerPrint fin = null;
//            try {
//                fin = SearialPort.readSerial();
//            } catch (Exception e) {
//
//            }
//            if(fin!=null){
//            session.setAttribute("fno", fin);
////            String fingetPrint = FingerPrint.getFingerPrint();
//           String fingetPrint = fin.getFingerPrint();
//          
//            if (fingetPrint != null && fingetPrint != "" && !fingetPrint.equals("0")) {
//                out.print(fingetPrint);
//              
//            }
//            }


 String fs = (String) session.getAttribute("fno");
            FingerPrint f=new FingerPrint();
            String s = f.getFingerPrint();
            if(s!=null){
                out.println(s);
            }
            out.println(fs);
            if(fs!=null){
//       String fingetPrint =   fs.getFingerPrint();
//       out.println(fingetPrint);
//             if (fingetPrint != null && fingetPrint != "" && !fingetPrint.equals("0")) {
////                response.sendRedirect("VoterDetails.jsp");
//              
//            }
            out.println(fs);
            }
        %>
  