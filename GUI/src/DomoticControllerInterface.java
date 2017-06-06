/**
 * Created by Torce on 04/06/2017.
 */
public interface DomoticControllerInterface {
    void setearTemperatura(int t);
    void setearHumedad(int hum);
    String estadoAC();
    String estadoEstufa();
    String estadoHumidificador();
}
