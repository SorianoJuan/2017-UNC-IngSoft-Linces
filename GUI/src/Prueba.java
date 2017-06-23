import Controller.DomoticController;
import Model.DomoticModel;
import View.DomoticView;
import javafx.application.Application;

public class Prueba {
    public static void main(String[] args) {
        DomoticModel domoticModel = new DomoticModel();
        DomoticController domoticController = new DomoticController(domoticModel);

        //Para correr la vista
        Application.launch(Main.class, args);
      //  DomoticView.getInstance().setView(domoticController,domoticModel);
    }
}