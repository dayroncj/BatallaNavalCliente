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
public class ComandoDIS extends ComandoBase implements IComando {

    public int turno;
    public Posicion posicion;

    protected ComandoDIS(String[] valores) {
        this(valores[0],
                Integer.parseInt(valores[1]),
                Integer.parseInt(valores[2]),
                Integer.parseInt(valores[3]),
                Integer.parseInt(valores[4]),
                Integer.parseInt(valores[5]),
                Integer.parseInt(valores[6]),
                Integer.parseInt(valores[8]),
                new Posicion(Integer.parseInt(valores[9]), Integer.parseInt(valores[10])));

    }

    protected ComandoDIS(String aplicacion, int año, int mes, int dia, int hora, int minuto, int segundo, int turno, Posicion posicion) {
        super(aplicacion, año, mes, dia, hora, minuto, segundo);

        if (turno < 0 || turno > 1) {
            throw new IllegalArgumentException("Turno debe ser 0 o 1!");
        }

        this.accion = Accion.Disparar;
        this.turno = turno;
        this.posicion = posicion;
    }

    @Override
    public String Procesar() {
        this.resultado = "OK";
        return this.ToString();
    }
}
