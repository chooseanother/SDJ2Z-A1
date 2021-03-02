package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.Model;
import mediator.ModelManager;
import model.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CentralHeatingViewModel implements PropertyChangeListener {
    private Model model;
    private StringProperty t0, t1, t2, t1Warn, t2Warn, heatLvl;

    public CentralHeatingViewModel(Model model) {
        this.model = model;
        model.addListener(this);
        t0 = new SimpleStringProperty();
        t1 = new SimpleStringProperty();
        t2 = new SimpleStringProperty();
        t1Warn = new SimpleStringProperty();
        t2Warn = new SimpleStringProperty();
        heatLvl = new SimpleStringProperty(String.valueOf(model.getHeatPower()));
    }

    public void clear() {

        t1Warn.setValue("");
        t2Warn.setValue("");
        heatLvl.set(String.valueOf(model.getHeatPower()));
    }

    public void up() {
        model.heatUp();
        heatLvl.set(String.valueOf(model.getHeatPower()));
    }

    public void down() {
        model.heatDown();
        heatLvl.set(String.valueOf(model.getHeatPower()));
    }

    public StringProperty getT0() {
        return t0;
    }

    public StringProperty getT1() {
        return t1;
    }

    public StringProperty getT2() {
        return t2;
    }


    public StringProperty getT1Warn() {
        return t1Warn;
    }

    public StringProperty getT2Warn() {
        return t2Warn;
    }

    public StringProperty getHeatLvl() {
        return heatLvl;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        Platform.runLater(() ->
        {
            if (event.getPropertyName().equals("temperature")) {
                Temperature temp = model.getLastInsertedTemperature();
                if (temp.getId().equals("t1")) {
                    t1.set(String.format("%.2f", temp.getValue()));
                } else if (temp.getId().equals("t2")) {
                    t2.set(String.format("%.2f", temp.getValue()));
                }
            }
        });
    }
}
