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
public class ComandoLISTests extends BaseTests {

    @Test
    public void LISDebeSerExitosoConParametros() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,LIS,1";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("LIS,OK"));
    }
    
    @Test
    public void LISDebeFallarSinParametros() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,LIS";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("LIS,NK,1"));
    }
    
    @Test
    public void LISDebeFallarConParametroInvalido() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,LIS,3";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("LIS,NK,1"));
    }
}
