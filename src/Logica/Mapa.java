/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Presentacion.VistaBatallaNaval;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CG
 */
public class Mapa {

    public Barco[] barcos;
    public HashSet<Barco> barcos_;
    public List<Coordenada> coordenadasImpactadas = new ArrayList<>();
    private JButton[][] mapa;

    public JButton[][] getMapa() {
        return mapa;
    }
    private short jugador;
    private SistemaServer sistema;
    private JPanel panel;
    private JLabel nombre;
    private byte tamano = 10;
    private byte tamanoTotal = 30;

    public Mapa() {
        this.barcos = new Barco[10];
    }

    public Mapa(JPanel panel, String nombre, short jugador, SistemaServer sistema) {
        this.panel = panel;
        this.nombre = new JLabel(nombre);
        this.jugador = jugador;
        this.sistema = sistema;
    }

    public Barco[] getBarcos() {
        return barcos;
    }

    public List<Coordenada> getCoordenadasImpactadas() {
        return coordenadasImpactadas;
    }

    public void setBarcos(Barco[] barcos) {
        this.barcos = barcos;
    }

    public void CargarBarcos() {
        Barco[] barcos = new Barco[10];
        barcos[0] = new Barco(BarcoTipo.Acorazado, new Coordenada(1, 1));
        barcos[1] = new Barco(BarcoTipo.Crucero, new Coordenada(1, 2));
        barcos[2] = new Barco(BarcoTipo.Crucero, new Coordenada(1, 3));
        barcos[3] = new Barco(BarcoTipo.Destructor, new Coordenada(1, 4));
        barcos[4] = new Barco(BarcoTipo.Destructor, new Coordenada(1, 5));
        barcos[5] = new Barco(BarcoTipo.Destructor, new Coordenada(1, 6));
        barcos[6] = new Barco(BarcoTipo.Submarino, new Coordenada(1, 7));
        barcos[7] = new Barco(BarcoTipo.Submarino, new Coordenada(1, 8));
        barcos[8] = new Barco(BarcoTipo.Submarino, new Coordenada(1, 9));
        barcos[9] = new Barco(BarcoTipo.Submarino, new Coordenada(1, 10));

        coordenadasImpactadas.add(new Coordenada(5, 5));

        setBarcos(barcos);
    }

    public void IniciarBarcos() {
        Barco[] barcos = new Barco[10];
        barcos[0] = new Barco(BarcoTipo.Acorazado, Orientacion.Horizontal);
        barcos[1] = new Barco(BarcoTipo.Crucero, Orientacion.Horizontal);
        barcos[2] = new Barco(BarcoTipo.Crucero, Orientacion.Vertical);
        barcos[3] = new Barco(BarcoTipo.Destructor, Orientacion.Horizontal);
        barcos[4] = new Barco(BarcoTipo.Destructor, Orientacion.Vertical);
        barcos[5] = new Barco(BarcoTipo.Destructor, Orientacion.Horizontal);
        barcos[6] = new Barco(BarcoTipo.Submarino, Orientacion.Horizontal);
        barcos[7] = new Barco(BarcoTipo.Submarino, Orientacion.Horizontal);
        barcos[8] = new Barco(BarcoTipo.Submarino, Orientacion.Horizontal);
        barcos[9] = new Barco(BarcoTipo.Submarino, Orientacion.Horizontal);

        coordenadasImpactadas.add(new Coordenada(5, 5));

        setBarcos(barcos);
    }

