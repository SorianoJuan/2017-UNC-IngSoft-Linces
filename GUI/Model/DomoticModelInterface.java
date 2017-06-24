package Model;

import Observers.*;

public interface DomoticModelInterface {

    int getTemperaturaSensor();
    int getHumedadSensor();

    void setTemperaturaDeseada(int t);
    int getTemperaturaDeseada();

    void setHumedadDeseada(int h);
    int getHumedadDeseada();

    void setAC(boolean ac);
    boolean getAC();

    void setEstufa(boolean es);
    boolean getEstufa();

    void setHumidificador(boolean hum);
    boolean getHumidificador();

    void registerObserver(TemperaturaObserver o);
    void removeObserver(TemperaturaObserver o);
    void notifyTemperaturaObservers();

    void registerObserver(HumedadObserver o);
    void removeObserver(HumedadObserver o);
    void notifyHumedadObservers();

    void registerObserver(ACObserver o);
    void removeObserver(ACObserver o);
    void notifyACObservers();

    void registerObserver(EstufaObserver o);
    void removeObserver(EstufaObserver o);
    void notifyEstufaObservers();

    void registerObserver(HumidificadorObserver o);
    void removeObserver(HumidificadorObserver o);
    void notifyHumidificadorObservers();

}