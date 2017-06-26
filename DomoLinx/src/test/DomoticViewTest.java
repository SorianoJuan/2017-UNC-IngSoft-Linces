package test;

import Controller.*;
import Model.*;
import View.DomoticView;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by SAMPAXX on 25/06/2017.
 */
public class DomoticViewTest {

    private DomoticModel model=DomoticModel.getInstance();
    private DomoticController controlador=new DomoticController(model);
    private DomoticView vista = new DomoticView(controlador, model);

    @Test
    public void test_visualizarEstado(){
        assertEquals(model.getTemperaturaSensor(), Integer.parseInt(vista.Temperatura1.getText()));
    }

}