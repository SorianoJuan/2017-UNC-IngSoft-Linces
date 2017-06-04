import java.util.ArrayList;

/**
 * Created by Torce on 04/06/2017.
 */
public class DomoticModel implements DomoticModelInterface{

    //ArrayLists de observers
    ArrayList temperaturaObservers = new ArrayList();
    ArrayList humedadObservers = new ArrayList();

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
}
