/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import static Logica.Extensiones.ObtenerComando;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Collections;

/**
 *
 * @author CG
 */
public class FlujoCliente extends Thread {

    private final DataInputStream datosEntrada;
    private final DataOutputStream datosSalida;
    private final Socket cliente;

    public FlujoCliente(Socket cliente) throws IOException {
        this.cliente = cliente;
        datosEntrada = new DataInputStream(cliente.getInputStream());
        datosSalida = new DataOutputStream(cliente.getOutputStream());
    }

    public void run() {
        System.out.println(String.join("-", Collections.nCopies(23, "-")));
        byte buffer[];
        buffer = new byte[512];

        try {
            datosEntrada.read(buffer);
            System.out.println("El cliente dice: " + new String(buffer));
            
            IComando comando = ObtenerComando(new String(buffer));
            String respuesta = comando.Procesar();
            datosSalida.write(respuesta.getBytes());
            System.out.println("El servidor dijo: " + respuesta);
            
            //datosSalida.write("Hola oponente".getBytes());
            /*Comando cmd = new Comando(Accion.DecirNombre);
            datosSalida.write(cmd.ToString().getBytes());

            Comando cmd2 = new Comando(Accion.CambiarTurno, 1);
            datosSalida.write(cmd2.ToString().getBytes());

            Posicion pos = new Posicion(5, 8);
            Comando cmd3 = new Comando(Accion.Disparar, 1, pos);
            datosSalida.write(cmd3.ToString().getBytes());
*/
            datosSalida.close();
            datosEntrada.close();
            //cliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