    public void Pintar() {
        IniciarBarcos();
        mapa = new JButton[this.tamano][this.tamano];

        for (int i = 0; i < this.tamano; i++) {
            for (int j = 0; j < this.tamano; j++) {
                mapa[i][j] = new JButton();
                mapa[i][j].setName(i + "," + j);
                mapa[i][j].setActionCommand(i + "," + j);

                mapa[i][j].addActionListener((new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        String[] coordenadas = event.getActionCommand().toString().split(",");
                        
                        if (jugador == 0) {
                            EnviarCoordenadasBarcos(coordenadas);
                        } else if (jugador == 1) {
                            try {
                                if (sistema.isTurno()) {
                                    sistema.setTurno(false);
                                    sistema.setBarcosEnemigos(mapa);
                                    sistema.EnviarMensaje(event.getActionCommand(), mapa[Integer.parseInt(coordenadas[0])][Integer.parseInt(coordenadas[1])], new Coordenada(Integer.parseInt(coordenadas[0]), Integer.parseInt(coordenadas[1])));
                                } else {
                                    JOptionPane.showMessageDialog(null, "Por Favor espere su turno", "Mensaje", JOptionPane.WARNING_MESSAGE);
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }));

                mapa[i][j].setLocation(i * this.tamanoTotal, j * this.tamanoTotal);
                mapa[i][j].setSize(this.tamanoTotal, this.tamanoTotal);
                panel.add(mapa[i][j]);
                panel.validate();
            }
        }

        nombre.setSize(500, 500);
        nombre.setLocation(mapa.length * this.tamanoTotal / 2, mapa.length * this.tamanoTotal);
        nombre.setSize(nombre.getPreferredSize());
        panel.add(nombre);
        panel.validate();
    }

    public void EnviarCoordenadasBarcos(String[] coordenadas) {
        for (Barco barco : barcos) {
            if (barco.coordenadas == null) {
                if (!ExisteCoordenadaBarcos(Short.parseShort(coordenadas[0]), Short.parseShort(coordenadas[1]), barco.tipo.getTamaño(), barco.orientacion)) {
                    if ((barco.getOrientacion() == Orientacion.Horizontal && Short.parseShort(coordenadas[0]) + barco.tipo.getTamaño() - 1 < this.tamano) || (barco.getOrientacion() == Orientacion.Vertical && Short.parseShort(coordenadas[1]) + barco.tipo.getTamaño() - 1 < this.tamano)) {
                        int i = 0;

                        if (barco.getOrientacion() == Orientacion.Horizontal) {

                            if (barco.coordenadas == null) {
                                barco.coordenadas = new Coordenada[barco.tipo.getTamaño()];
                            }

                            while (i < barco.tipo.getTamaño()) {
                                Coordenada cor = new Coordenada((short) (Short.parseShort(coordenadas[0]) + i), Short.parseShort(coordenadas[1]));

                                barco.coordenadas[i] = cor;
                                mapa[Short.parseShort(coordenadas[0]) + i][Short.parseShort(coordenadas[1])].setBackground(Color.yellow);
                                i++;
                            }
                        } else {
                            if (barco.coordenadas == null) {
                                barco.coordenadas = new Coordenada[barco.tipo.getTamaño()];
                            }
                            while (i < barco.tipo.getTamaño()) {
                                Coordenada cor = new Coordenada(Short.parseShort(coordenadas[0]), (short) (Short.parseShort(coordenadas[1]) + i));
                                barco.coordenadas[i] = cor;
                                mapa[Short.parseShort(coordenadas[0])][Short.parseShort(coordenadas[1]) + i].setBackground(Color.yellow);
                                i++;
                            }
                        }

                        break;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                System.out.println("No vacio");
                // break;
            }
        }

        if (IsBarcosListos()) {
            try {
                JOptionPane.showMessageDialog(null, "Buscando rival...", "Mensaje de Inicio", JOptionPane.WARNING_MESSAGE);
                sistema.escuchar(this);
                sistema.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public boolean ExisteCoordenadaBarcos(short CoordenadaX, short CoordenadaY) {
        boolean existe = false;
        for (Barco barco : barcos) {
            if (barco.CoordenadaCoincide(CoordenadaX, CoordenadaY)) {
                existe = true;
                break;
            }
        }
        return existe;
    }

    public boolean ExisteCoordenadaBarcos(short CoordenadaX, short CoordenadaY, short TamanoBarco, Orientacion TipoAlineacion) {
        boolean existe = false;

        int i = 0;
        if (TipoAlineacion == Orientacion.Horizontal) {
            while (i < TamanoBarco) {
                for (Barco barco : barcos) {
                    if (barco.CoordenadaCoincide((short) (CoordenadaX + i), CoordenadaY)) {
                        existe = true;
                        i = TamanoBarco;
                        break;
                    }

                }
                i++;

            }
        } else {
            if (TipoAlineacion == Orientacion.Vertical) {
                while (i < TamanoBarco) {
                    for (Barco barco : barcos) {
                        if (barco.CoordenadaCoincide(CoordenadaX, (short) (CoordenadaY + i))) {
                            existe = true;
                            i = TamanoBarco;
                            break;
                        }

                    }
                    i++;

                }
            }
        }

        return existe;

    }

    public boolean IsBarcosListos() {
        return barcos[barcos.length - 1].coordenadas != null;
    }

}
