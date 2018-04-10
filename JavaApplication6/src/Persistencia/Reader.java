package Persistencia;


import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 *
 * @author Stamp
 */
public class Reader {
    
    public LinkedList read(){
        LinkedList empleados = new LinkedList();
    
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    "Respaldo.txt"));
            
            String line;
            while((line = in.readLine())!= null){
                if(!line.equals("\n") && !line.equals("") && !line.equals(" ")){
                    empleados.add(line);
                }
                //System.out.println("Linea: " + line);
            }
            in.close();
        }catch(IOException e){
            System.out.println("El archivo no ha sido encontrado,"
                    + " se creó uno nuevo.");
        }
        
        return empleados;
    }
}