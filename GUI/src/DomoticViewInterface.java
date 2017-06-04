/**
 * Created by Torce on 04/06/2017.
 */
public interface DomoticViewInterface {
    void display();
    boolean sanitizarTemperatura(String T);
    boolean sanitizarHumedad(String H);
    String acTextField();
    String estufaTextField();
    String humidificadorTextField();
    void enviarButtonClicked();
    void txtButtonClicked();
    void crearDomoticGUI();
}
