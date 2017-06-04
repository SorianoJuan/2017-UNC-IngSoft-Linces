/**
 * Created by Torce on 04/06/2017.
 */

public interface DomoticModelInterface {

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
}
