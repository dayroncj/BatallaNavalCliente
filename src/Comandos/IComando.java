/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comandos;

import Logica.Mapa;

/**
 *
 * @author CG
 */
public interface IComando {

    Mapa getMapa();
    
    void setMapa(Mapa mapa);
    
    String Procesar();

    String ToString();
}
