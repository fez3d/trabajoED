/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author eduardo.rodriguezg
 */
public class Cliente {
    
    private static String host = "192.168.100.15";
    private static int port = 8000;
    
    public static void main(String[] args) throws IOException {
        
        Socket echoSocket = new Socket(host, port);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        
        BufferedReader in =
        new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        
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
