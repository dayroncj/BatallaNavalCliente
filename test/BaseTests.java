
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author CG
 */
public class BaseTests {

    protected byte buffer[];
    protected Socket host;
    protected DataOutputStream datosSalida;
    protected DataInputStream datosEntrada;

    @BeforeClass
    public static void setUpClass() throws IOException {

    }

    @Before
    public void setUp() throws IOException {
        this.Conectar();
    }

    @After
    public void tearDown() throws IOException {
        this.datosSalida.close();
        this.datosEntrada.close();
        host.close();
    }

    @AfterClass
    public static void tearDownClass() throws IOException {

    }

    protected void Conectar() throws IOException {
        buffer = new byte[512];
        host = new Socket("localhost", 9000);

        datosSalida = new DataOutputStream(host.getOutputStream());
        datosEntrada = new DataInputStream(host.getInputStream());
    }

    protected String ObtenerRespuesta(String mensaje) throws IOException {
        this.datosSalida.write(mensaje.getBytes());
        this.datosEntrada.read(this.buffer);
        return new String(this.buffer);
    }
}
