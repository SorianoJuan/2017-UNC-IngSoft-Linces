package Model;

import Observers.*;

import java.util.ArrayList;


public class DomoticModel implements DomoticModelInterface {

    public DomoticModel(){}

    //ArrayLists de observers
    private ArrayList temperaturaObservers = new ArrayList();
    private ArrayList humedadObservers = new ArrayList();
    private ArrayList acObservers = new ArrayList();
    private ArrayList estufaObservers = new ArrayList();
    private ArrayList humidificadorObservers = new ArrayList();

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

    @Override
    public int getTemperaturaSensor() { return TemperaturaSensor;}

    @Override
    public int getHumedadSensor() { return HumedadSensor;}

    @Override
    public void setTemperaturaDeseada(int t) {TemperaturaDeseada=t;}

    @Override
    public int getTemperaturaDeseada() {return TemperaturaDeseada;}

    @Override
    public void setHumedadDeseada(int h) {HumedadDeseada=h;}

    @Override
    public int getHumedadDeseada() {return HumedadDeseada;}

    @Override
    public void setAC(boolean ac) {AC=ac;}

    @Override
    public boolean getAC() {return AC;}

    @Override
    public void setEstufa(boolean es) {Estufa=es;}

    @Override
    public boolean getEstufa() {return Estufa;}

    @Override
    public void setHumidificador(boolean hum) {Humidificador=hum;}

    @Override
    public boolean getHumidificador() {return Humidificador;}


    //Observers de Temperatura
    @Override
    public void registerObserver(TemperaturaObserver o) {temperaturaObservers.add(o);}

    @Override
    public void removeObserver(TemperaturaObserver o) {
        int i = temperaturaObservers.indexOf(o);
        if (i >= 0) {
            temperaturaObservers.remove(i);
        }
    }

    @Override
    public void notifyTemperaturaObservers() {
        for(int i = 0; i < temperaturaObservers.size(); i++) {
            TemperaturaObserver observer = (TemperaturaObserver)temperaturaObservers.get(i);
            observer.updateTemperatura();
        }
    }

    //Observers de humedad
    @Override
    public void registerObserver(HumedadObserver o) {humedadObservers.add(o);}

    @Override
    public void removeObserver(HumedadObserver o) {
        int i = humedadObservers.indexOf(o);
        if (i >= 0) {
            humedadObservers.remove(i);
        }
    }

    @Override
    public void notifyHumedadObservers() {
        for(int i = 0; i < humedadObservers.size(); i++) {
            TemperaturaObserver observer = (TemperaturaObserver)temperaturaObservers.get(i);
            observer.updateTemperatura();
        }
    }

    //Observers de AC
    @Override
    public void registerObserver(ACObserver o) {acObservers.add(o);}

    @Override
    public void removeObserver(ACObserver o) {
        int i = acObservers.indexOf(o);
        if (i >= 0) {
            acObservers.remove(i);
        }
    }

    @Override
    public void notifyACObservers() {
        for(int i = 0; i < acObservers.size(); i++) {
            ACObserver observer = (ACObserver)acObservers.get(i);
            observer.updateAC();
        }
    }

    //Observers de Estufa
    @Override
    public void registerObserver(EstufaObserver o) {estufaObservers.add(o);}

    @Override
    public void removeObserver(EstufaObserver o) {
        int i = estufaObservers.indexOf(o);
        if (i >= 0) {
            estufaObservers.remove(i);
        }
    }

    @Override
    public void notifyEstufaObservers() {
        for(int i = 0; i < estufaObservers.size(); i++) {
            EstufaObserver observer = (EstufaObserver)estufaObservers.get(i);
            observer.updateEstufa();
        }
    }

    //Observers de Humidificador
    @Override
    public void registerObserver(HumidificadorObserver o) {humidificadorObservers.add(o);}

    @Override
    public void removeObserver(HumidificadorObserver o) {
        int i = humidificadorObservers.indexOf(o);
        if (i >= 0) {
            humidificadorObservers.remove(i);
        }
    }

    @Override
    public void notifyHumidificadorObservers() {
        for(int i = 0; i < humidificadorObservers.size(); i++) {
            HumidificadorObserver observer = (HumidificadorObserver)humidificadorObservers.get(i);
            observer.updateHumidificador();
        }
    }
}
