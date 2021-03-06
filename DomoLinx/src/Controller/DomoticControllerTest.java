package Controller;

import Model.DomoticModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;

public class DomoticControllerTest {

    private DomoticModel model= DomoticModel.getInstance();
    private DomoticController controlador= new DomoticController(model);

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
    public void test_setearTemperatura(){
        model.setTemperaturaDeseada(40);
        assertEquals(40,model.getTemperaturaDeseada());
    }

    @Test
    public void testSetearTemperatura(){
        model.setTemperaturaDeseada(4);
        assertEquals(4, model.getTemperaturaDeseada());
    }



    @Test
    public void test_sanitizarHumedad_minima(){
        assertTrue(controlador.sanitizarHumedad(0));
    }

    @Test
    public void test_sanitizarHumedad_maxima(){
        assertTrue(controlador.sanitizarHumedad(100));
    }

    @Test
    public void test_sanitizarHumedad_invalida_negativa(){
        assertFalse(controlador.sanitizarHumedad(-1));
    }

    @Test
    public void test_sanitizarHumedad_invalida_excesiva(){
        assertFalse(controlador.sanitizarHumedad(101));
    }



    @Test
    public void testStanitizarHumedad(){

        assertEquals(false, controlador.sanitizarHumedad(-1));
    }

    @Test
    public void testStanitizarHumedad_valor_valido(){

        assertEquals(true, controlador.sanitizarHumedad(100));
    }

    @Test
    public void test_setearHumedad_valida(){
        controlador.setearHumedad(35);
        assertEquals(35,model.getHumedadDeseada());
    }

    @Test
    public void test_GenTxt(){
        controlador.generarTxt();
        try{Thread.sleep(1000);}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        File f = new File("EstadoActual.txt");
        assertTrue(f.exists());

        }
    }
