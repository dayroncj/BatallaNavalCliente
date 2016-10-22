/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static Logica.Extensiones.ComandoBase;

/**
 *
 * @author CG
 */
public class ComandoBase {
    
    public String aplicacion;
    public int año;
    public int mes;
    public int dia;
    public int hora;
    public int minuto;
    public int segundo;
    public Accion accion;
    public String resultado;

    public ComandoBase(String aplicacion, int año, int mes, int dia, int hora, int minuto, int segundo) {
        this.aplicacion = aplicacion;
        this.año = año;
        this.mes = mes;
        this.dia = dia;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    
    public String ToString() {
        String comando = this.accion.getCodigo() == null ? "" : this.accion.getCodigo();
        return String.format("%s,%s,%s", ComandoBase(), comando, this.resultado);
    }
    
}
