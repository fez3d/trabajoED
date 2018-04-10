/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author A16016287
 */
public class NodoGenerico<T> {
    private final T dato;
    private NodoGenerico<T> next;
    
    public NodoGenerico(T dato, NodoGenerico<T> next){
        this.dato = dato;
        this.next = next; 
    }
    
    public T getDato(){
        return this.dato;
    }
    
    public NodoGenerico<T> getNext(){
        return this.next;
    }
    
    public void setNext(NodoGenerico<T> next){
        this.next = next;
    }
    
    
    @Override
    public String toString(){
        return String.valueOf(dato) + " -> "; 
    }
}
