/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CG
 */
public class Mapa {

    public Barco[] barcos;
    public List<Coordenada> coordenadasImpactadas = new ArrayList<>();

    public Mapa() {
        this.barcos = new Barco[10];
    }

    public Barco[] getBarcos() {
        return barcos;
    }

    public List<Coordenada> getCoordenadasImpactadas() {
        return coordenadasImpactadas;
    }

    public void setBarcos(Barco[] barcos) {
        this.barcos = barcos;
    }

    public void CargarBarcos() {
        Barco[] barcos = new Barco[10];
        barcos[0] = new Barco(BarcoTipo.Acorazado, new Coordenada(1, 1));
        barcos[1] = new Barco(BarcoTipo.Crucero, new Coordenada(1, 2));
        barcos[2] = new Barco(BarcoTipo.Crucero, new Coordenada(1, 3));
        barcos[3] = new Barco(BarcoTipo.Destructor, new Coordenada(1, 4));
        barcos[4] = new Barco(BarcoTipo.Destructor, new Coordenada(1, 5));
        barcos[5] = new Barco(BarcoTipo.Destructor, new Coordenada(1, 6));
        barcos[6] = new Barco(BarcoTipo.Submarino, new Coordenada(1, 7));
        barcos[7] = new Barco(BarcoTipo.Submarino, new Coordenada(1, 8));
        barcos[8] = new Barco(BarcoTipo.Submarino, new Coordenada(1, 9));
        barcos[9] = new Barco(BarcoTipo.Submarino, new Coordenada(1, 10));

        coordenadasImpactadas.add(new Coordenada(5, 5));

        setBarcos(barcos);
    }
}
