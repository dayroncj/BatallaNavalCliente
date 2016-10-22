
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author CG
 */
public class ComandoTURTests extends BaseTests {

    @Test
    public void TURDebeSerExitosoConParametros() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,TUR,1";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("TUR,OK"));
    }
    
    @Test
    public void TURDebeFallarSinParametros() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,TUR";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("TUR,NK,1"));
    }
    
    @Test
    public void TURDebeFallarConParametroInvalido() throws IOException {
        String mensaje = "BNAV,2016,9,20,22,6,28,TUR,3";
        assertEquals(true, this.ObtenerRespuesta(mensaje).trim().endsWith("TUR,NK,1"));
    }
}
