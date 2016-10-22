/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CG
 */
public class ComandoDISTests extends BaseTests {

    @Test
    public void DISDebeSerExitosoConImpactoEnAgua() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS,1,1,1";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,OK,0"));
    }
    
    @Test
    public void DISDebeSerExitosoConImpactoEnBarco() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS,1,2,2";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,OK,1"));
    }
    
    @Test
    public void DISDebeSerExitosoConFinDeJuego() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS,1,3,3";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,OK,2"));
    }

    @Test
    public void DISDebeFallarSiNoEsTurno() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS,0,4,4";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,NK,0"));
    }
    
    @Test
    public void DISDebeFallarSinParametros() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,NK,1"));
    }

    @Test
    public void DISDebeFallarConTurnoInvalido() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS,3,1,1";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,NK,1"));
    }
    
    @Test
    public void DISDebeFallarConTurnoVacio() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS,,1,1";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,NK,1"));
    }
    
    @Test
    public void DISDebeFallarConXInvalido() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS,1,0,1";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,NK,1"));
    }

    @Test
    public void DISDebeFallarConXVacio() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS,1,,1";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,NK,1"));
    }
    
    @Test
    public void DISDebeFallarConYInvalido() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS,1,1,0";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,NK,1"));
    }
    
    @Test
    public void DISDebeFallarConYVacio() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS,1,1,";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,NK,1"));
    }
    
    @Test
    public void DISDebeFallarConJugadaYaRealizada() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,DIS,1,5,5";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("DIS,NK,3"));
    }
}
