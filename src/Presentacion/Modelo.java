/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Mapa;
import Logica.ServidorSocket;

/**
 *
 * @author CG
 */
public class Modelo {

    public Mapa mapa;
    private ServidorSocket servidor;

    public void iniciar() {
        try {
            getMapa().CargarBarcos();
            getServidor().Escuchar(mapa);
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
