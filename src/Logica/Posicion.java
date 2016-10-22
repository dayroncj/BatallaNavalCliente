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
public class Posicion {

    public int X;
    public int Y;

    public Posicion(int x, int y) {
        if (x < 1 || x > 10) {
            throw new IllegalArgumentException("Posición X debe estar entre 1 y 10!");
        }
        
        if (y < 1 || y > 10) {
            throw new IllegalArgumentException("Posición Y debe estar entre 1 y 10!");
        }
        
        this.X = x;
        this.Y = y;
    }

    public String ToString() {
        String texto = "";

        if (this.X > 0) {
            texto = texto + this.X;
        }

        if (this.Y > 0) {
            texto = texto + "," + this.Y;
        }
        
        return texto;
    }
}
