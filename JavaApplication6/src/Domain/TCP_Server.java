/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;
import Persistencia.Writer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *
 * @author dmc-4
 */
public class TCP_Server {
    
    private static int port = 8000;
    private static Writer writer = new Writer();
    private static Queue<String> cola = new LinkedList<>();
    private static ArrayList<Empleado> empleados = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {

        
        
        ServerSocket server = new ServerSocket(port);
        Socket serverSocket = server.accept();
        
        BufferedReader in = new BufferedReader(
                new InputStreamReader(serverSocket.getInputStream()));
        
        PrintWriter out = new PrintWriter(serverSocket.getOutputStream(), true);
        
        String msg;
        while ((msg = in.readLine()) != null) {
//            System.out.println("Recibiendo: " + msg);
//            out.println("Recibi mensaje " + msg);
            String msgSub;
            
            try{
                msgSub = msg.substring(0, 5);
            }catch(StringIndexOutOfBoundsException e){
                System.out.println("Mensaje muy corto.");
                msgSub = msg + "      ";
            }
            
            System.out.println("Recibiendo: " + msg);
            out.println("Recibi mensaje " + msg);
            
            switch (msgSub){
                case "Enque":
                    System.out.println("Enque interpretado.");

                    if(TCP_Server.checkInput(msg)){
                        cola.add(msg);
                        writer.write(msg);
                        out.println("Mensaje agregado a la cola.");
                    }else{
                        out.println("Error en Enque, formato inválido.");
                    }
                    break;
                case "Deque":
                    System.out.println("Deque interpretado.");
                    
                    if(cola.peek() != null){
                        TCP_Server.processInput(cola.poll());
                    }else{
                        out.println("Cola vacía.");
                    }
                    break;
                default:

            }
        }        
    }
    
    private static boolean checkInput(String input){
        Validador validador = new Validador();
        input = input.substring(6, input.length());
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        
        if(tokenizer.countTokens() != 3){
            return false;
        }
        
        String nombre = tokenizer.nextToken();
        String apellido = tokenizer.nextToken();
        return validador.checkDoubleIn(tokenizer.nextToken());
    }
    
    private static void processInput(String input){
        Validador validador = new Validador();
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        
        String nombre = tokenizer.nextToken();
        String apellido = tokenizer.nextToken();
        Double salario = validador.toDoubleIn(tokenizer.nextToken());
        
        empleados.add(new Empleado(nombre, apellido, salario));
    }
}
