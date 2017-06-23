package Controller;

import Model.DomoticModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by DAVID on 22/06/2017.
 */
public class DomoticControllerTest {

    DomoticModel model= new DomoticModel();
    DomoticController controlador= new DomoticController(model);

    /*
    @Before
    public void setUp() throws Exception {
        DomoticModel model= new DomoticModel();
        DomoticController controlador= new DomoticController(model);
    }

    @After
    public void tearDown() throws Exception {
        controlador = null;
        model = null;
    }
*/

    @Test
    public void testSanitizarTemperatura(){
        int T=0;
        assertTrue(controlador.sanitizarTemperatura(T));
    }

    @Test
    public void testSanitizarTemperatura_TempBaja(){
        int T=-20;
        assertFalse(controlador.sanitizarTemperatura(T));
    }

    @Test
    public void testSanitizarTemperatura_TempMuyAlta(){
        int T=45;
        assertFalse(controlador.sanitizarTemperatura(T));
    }

    @Test
    public void testSetearTemperatura(){
        model.setTemperaturaDeseada(4);
        assertEquals(4, model.getTemperaturaDeseada());
    }

    //Esto deberia fallar porque la humedad no puede ser negativa
    @Test
    public void testSetearHumedad() {
        model.setHumedadDeseada(-10);
        assertEquals(-10, model.getHumedadDeseada());
    }

    @Test
    public void testStanitizarHumedad(){

        assertEquals(false, controlador.sanitizarHumedad(-1));
    }

    @Test
    public void testStanitizarHumedad_valor_valido(){

        assertEquals(true, controlador.sanitizarHumedad(100));
    }


}