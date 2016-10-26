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
public enum Orientacion {

    Horizontal((byte) 1),
    Vertical((byte)2);

    private final byte Valor;

    private Orientacion(byte valor) {
        this.Valor = valor;
    }

    public byte getValor() {
        return this.Valor;
    }
}
