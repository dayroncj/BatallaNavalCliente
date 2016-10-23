/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Comandos.IComando;
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

    private final Mapa mapa;
    private final DataInputStream datosEntrada;
    private final DataOutputStream datosSalida;
    private final Socket cliente;

    public FlujoCliente(Mapa mapa, Socket cliente) throws IOException {
        this.mapa = mapa;
        this.cliente = cliente;
        datosEntrada = new DataInputStream(cliente.getInputStream());
        datosSalida = new DataOutputStream(cliente.getOutputStream());
    }

    @Override
    public void run() {
        System.out.println(String.join("-", Collections.nCopies(23, "-")));
        byte buffer[];
        buffer = new byte[512];

        try {
            datosEntrada.read(buffer);
            System.out.println("El cliente dice: " + new String(buffer));

            IComando comando = ObtenerComando(new String(buffer));
            comando.setMapa(mapa);
            String respuesta = comando.Procesar();
            datosSalida.write(respuesta.getBytes());
            System.out.println("El servidor dijo: " + respuesta);

            datosSalida.close();
            datosEntrada.close();
            //cliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
