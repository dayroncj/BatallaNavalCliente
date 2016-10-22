/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Logica.Accion;
import Logica.Coordenada;
import static Logica.Extensiones.ComandoBase;
import static Logica.Extensiones.EsNuloOVacio;

/**
 *
 * @author CG
 */
public class Comando {

    public Accion Accion;
    public int Turno;
    public Coordenada Posicion;
    public boolean Exitoso;

    public boolean isExitoso() {
        return Exitoso;
    }

    public void setExitoso(boolean Exitoso) {
        this.Exitoso = Exitoso;
    }

    public Comando(Accion accion) {
        this.Accion = accion;
        this.Turno = -1;
    }

    public Comando(Accion accion, int turno) {
        this.Accion = accion;
        this.Turno = turno;
    }

    public Comando(Accion accion, int turno, Coordenada posicion) {
        this.Accion = accion;
        this.Turno = turno;
        this.Posicion = posicion;
    }

    public String ToString() {
        String comando = ComandoBase() + "," + this.Accion.getCodigo();

        if (this.Turno > -1) {
            comando = comando + "," + this.Turno;
        }

        if (this.Posicion != null && !EsNuloOVacio(this.Posicion.ToString())) {
            comando = comando + "," + this.Posicion.ToString();
        }

        return comando;
    }
}
