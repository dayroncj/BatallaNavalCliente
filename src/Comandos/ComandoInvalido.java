/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Logica.Accion;

/**
 *
 * @author CG
 */
public class ComandoInvalido extends ComandoBase implements IComando {

    public ComandoInvalido() {
        this("BNAV", 2016, 9, 20, 22, 6, 28);
    }
    
    public ComandoInvalido(Accion accion) {
        this("BNAV", 2016, 9, 20, 22, 6, 28);
        this.accion = accion;
    }

    public ComandoInvalido(String aplicacion, int año, int mes, int dia, int hora, int minuto, int segundo) {
        super(aplicacion, año, mes, dia, hora, minuto, segundo);
        this.accion = Accion.Invalida;
    }

    @Override
    public String Procesar() {
        this.resultado = "NK,1";
        return this.ToString();
    }
}
