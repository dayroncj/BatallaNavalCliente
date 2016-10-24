/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Comandos.Comando;
import Comandos.IComando;
import static Logica.Extensiones.ComandoBase;
import static Logica.Extensiones.ObtenerComando;
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
    private Mapa MisBarcos;
    private JButton[][] BarcosEnemigos;
    

    public Mapa getMisBarcos() {
        return MisBarcos;
    }

    public void setMisBarcos(Mapa MisBarcos) {
        this.MisBarcos = MisBarcos;
    }

    public JButton[][] getBarcosEnemigos() {
        return BarcosEnemigos;
    }

    public void setBarcosEnemigos(JButton[][] BarcosEnemigos) {
        this.BarcosEnemigos = BarcosEnemigos;
    }
 

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }


    public boolean isEsperandoRespuesta() {
        return esperandoRespuesta;
    }

    public void EnviarMensaje(String Mensaje,JButton boton, Coordenada coordenada ) throws Exception {

        this.boton=boton;
       Comando comando=new Comando(Accion.Disparar, 0, coordenada);
        datosSalida.write(comando.ToString().getBytes());

    }
    
      public void EnviarMensaje(String Mensaje ) throws Exception {

     String comando=ComandoBase()+Mensaje;
        datosSalida.write(comando.getBytes());

    }

    public void LeerMensaje() throws Exception {
        byte buffer[];
        buffer = new byte[512];
        datosEntrada.read(buffer);
       
        String respuesta = new String(buffer).trim();

        if (respuesta.contains("OK,1")) {
            turno=true;
            boton.setBackground(Color.green);
        } else if (respuesta.contains("OK,0")) {
            turno=false;
            boton.setBackground(Color.blue);

        } else {
            IComando comando = ObtenerComando(new String(buffer));
            if (comando instanceof Comandos.ComandoDIS) {

                if (MisBarcos.ExisteCoordenadaBarcos((short) ((Comandos.ComandoDIS) comando).coordenada.EjeX, (short) ((Comandos.ComandoDIS) comando).coordenada.EjeY)) {
                    MisBarcos.getMapa()[(short) ((Comandos.ComandoDIS) comando).coordenada.EjeX][(short) ((Comandos.ComandoDIS) comando).coordenada.EjeY].setBackground(Color.green);
                    turno=false;
                    EnviarMensaje(",OK,1");

                } else {
                    MisBarcos.getMapa()[(short) ((Comandos.ComandoDIS) comando).coordenada.EjeX][(short) ((Comandos.ComandoDIS) comando).coordenada.EjeY].setBackground(Color.blue);
                  turno=true;
                    EnviarMensaje(",OK,0");
                }

            }
        }
        

    }

    public void escuchar(Mapa mapa) throws Exception {
        //crear el servidor
        this.MisBarcos=mapa;
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
