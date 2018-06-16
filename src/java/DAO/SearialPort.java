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

public class SearialPort {

//    public static SerialPort serialPort;
    public static boolean sentBytes;

    public static FingerPrint readSerial() {
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
        SerialPort serialPort = new SerialPort("COM8");

        try {
            // open port for communication
            try {
//            serialPort.closePort();
            } catch (Exception e) {
                System.out.println(e);
                e.printStackTrace();
            }
            boolean f = false;
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
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String port = serialPort.readString();
                System.err.println(port);
                if (port != null) {
                    System.out.println("statred>............");
                    if (port.contains("F")) {
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
                                serialPort.writeString("a");
//                        serialPort.closePort();
//                        f = false;
                            }

                        }
                    }else if(port.contains("C"))  {
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
                            serialPort.closePort();
                            f= false;
//                                serialPort.closePort();
//                        f = false;
                            }

                        }
                    }
                }

                System.out.println("end");
            } // close port
//            serialPort.closePort();
        } catch (SerialPortException ex) {
            System.out.println(ex);
            ex.printStackTrace();
//            readSerial();
        }
        System.out.println("hello");
        return fng;

    }

    public static void main(String[] args) {
        readSerial();
    }
}
