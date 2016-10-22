/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author CG
 */
public enum Accion {
    CambiarTurno("TUR"),
    DecirNombre("PNOM"),
    Disparar("DIS"),
    Invalida(""),
    Listo("LIS");

    private final String Codigo;

    Accion(String codigo) {
        this.Codigo = codigo;
    }
    
    public String getCodigo() {
        return Codigo;
    }
}
