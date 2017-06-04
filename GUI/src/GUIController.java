/**
 * Created by Torce on 02/06/2017.
 */

//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class GUIController {

    //Variables reales a ser desplegadas en la interfaz gráfica
    private int TemperaturaSensor = 30;
    private int HumedadSensor = 70;

    //Variables ingresadas por usuario
    private int TemperaturaDeseada = 30;
    private int HumedadDeseada = 50;

    //Variables de periféricos conectados
    private boolean AC = false;
    private boolean Estufa = false;
    private boolean Humidificador = false;


    @FXML

    //Campos correspondientes a la vista Monitor
    public Label Temperatura1;
    public Label Humedad1;
    public Label AC1;
    public Label Estufa1;
    public Label Humidificador1;

    //Campos correspondientes a la vista Preset
    public Label Temperatura2;
    public Label Humedad2;
    public Label AC2;
    public Label Estufa2;
    public Label Humidificador2;

    //Valores ingresados por el usuario en la vista Preset
    public TextField Tdeseada;
    public TextField Hdeseada;


    //Setters y Getters

    public void setTemperaturaDeseada(int t) {
        TemperaturaDeseada = t;
    }
    public int getTemperaturaDeseada() {
        return TemperaturaDeseada;
    }

    public void setHumedadDeseada(int h) {HumedadDeseada = h;}
    public int getHumedadDeseada() {return HumedadDeseada;}

    public void setAC(boolean ac) {AC = ac;}
    public boolean getAC() {return AC;}

    public void setEstufa(boolean es) {Estufa = es;}
    public boolean getEstufa() {return Estufa;}

    public void setHumidificador(boolean hum) {Humidificador = hum;}
    public boolean getHumidificador() {return Humidificador;}


    //Metodo para refrescar los valores de la interfaz grafica (esto iria dentro del observer)
    private void actualizarValores() {
        Temperatura1.setText(Integer.toString(TemperaturaSensor));
        Temperatura2.setText(Integer.toString(TemperaturaSensor));
        Humedad1.setText(Integer.toString(HumedadSensor));
        Humedad2.setText(Integer.toString(HumedadSensor));
        AC1.setText(acTextField());
        AC2.setText(acTextField());
        Estufa1.setText(estufaTextField());
        Estufa2.setText(estufaTextField());
        Humidificador1.setText(humidificadorTextField());
        Humidificador2.setText(humidificadorTextField());
    }

    //Metodo que se ejecuta cuando se produce el evento de click en el boton de "Generar .txt"
    public void txtButtonClicked() {
        //ACA IRÍA GENERAR EL TXT
        System.out.println("Boton de txt clickeado");
        actualizarValores();
    }

    //Metodo que se ejecuta cuando se produce el evento de click en el boton de "Enviar"
    public void enviarButtonClicked() {
        System.out.println("Boton de enviar clickeado");
        temperaturaTextField();
        humedadTextField();
        actualizarValores();
        simularT();
        simularH();
    }

    //Actualiza el valor de TemperaturaDeseada si es que pasa la barrera de sanitizado de expresion
    private void temperaturaTextField() {
        if (sanitizarTemperatura(Tdeseada.getText())) {
            TemperaturaDeseada = Integer.parseInt(Tdeseada.getText());
        }
    }

    //Actualiza el valor de HumedadDeseada si es que pasa la barrera de sanitizado de expresion
    private void humedadTextField() {
        if (sanitizarHumedad(Hdeseada.getText())) {
            HumedadDeseada = Integer.parseInt(Hdeseada.getText());
        }
    }

    //Muestra ON u OFF en AC
    private String acTextField() {
        if (AC) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    //Muestra ON u OFF en Estufa
    private String estufaTextField() {
        if (Estufa) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    //Muestra ON u OFF en humidificador
    private String humidificadorTextField() {
        if (Humidificador) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    //Sanitizado de expresion de Temperatura
    private boolean sanitizarTemperatura(String T) {
        int Temp = Integer.parseInt(T);
        return (Temp >= 0 && Temp <= 40);
    }

    //Sanitizado de expresion de Humedad
    private boolean sanitizarHumedad(String H) {
        int Hum = Integer.parseInt(H);
        return (Hum >= 0 && Hum <= 100);
    }

    //Simulacion precaria para ver como varía la cosa
    public void simularT() {
        while (TemperaturaDeseada > TemperaturaSensor) {
            System.out.println("aumentando T");
            AC = false;
            Estufa = true;
            TemperaturaSensor++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Estufa = false;
                actualizarValores();
            }
        }
        while (TemperaturaDeseada < TemperaturaSensor) {
            System.out.println("disminuyendo T");
            AC = true;
            Estufa = false;
            TemperaturaSensor--;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                AC = false;
                actualizarValores();
            }
        }
    }

    public void simularH(){
        while (HumedadDeseada > HumedadSensor) {
            System.out.println("aumentando H");
            Humidificador = true;
            HumedadSensor++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Humidificador = false;
                actualizarValores();
            }
        }
        while (HumedadDeseada < HumedadSensor) {
            System.out.println("disminuyendo H");
            Humidificador = false;
            HumedadSensor--;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Humidificador = false;
                actualizarValores();
            }
        }
    }

}
