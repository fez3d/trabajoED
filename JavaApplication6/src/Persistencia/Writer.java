package Persistencia;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;


/**
 *
 * @author Stamp
 */
public class Writer {

    private PrintWriter pw;
    
    public void write(String linea){
        try {
            pw = new PrintWriter(new FileWriter("Respaldo.txt", true));
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
            pw = new PrintWriter("Respaldo.txt", "UTF-8");
        }catch(IOException ex){
            System.out.println("Error al limpiar el archivo.");
        }
    }
    
    public void deleteLine(){
        String doc = "";
        Reader reader = new Reader();
        LinkedList lines = reader.read();
        lines.pop();
        
        while(lines.peek() != null){
            doc += lines.pop();
            if (!lines.isEmpty()){
                doc += "\n";
            }
        }
        
        clearFile();
        write(doc);
    }
}