package Persistencia;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


/**
 *
 * @author Stamp
 */
public class Writer {

    private PrintWriter pw;
    
    public void escribe(String linea){
        try {
            pw = new PrintWriter(new FileWriter("Asientos.txt", true));
            //Para reescribir:
            // new PrintWriter("Distribuidora.txt", "UTF-8");
            pw.println(linea);
            pw.close();
        } catch (IOException ex) {
            System.out.println("Error al escribir el archivo.");
            System.out.println("Archivo no encontrado.");
        }
    }
    
    public void clearFile(){
        try{
            pw = new PrintWriter("Asientos.txt", "UTF-8");
        }catch(IOException ex){
            System.out.println("Error al limpiar el archivo.");
        }
    }
}
