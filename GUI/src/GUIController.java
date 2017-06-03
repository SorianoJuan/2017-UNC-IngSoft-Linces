/**
 * Created by Torce on 02/06/2017.
 */

//import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class GUIController {

    private int TemperaturaSensor = 30;
    private int HumedadSensor = 70;

    private int TemperaturaDeseada = 30;
    private int HumedadDeseada = 50;
    private boolean AC = false;
    private boolean Estufa = false;
    private boolean Humidificador = false;


    @FXML

    public Label Temperatura1;
    public Label Temperatura2;
    public Label Humedad1;
    public Label Humedad2;
    public Label AC1;
    public Label AC2;
    public Label Estufa1;
    public Label Estufa2;
    public Label Humidificador1;
    public Label Humidificador2;
    public TextField Tdeseada;
    public TextField Hdeseada;

    public void setTemperaturaDeseada(int t) {
        TemperaturaDeseada = t;
    }

    public int getTemperaturaDeseada() {
        return TemperaturaDeseada;
    }

    public void setHumedadDeseada(int h) {
        HumedadDeseada = h;
    }

    public int getHumedadDeseada() {
        return HumedadDeseada;
    }

    public void setAC(boolean ac) {
        AC = ac;
    }

    public boolean getAC() {
        return AC;
    }

    public void setEstufa(boolean es) {
        Estufa = es;
    }

    public boolean getEstufa() {
        return Estufa;
    }

    public void setHumidificador(boolean hum) {
        Humidificador = hum;
    }

    public boolean getHumidificador() {
        return Humidificador;
    }


    private void Valores() {
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

    public void txtButtonClicked() {
        //ACA IRÍA GENERAR EL TXT
        System.out.println("Boton de txt clickeado");
        Valores();
    }

    public void enviarButtonClicked() {
        System.out.println("Boton de enviar clickeado");
        temperaturaTextField();
        humedadTextField();
        Valores();
        simularT();
        simularH();
    }

    private void temperaturaTextField() {
        if (sanitizarTemperatura(Tdeseada.getText())) {
            TemperaturaDeseada = Integer.parseInt(Tdeseada.getText());
        }
    }

    private void humedadTextField() {
        if (sanitizarHumedad(Hdeseada.getText())) {
            HumedadDeseada = Integer.parseInt(Hdeseada.getText());
        }
    }

    private String acTextField() {
        if (AC) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    private String estufaTextField() {
        if (Estufa) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    private String humidificadorTextField() {
        if (Humidificador) {
            return "ON";
        } else {
            return "OFF";
        }
    }

    private boolean sanitizarTemperatura(String T) {
        int Temp = Integer.parseInt(T);
        return (Temp >= 0 && Temp <= 40);
    }

    private boolean sanitizarHumedad(String H) {
        int Hum = Integer.parseInt(H);
        return (Hum >= 0 && Hum <= 100);
    }

    public void simularT() {
        while (TemperaturaDeseada > TemperaturaSensor) {
            System.out.println("aumentando T");
            AC = false;
            Estufa = true;
            TemperaturaSensor++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                Estufa = false;
                Valores();
            }
        }
        while (TemperaturaDeseada < TemperaturaSensor) {
            System.out.println("disminuyendo T");
            AC = true;
            Estufa = false;
            TemperaturaSensor--;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                AC = false;
                Valores();
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
                Valores();
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
                Valores();
            }
        }
    }

}
