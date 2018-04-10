/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import Controlador.ControlVistaCliente;
import Vista.VistaCliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader; 
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduardo.rodriguezg
 */
public class TCP_Cliente {
    
    private static String host = "192.168.100.15";
    private static int port = 8000;
    private static Socket socket;
    
    
    
//    public void enviarMensaje(String mensaje) throws IOException {
//        
//        try {
//            InetAddress address = InetAddress.getByName(host);
//            socket = new Socket(address, port);
// 
//            //Send the message to the server
//            OutputStream os = socket.getOutputStream();
//            OutputStreamWriter osw = new OutputStreamWriter(os);
//            BufferedWriter bw = new BufferedWriter(osw);
// 
//            String number = mensaje;
// 
//            String sendMessage = number + "\n";
//            bw.write(sendMessage);
//            bw.flush();
//            System.out.println("Message sent to the server : "+sendMessage);
// 
//            //Get the return message from the server
//            InputStream is = socket.getInputStream();
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//            String message = br.readLine();
//            System.out.println("Message received from the server : " +message);
//        }
//        catch (Exception exception)
//        {
//            exception.printStackTrace();
//        }
//        finally
//        {
//            //Closing the socket
//            try
//            {
//                socket.close();
//            }
//            catch(Exception e)
//            {
//                e.printStackTrace();
//            }
//        }
//    }    
    
    public static void main(String[] args) throws IOException {
        
        Socket echoSocket = new Socket(host, port);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        
        BufferedReader in =
        new BufferedReader(
            new InputStreamReader(echoSocket.getInputStream()));
        
        BufferedReader stdIn
                = new BufferedReader(
                        new InputStreamReader(System.in));
        
        String userInput;
        
        while ((userInput = stdIn.readLine()) != null) {
            System.out.println("Enviando: " + userInput);
            out.println(userInput);
            
            String serverMsg;
            while ((serverMsg = in.readLine()) != null) {
                System.out.println("Respuesta: " + serverMsg);
                break;
            }
        }
        
//        
//        
        
    }
}
