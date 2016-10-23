/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JButton;

public class SistemaServer extends Thread {

    private ServerSocket servidor;
    private Socket cliente;
    private DataInputStream datosEntrada;
    private DataOutputStream datosSalida;
    private boolean esperandoRespuesta = true;
    private JButton boton;
    private boolean turno=true;

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    private String rango;

    public boolean isEsperandoRespuesta() {
        return esperandoRespuesta;
    }

    public void EnviarMensaje(String Mensaje,JButton boton, String rango ) throws Exception {

        this.boton=boton;
        this.rango=rango;
        datosSalida.write(Mensaje.getBytes());

    }
    
      public void EnviarMensaje(String Mensaje ) throws Exception {

        datosSalida.write(Mensaje.getBytes());

    }

    public void LeerMensaje() throws Exception {
        byte buffer[];
        buffer = new byte[512];
        datosEntrada.read(buffer);
        String respuesta = new String(buffer).trim();
        if (respuesta.equals("OK,1")) {
            boton.setBackground(Color.green);
            //EnviarMensaje("El Servidor responde");
        } else {
            boton.setBackground(Color.blue);
            System.out.println(respuesta);
        }

    }

    public void escuchar() throws Exception {
        //crear el servidor
        servidor = new ServerSocket(9000);
        //espera a que alguien se conecte
        cliente = servidor.accept();//1
        datosEntrada = new DataInputStream(cliente.getInputStream());
        datosSalida = new DataOutputStream(cliente.getOutputStream());
        // LeerMensaje();

    }

    public void run() {

        try {
            while (isEsperandoRespuesta()) {

                LeerMensaje();
            }
        } //catch (IOException ex) {
        //            ex.printStackTrace();
        //        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
