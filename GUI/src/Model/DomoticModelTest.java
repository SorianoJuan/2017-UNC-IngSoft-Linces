package Model;

import Controller.DomoticController;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by DAVID on 23/06/2017.
 */
public class DomoticModelTest {

    private DomoticModel model=new DomoticModel();
    private DomoticController controlador=new DomoticController(model);

   /* @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }*/

  /* @Test
    public void testGetTemperaturaSensor(){
        //se necesita que este funcionando el simulador
    }*/

    @Test
    public void test_setTemperaturaDeseada_maxima(){
        model.setTemperaturaDeseada(40);
        assertEquals(40,model.getTemperaturaDeseada());
    }

    @Test
    public void test_setTemperaturaDeseada_minima(){
        model.setTemperaturaDeseada(0);
        assertEquals(0,model.getTemperaturaDeseada());
    }

    //Este test debe fallar porque se intenta introducir un valor de temp invalido.
    @Test
    public void test_setTemperaturaDeseada_negativa(){

        model.setTemperaturaDeseada(-1);
        assertEquals(-1,model.getTemperaturaDeseada());
    }

    @Test
    public void test_getTemperaturaDeseada(){
        model.setTemperaturaDeseada(5);
        assertEquals(5, model.getTemperaturaDeseada());
    }

    //Este test debe fallar porque se intenta ingresar un valor de humedad no valido
    @Test
    public void test_setHumedadDeseada(){
        model.setHumedadDeseada(101);
        assertEquals(101,model.getHumedadDeseada());
    }

}