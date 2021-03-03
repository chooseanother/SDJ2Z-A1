import external.OutdoorThermometer;
import external.Thermometer;
import javafx.application.Application;
import javafx.stage.Stage;
import mediator.Model;
import mediator.ModelManager;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

public class MyApplication extends Application {
    OutdoorThermometer t0;
    Thermometer t1;
    Thermometer t2;

    public void start(Stage primaryStage) {

        // Model
        Model model = new ModelManager();

        // View model
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);

        // View
        ViewHandler view = new ViewHandler(viewModelFactory);

        view.start(primaryStage);

        t0 = new OutdoorThermometer(model, "t0",-10,30);
        t1 = new Thermometer(model, "t1", 0, 1);
        t2 = new Thermometer(model, "t2", 0, 7);
        Thread tt0 = new Thread(t0,"t0");
        Thread tt1 = new Thread(t1,"t1");
        Thread tt2 = new Thread(t2,"t2");
        tt0.start();
        tt1.start();
        tt2.start();
    }

    @Override
    public void stop() {
        t0.stop();
        t1.stop();
        t2.stop();
    }
}
