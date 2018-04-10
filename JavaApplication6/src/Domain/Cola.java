package Domain;

import Domain.NodoGenerico;
import java.util.NoSuchElementException;

/**
 *
 * @author A14014852
 */
public class Cola <T>{
    private int size;
    private NodoGenerico nFrente;
    private NodoGenerico nFinal;
    
    public Cola(){
        this.nFrente = null;
        this.nFinal = null;
        this.size = 0;
    }
    
    public boolean empty(){
        return (nFrente == null);
    }

    public int getSize() {
        return size;
    }
    
    public void enqueue(T valor){
        
        NodoGenerico<T> ultimo = this.nFinal;
        NodoGenerico<T> nodo = new NodoGenerico<>(valor, null);
        this.nFinal = nodo;
        
        if(empty()){
            this.nFrente = this.nFinal;
        }else{
            ultimo.setNext(nodo);
        }
        
        size++;
    }
    
    public T dequeue(){
        if(empty()){
            throw new NoSuchElementException("No hay elementos en la cola");
        }
        NodoGenerico<T> primero = this.nFrente;
        this.nFrente = primero.getNext();
        size--;
        
        if(empty()){
            this.nFinal = null;
        }
        
        return primero.getDato();
    }
}