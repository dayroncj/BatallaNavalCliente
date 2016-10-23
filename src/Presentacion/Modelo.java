/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Mapa;
import Logica.ServidorSocket;
import javax.swing.JOptionPane;
import Logica.SistemaServer;

/**
 *
 * @author CG
 */
public class Modelo {

    public Mapa mapa;
    private ServidorSocket servidor;
    private VistaBatallaNaval ventana;
    private SistemaServer sistema;

    public VistaBatallaNaval getVentana() {
        if (ventana == null) {
            ventana = new VistaBatallaNaval(this);
        }
        return ventana;
    }
    
     public SistemaServer getSistema() {
        if (sistema == null) {
            sistema = new SistemaServer();
        }
        return sistema;
    }

    public void iniciar() {
        try {
            Mapa MisBarcos = new Mapa((short) 10, (short) 10, getVentana().getjPanel1(), (short) 30, "Mi Mapa", (short) 0, getSistema());
            Mapa BarcosEnemigos = new Mapa((short) 10, (short) 10, getVentana().getjPanel2(), (short) 30, "Rival", (short) 1, getSistema());
            MisBarcos.PintarMapa();
            BarcosEnemigos.PintarMapa();
            JOptionPane.showMessageDialog(null, "Seleccione sus barcos", "Mensaje de Inicio", JOptionPane.WARNING_MESSAGE);
            getVentana().setSize(1000, 600);
            getVentana().setVisible(true);
           } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Mapa getMapa() {
        if (mapa == null) {
            mapa = new Mapa();
        }

        return mapa;
    }

    public ServidorSocket getServidor() {
        if (servidor == null) {
            servidor = new ServidorSocket();
        }

        return servidor;
    }
}
