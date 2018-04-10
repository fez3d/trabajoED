/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author eduardo.rodriguezg
 */
public class Servidor {
    
    private static int port = 8000;
    
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);
        Socket serverSocket = server.accept();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(serverSocket.getInputStream()));

        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);

        String msg;
        while ((msg = in.readLine()) != null) {
            System.out.println("Recibiendo: " + msg);
            out.println("Recibi mensaje " + msg);
        }
    }
}