/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.ServidorSocket;

/**
 *
 * @author CG
 */
public class Modelo {

    private ServidorSocket servidor;

    public void iniciar() {
        try {
            getServidor().Escuchar();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ServidorSocket getServidor() {
        if (servidor == null) {
            servidor = new ServidorSocket();
        }

        return servidor;
    }
}
