/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Barco;
import Logica.BarcoTipo;
import Logica.Coordenada;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author CG
 */
public class Controlador implements ActionListener {

    private final VistaBatallaNaval ventana;

    public Controlador(VistaBatallaNaval aThis) {
        ventana = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Coordenada coordenada = new Coordenada(e.getActionCommand().split(","));
        Barco nuevoBarco = new Barco(BarcoTipo.Submarino, coordenada);
        ventana.getModelo().getMiMapa().barcos_.add(nuevoBarco);
//        int CantidadBarcos = ventana.getModelo().GetBarcosEnBatalla().size();
//        
//        if (CantidadBarcos < 5) {
//            ventana.getModelo().AddBarcosEnBatalla(coordenadas);
//            ventana.getModelo().GetBarcosEnBatalla();
//            JButton miPosicion = (JButton) e.getSource();
//            miPosicion.setBackground(Color.yellow);
//            return;
//        }
        
        //this.Jugar();
        ventana.getModelo().Jugar();
    }
}
