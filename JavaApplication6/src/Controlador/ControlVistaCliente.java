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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dmc-4
 */
public class ControlVistaCliente implements ActionListener {
    
    ArrayList<String> mensajesEnviados = new ArrayList<String>();
    VistaCliente vistaCliente;
    
    public ControlVistaCliente(VistaCliente vistaCliente){
        this.vistaCliente = vistaCliente;
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        
        // APRIETAS ENVIAR MENSAJE**********************************************
        if(vistaCliente.getjButtonEnviar() == evento.getSource()){
            TCP_Cliente cliente = new TCP_Cliente();
            mensajesEnviados.add(vistaCliente.getjTextFieldMensaje().getText());
            try {
                cliente.enviarMensaje(vistaCliente.getjTextFieldMensaje().getText());
            } catch (IOException ex) {
                Logger.getLogger(ControlVistaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // APRIETAS SOLICITAR MENSAJES******************************************
        if(vistaCliente.getjButtonSolicitar() == evento.getSource()){
            for (int i = 0; i < mensajesEnviados.size(); i++) {
                vistaCliente.getjTextAreaMensajesEnviados().setText(mensajesEnviados.get(i));
            }
        }        
    }
    
}
