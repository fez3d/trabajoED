/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.VistaCliente;
import domain.TCP_Cliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            TCP_Cliente cliente = new TCP_Cliente();
            try {
                cliente.enviarMensaje(vistaCliente.getjTextAreaMensaje().getText());
            } catch (IOException ex) {
                Logger.getLogger(ControlVistaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // APRIETAS SOLICITAR MENSAJES******************************************
        if(vistaCliente.getjButtonSolicitar() == evento.getSource()){
            
        }        
    }
    
}
