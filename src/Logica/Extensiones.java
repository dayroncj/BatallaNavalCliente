/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Comandos.ComandoPNOM;
import Comandos.ComandoLIS;
import Comandos.ComandoTUR;
import Comandos.ComandoDIS;
import Comandos.ComandoInvalido;
import Comandos.IComando;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author CG
 */
public class Extensiones {

    public static final Map<String, Accion> lookup = new HashMap<>();

    public static boolean EsNuloOVacio(String param) {
        return param == null || param.trim().length() == 0;
    }

    public static String ComandoBase() {
        Date date = new Date();
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);

        return String.format("BNAV,%d,%d,%d,%d,%d,%d",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
    }

    public static IComando ObtenerComando(String textoComando) {
        String[] valores = textoComando.trim().split(",");
        Accion accion = findEnumValue(valores[7]);
        IComando comando;
        comando = new ComandoInvalido(accion);

        try {
            switch (accion) {
                case CambiarTurno:
                    if (valores.length == 9) {
                        comando = new ComandoTUR(valores);
                    }
                    break;

                case DecirNombre:
                    if (valores.length == 8) {
                        comando = new ComandoPNOM(valores);
                    }
                    break;

                case Disparar:
                    if (valores.length == 11) {
                        comando = new ComandoDIS(valores);
                    }
                    break;

                case Listo:
                    if (valores.length == 9) {
                        comando = new ComandoLIS(valores);
                    }
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Excepción: " + ex.getMessage());
            comando = new ComandoInvalido(accion);
        }

        return comando;
    }

    public <E extends Enum<E>> boolean EstaEnEnumeracion(String valor, Class<Accion> accion) {
        for (Accion e : accion.getEnumConstants()) {
            if (e.name().equals(valor)) {
                return true;
            }
        }

        return false;
    }

    public static Accion findEnumValue(String codigo) {
        for (Accion accion : Accion.values()) {
            String cod = accion.getCodigo();

            if (cod.equals(codigo.trim())) {
                return accion;
            }
        }

        return Accion.Invalida;
    }

    public static Coordenada[] CalcularRango(Barco barco, Coordenada inicial) {
        byte cantidad = barco.tipo.getTamaño();
        Coordenada[] coordenadas = new Coordenada[cantidad];
        coordenadas[0] = inicial;

        if (barco.orientacion == Orientacion.Horizontal) {
            for (int i = 1; i < cantidad; i++) {
                coordenadas[i] = new Coordenada(inicial.EjeX + i, inicial.EjeY);
            }
        }

        if (barco.orientacion == Orientacion.Vertical) {
            for (int i = 1; i < cantidad; i++) {
                coordenadas[i] = new Coordenada(inicial.EjeX, inicial.EjeY + i);
            }
        }

        return coordenadas;
    }
}
