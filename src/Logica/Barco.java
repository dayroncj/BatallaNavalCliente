/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static Logica.Extensiones.CalcularRango;

/**
 *
 * @author CG
 */
public class Barco {

    public BarcoTipo tipo;
    public Orientacion orientacion;
    public Coordenada[] coordenadas;
    public boolean hundido;

    public Barco(BarcoTipo tipo, Coordenada inicial) {
        this.tipo = tipo;
        this.orientacion = Orientacion.Horizontal;
        //this.coordenadas = new Coordenada[tipo.getTamaño()];
       this.coordenadas = CalcularRango(this, inicial);
    }
    
    public void SetCoordenada(Coordenada coordenadas)
            {
            this.coordenadas = CalcularRango(this, coordenadas);
            }
    
    public Barco(BarcoTipo tipo, Orientacion orientacion) {
        this.tipo = tipo;
        this.orientacion = orientacion;
       
    }
     

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    public Coordenada[] getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada[] coordenadas) {
        this.coordenadas = coordenadas;
    }

    public boolean isHundido() {
        return hundido;
    }

    public void setHundido(boolean hundido) {
        this.hundido = hundido;
    }
    
     public boolean CoordenadaCoincide(short CoordenadaX, short CoordenadaY) {
        boolean coincide=false;
         if (coordenadas!=null) {
                for (Coordenada casillas: coordenadas ) {
            if (casillas!=null){
            coincide=casillas.EjeX==CoordenadaX && casillas.EjeY==CoordenadaY;
            }
            if (coincide) {
                break;
            }
        }
         }
     
        return coincide;
    }
}
