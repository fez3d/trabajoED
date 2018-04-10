/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Moises
 */
public class TCP_Cliente {

    public static void main(String[] args) throws IOException{
        System.out.println("****** CLIENTE ******");
        
        Socket clientSocket = null;
        String serverHostName = "localhost";
        int port = 1234;
        
        try{
            System.out.println("[TCP Client] tratando de conectarse con el servidor TCP");
            clientSocket = new Socket(serverHostName, port);
        }catch(IOException e){
            System.out.println("[TCP server] no se puede abrir el socket con el servidor");
        }
        
        PrintStream printStream = new PrintStream(clientSocket.getOutputStream());
        InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());
        
//        Scanner s = new Scanner(System.in);
//        System.out.println("Presiona una tecla para enviar el mensaje...");
//        s.nextLine();
        

        //enviar mensaje al cliente
        String mensaje1 = "Saludos del cliente";
        printStream.print(mensaje1);
        
        //recibiendo respuesta del servidor
        BufferedReader bufferedReader = new BufferedReader(inputStream);
        String mensaje = bufferedReader.readLine();
        System.out.println("Mensaje recibido del servidor: \n\t" +mensaje);
    }
    
}
