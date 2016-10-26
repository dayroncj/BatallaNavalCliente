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
public enum BarcoTipo {

    Acorazado((byte) 1),
    Crucero((byte) 2),
    Destructor((byte) 3),
    Submarino((byte) 4);

    private final byte Codigo;

    BarcoTipo(byte codigo) {
        this.Codigo = codigo;
    }

    public byte getCodigo() {
        return Codigo;
    }

    public byte getTamaño() {
        switch (getCodigo()) {
            case 1:
                return 4;
            case 2:
                return 3;
            case 3:
                return 2;
            case 4:
                return 1;
            default:
                return 0;
        }
    }
}
