/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author CG
 */
public class ComandoInvalidoTests extends BaseTests {

    @Test
    public void ComandoDebeFallarSiComandoNoExiste() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,27,XXX";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("NK,1"));
    }
}
