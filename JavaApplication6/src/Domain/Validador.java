package Domain;

import java.util.Scanner;

/**
 *
 * @author Stamp
 */
public class Validador {
    public int toInt(){
        Scanner scanner = new Scanner(System.in);
        boolean numeroValido = false;
        int entero = 0;
        
        while (!numeroValido){
            try{
                entero = Integer.valueOf(scanner.nextLine());
                numeroValido = true;
            }catch(NumberFormatException e){
                System.out.println("Formato de número inválido. Ingréselo de nuevo.");
            }
        }
        
        return entero;
    }
    
    
    public int toInt(int limInf, int limSup){
        Scanner scanner = new Scanner(System.in);
        boolean numeroValido = false;
        int entero = 0;
        
        while (!numeroValido){
            try{
                entero = Integer.valueOf(scanner.nextLine());
                numeroValido = true;
                if(entero < limInf || entero > limSup){
                    System.out.println("Numero fuera de rango, ingréselo de nuevo:");
                    numeroValido = false;
                }
            }catch(NumberFormatException e){
                System.out.println("Formato de número inválido. Ingréselo de nuevo:");
            }
        }
        return entero;
    }
    
    
    public int toPostiveInt(){
        Scanner scanner = new Scanner(System.in);
        boolean numeroValido = false;
        int entero = 0;
        
        while (!numeroValido){
            try{
                entero = Integer.valueOf(scanner.nextLine());
                numeroValido = true;
                if(entero <= 0){
                    System.out.println("Numero fuera de rango, ingréselo de nuevo:");
                    numeroValido = false;
                }
            }catch(NumberFormatException e){
                System.out.println("Formato de número inválido. Ingréselo de nuevo:");
            }
        }
        return entero;
    }
    
    public boolean checkDoubleIn(String input){
        boolean numeroValido = false;
        double doble = 0;
        
        try{
            doble = Double.parseDouble(input);
            numeroValido = true;
        }catch(NumberFormatException e){
            numeroValido = false;
        }
        return numeroValido;
    }
    
    public double toDoubleIn(String input){
        double doble = 0;
        
        try{
            doble = Double.parseDouble(input);
        }catch(NumberFormatException e){
            
        }
        
        return doble;
    }
}
