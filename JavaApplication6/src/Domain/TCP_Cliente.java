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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author eduardo.rodriguezg
 */
public class TCP_Cliente {
    
    private static String host = "192.168.100.15";
    private static int port = 8000;
    
    
    
    public void enviarMensaje(String mensaje) throws IOException{
        
        Socket echoSocket = new Socket(host, port);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        
        //BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        
        
        while (mensaje != null) {
            System.out.println("Enviando: " + mensaje);
            out.println(mensaje);
            
//            String serverMsg;
//            while ((serverMsg = in.readLine()) != null) {
//                System.out.println("Respuesta: " + serverMsg);
//                break;
//            }
        }
    }    
}
