/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Controlador.ControlVistaCliente;
import Vista.VistaCliente;

/**
 *
 * @author dmc-4
 */
public class MainCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        VistaCliente vistaCliente = new VistaCliente();
        vistaCliente.setVisible(true);
        ControlVistaCliente control = new ControlVistaCliente(vistaCliente);
    }
    
}