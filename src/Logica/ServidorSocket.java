/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author CG
 */
public class ServidorSocket {

    private ServerSocket servidor;
    private Socket cliente;
    private boolean escuchando;
    private boolean hayClienteConectado;
    private String clienteConectado;

    public ServidorSocket() {
        escuchando = true;
        hayClienteConectado = false;
    }

    public void Escuchar() throws Exception {
        servidor = new ServerSocket(9000);

        while (escuchando) {
            cliente = servidor.accept();
            hayClienteConectado = true;

            try {
                FlujoCliente clienteNuevo = new FlujoCliente(cliente);
                clienteNuevo.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
