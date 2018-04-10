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
 * @author dmc-4
 */
public class TCP_Cliente {
    
    private static String host = "192.168.100.15";
    private static int port = 8000;
    private static Socket echoSocket;
    
    public TCP_Cliente() throws IOException{
        this.echoSocket = new Socket(host, port);
    }
    
    
    public void enviarMensaje(String mensaje) throws IOException {
        
       
        PrintWriter out = new PrintWriter(this.echoSocket.getOutputStream(), true);
        
        BufferedReader in =
        new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        
       
        
        String userInput = mensaje;
        System.out.println(userInput);
        if (userInput != null) {
            System.out.println("Enviando: " + userInput);
            out.println(userInput);
            
            String serverMsg;
            while ((serverMsg = in.readLine()) != null) {
                System.out.println("Respuesta: " + serverMsg);
                break;
            }
        }
        
    }    
    
 
}
