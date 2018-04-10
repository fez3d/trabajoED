/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Domain.TCP_Server;
import java.io.IOException;
/**
 *
 * @author Stamp
 */
public class MainServidor {

    public static void main(String[] args) {
        try{
            TCP_Server.run();
        }catch(IOException e){
            System.out.println("Error fatal durante la ejecución.");
        }
    }
    
}
