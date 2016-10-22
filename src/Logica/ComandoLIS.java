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
public class ComandoLIS extends ComandoBase implements IComando {

    public int turno;

    protected ComandoLIS(String[] valores) {
        this(valores[0],
                Integer.parseInt(valores[1]),
                Integer.parseInt(valores[2]),
                Integer.parseInt(valores[3]),
                Integer.parseInt(valores[4]),
                Integer.parseInt(valores[5]),
                Integer.parseInt(valores[6]),
                Integer.parseInt(valores[8]));
    }

    protected ComandoLIS(String aplicacion, int año, int mes, int dia, int hora, int minuto, int segundo, int turno) {
        super(aplicacion, año, mes, dia, hora, minuto, segundo);

        if (turno < 0 || turno > 1) {
            throw new IllegalArgumentException("Turno debe ser 0 o 1!");
        }

        this.accion = Accion.Listo;
        this.turno = turno;
    }

    @Override
    public String Procesar() {
        this.resultado = "OK";
        return this.ToString();
    }
}
