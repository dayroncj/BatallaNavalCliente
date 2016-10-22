/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author CG
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ComandoDISTests.class, ComandoInvalidoTests.class, ComandoLISTests.class, ComandoPNOMTests.class, ComandoTURTests.class})
public class BatallaNavalTestsSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
}
