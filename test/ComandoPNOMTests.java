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
public class ComandoPNOMTests extends BaseTests {
    @Test
    public void PNOMDebeSerExitosoSinParametros() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,27,PNOM";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim()
                .endsWith("PNOM,OK,Grupo CRD"));
    }
}
