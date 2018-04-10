/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dmc-4
 */
public class ControlVistaCliente implements ActionListener {
    
    VistaCliente vistaCliente;
    
    public ControlVistaCliente(VistaCliente vistaCliente){
        this.vistaCliente = vistaCliente;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
        // APRIETAS ENVIAR MENSAJE**********************************************
        if(vistaCliente.getjButtonEnviar() == evento.getSource()){
            
        }
        
        // APRIETAS SOLICITAR MENSAJES******************************************
        if(vistaCliente.getjButtonSolicitar() == evento.getSource()){
            
        }        
    }
    
}
