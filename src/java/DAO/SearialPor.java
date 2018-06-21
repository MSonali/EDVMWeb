/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Model.CastVote;
import Model.FingerPrint;
import java.util.HashSet;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

class Check {

    public static boolean f = false;

}

public class SearialPor {

//    public static SerialPort serialPort;
    public static boolean sentBytes;
    public static SerialPort serialPort = new SerialPort("COM8");;

    public static void readSerial() {
        FingerPrint fng = null;
        FingerPrint fn = new FingerPrint();
        String fin = "";

        System.out.println("start");

        String[] portNames = SerialPortList.getPortNames();
        for (String port : portNames) {
            System.out.println(port);
        }

        // initialization with selecting port for communication
//      SerialPort serialPort = new SerialPort("/dev/ttyUSB0");
        
        
        try {
            // open port for communication

            boolean f = false;
            if(!serialPort.isOpened()){
            try {
                
                f = serialPort.openPort();
                
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE, false, true);
            serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_NONE);

            while (f) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                serialPort.writeInt(1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String port = serialPort.readString();
                System.err.println(port);
                if (port != null) {
                    System.out.println("statred>............");
                    if (port.contains("F") && !port.contains("C")) {
                        port = port.replaceAll("[^1-9A-Z\\s]", "");

//             System.out.println(port.replaceAll("[^0-9\\s]", ""));
                        int id = 0;
//                System.out.println(port.replaceAll("[\\sA-Z]", ""));
                        char c[] = port.toCharArray();
                        UserDao dao = new UserDao();
                        HashSet<String> hs = dao.getFingetId();
                        System.out.println(hs);

                        for (char c1 : c) {
                            if (hs.contains(String.valueOf(c1))) {
                                System.out.println("valid " + c1);

                                fng = new FingerPrint();
                                fng.setFp(String.valueOf(c1));
//                                FingerPrint.setFp(String.valueOf(c1));
                                fin = String.valueOf(c1);
//                                serialPort.writeString("a");
                                port = null;
                                break;
//                        serialPort.closePort();
//                        f = false;
                            }

                        }
                    } else if (port.contains("C")) {
                        System.out.println(port);
                        port = port.replaceAll("[^1-9A-Z\\s]", "");
                        char c[] = port.toCharArray();
                        UserDao dao = new UserDao();
                        HashSet<String> hs = dao.getCandidateId();
                        for (char c1 : c) {
                            if (hs.contains(String.valueOf(c1))) {
                                System.out.println("valid " + c1);
//                                CastVote.setCandidate(String.valueOf(c1));
                                CastVote v = new CastVote();
                                v.setCandidate(String.valueOf(c1));

                                port = null;
                                if (serialPort.isOpened()) {
                                    f = false;
                                    serialPort.closePort();
                                    break;
                                }
                                
//                                serialPort.closePort();
//                        f = false;
                            }

                        }
                    }
                }

                System.out.println("end");
            } // close port
//      
            }
        } catch (SerialPortException ex) {
            System.out.println(ex);
            ex.printStackTrace();
//   
        }
        System.out.println("hello");
       

    }

    public static void main(String[] args) {
        readSerial();
        
    }
}
