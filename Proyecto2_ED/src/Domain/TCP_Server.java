/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Moises
 */
public class TCP_Server {
    
    public static void main(String[] args) {
        System.out.println("****** SERVIDOR ******");
        //declara un TCP socket objecto y lo inicializa como null
        ServerSocket serverSocket = null;
        //Crea el número del puerto
        int port = 1234;
        
        try{
            //Crea el server Socket TCP
            serverSocket = new ServerSocket(port);
            System.out.println("TCP server creado en el puerto " + port);
        }catch(IOException e){
            //Se ejecuta cuando el servidor no puede ser creado
            System.out.println("Error: El servidor con el puerto = "+port+ " no se pudo crear");
        }//End try-Catch
        
        //Se crea un ciclo sin fin
        while(true){
            Socket clienteSocket = null;
            try{
                //Empieza a escuchar la solicitud entrante del cliente
                System.out.println("[TCP Server] esperando la solicitud entrante...");
                clienteSocket = serverSocket.accept();
            }catch(IOException e){
                System.out.println("Error: no se puede aceptar la solicitud del cliente");
                return;
            }//End try-Catch
            
            try{
                procesarSolicitudCliente(clienteSocket);
            }catch(IOException e){
                
            }//End try-Catch
        }//End while
    }//End funcion main
    
    public static void procesarSolicitudCliente(Socket clienteSocket) throws IOException{
        
        
        System.out.println("[TCP Server] procesando la solicitud entrante...");
        try{
            OutputStream salida = clienteSocket.getOutputStream();
            InputStream entrada = clienteSocket.getInputStream();
            
            PrintStream printStream = new PrintStream(salida);
//            InputStreamReader inputStream = new InputStreamReader(entrada);
            
            //Lee el mensaje recibido
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entrada));
            String mensaje = null;
            
            mensaje = bufferedReader.readLine();

            System.out.println("Mensaje recibido del cliente: \n\t" + mensaje);
            
            //Envia una respuesta al cliente
            String mensajeEnviado = "Saludos del servidor\n";
            printStream.println(mensajeEnviado);
            printStream.close();
        }catch(Exception e){
            System.out.println("[TCP server] el mensaje no se pudo enviar");
        }
    }
    
    
}
