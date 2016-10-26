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

    private Mapa MiMapa;
    private Mapa MapaRival;
    private ServidorSocket servidor;
    private SistemaServer sistema;
    private VistaBatallaNaval ventana;

    public Mapa getMiMapa() {
        return MiMapa;
    }

    public void setMiMapa(Mapa MiMapa) {
        this.MiMapa = MiMapa;
    }

    public Mapa getMapaRival() {
        return MapaRival;
    }

    public void setMapaRival(Mapa MapaRival) {
        this.MapaRival = MapaRival;
    }

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
            MiMapa = new Mapa(getVentana().getjPanel1(), "Mi Mapa", (short) 0, getSistema());
            MapaRival = new Mapa(getVentana().getjPanel2(), "Rival", (short) 1, getSistema());
            MiMapa.Pintar();
            MapaRival.Pintar();
            getVentana().setSize(1000, 600);
            getVentana().setVisible(true);
            JOptionPane.showMessageDialog(null, "Seleccione sus barcos", "Mensaje de Inicio", JOptionPane.WARNING_MESSAGE);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Jugar() {
        try {
            getSistema().escuchar(this.MiMapa);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ServidorSocket getServidor() {
        if (servidor == null) {
            servidor = new ServidorSocket();
        }

        return servidor;
    }
}
