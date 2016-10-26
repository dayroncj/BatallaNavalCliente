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
public class Coordenada {

    public int EjeX;
    public int EjeY;
    public boolean Impacto;

    public boolean isImpacto() {
        return Impacto;
    }

    public void setImpacto(boolean Impacto) {
        this.Impacto = Impacto;
    }

    public Coordenada(String[] valores) {
        this(Integer.parseInt(valores[0]), Integer.parseInt(valores[1]));
    }

    /**
     *
     * @param x
     * @param y
     */
    public Coordenada(int x, int y) {
        if (x < 0 || x > 10) {
            throw new IllegalArgumentException("Posición X debe estar entre 1 y 10!");
        }

        if (y < 0 || y > 10) {
            throw new IllegalArgumentException("Posición Y debe estar entre 1 y 10!");
        }

        this.EjeX = x;
        this.EjeY = y;
    }

    public String ToString() {
        String texto = "";

        if (this.EjeX > 0) {
            texto = texto + this.EjeX;
        }

        if (this.EjeY > 0) {
            texto = texto + "," + this.EjeY;
        }

        return texto;
    }

    @Override
    public boolean equals(Object otra) {
        boolean equal = false;

        if (otra != null && otra instanceof Coordenada) {
            equal = (this.EjeX == ((Coordenada) otra).EjeX
                    && this.EjeY == ((Coordenada) otra).EjeY);
        }

        return equal;
    }
}
