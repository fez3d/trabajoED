/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author dmc-4
 */
public class Empleado {
    
    private final String nombre;
    private final String apellido;
    private final double salario;
    
    public Empleado(String nombre, String apellido, double salario){
        this.apellido = apellido;
        this.nombre = nombre;
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado:\t" + "nombre: " + nombre + " apellido: " + apellido + " salario: " + salario;
    }
    
    
}
