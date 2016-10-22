/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package batallanaval;

import Presentacion.Modelo;

/**
 *
 * @author CG
 */
public class BatallaNaval {

    private final Modelo aplicacion;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new BatallaNaval();
    }

    public BatallaNaval() {
        aplicacion = new Modelo();
        aplicacion.iniciar();
    }
}
