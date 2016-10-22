/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static Logica.Extensiones.ComandoBase;

/**
 *
 * @author CG
 */
public class ComandoPNOM extends ComandoBase implements IComando {

    protected ComandoPNOM(String[] valores) {
        super(valores[0],
                Integer.parseInt(valores[1]),
                Integer.parseInt(valores[2]),
                Integer.parseInt(valores[3]),
                Integer.parseInt(valores[4]),
                Integer.parseInt(valores[5]),
                Integer.parseInt(valores[6]));

        this.accion = Accion.DecirNombre;
    }

    protected ComandoPNOM(String aplicacion, int año, int mes, int dia, int hora, int minuto, int segundo) {
        super(aplicacion, año, mes, dia, hora, minuto, segundo);
        this.accion = Accion.DecirNombre;
    }

    @Override
    public String Procesar() {
        this.resultado = "OK,Grupo CRD";
        return this.ToString();
    }
}
