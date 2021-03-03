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
    private StringProperty t0, t1, t2, warning, heatLvl;

    public CentralHeatingViewModel(Model model) {
        this.model = model;
        model.addListener(this);
        t0 = new SimpleStringProperty();
        t1 = new SimpleStringProperty();
        t2 = new SimpleStringProperty();
        warning = new SimpleStringProperty();
        heatLvl = new SimpleStringProperty(String.valueOf(model.getHeatPower()));
    }

    public void clear() {

        warning.setValue("");
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


    public StringProperty getWarning() {
        return warning;
    }

    public StringProperty getHeatLvl() {
        return heatLvl;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        Platform.runLater(() ->
        {
            //works but is stupid hack not correct way i guess
            heatLvl.set(String.valueOf(model.getHeatPower()));
            warning.setValue("");
            if (event.getPropertyName().equals("temperature")) {
                Temperature temp = model.getLastInsertedTemperature();
                if (temp.getId().equals("t1")) {
                    t1.set(String.format("%.1f", temp.getValue()));
                } else if (temp.getId().equals("t2")) {
                    t2.set(String.format("%.1f", temp.getValue()));
                }
            }
            else if (event.getPropertyName().equals("overtop")){
                Temperature temp = (Temperature) event.getOldValue();
                warning.setValue(String.format("%s - %s: %.1f limit: %s \n %s",temp.getId(),event.getNewValue(),
                        temp.getValue(),model.getUpperLimit(),temp.getTime().getTimestamp()));

            }
            else if (event.getPropertyName().equals("underbottom")){
                Temperature temp = (Temperature) event.getOldValue();
                warning.setValue(String.format("%s - %s: %.1f limit: %s \n %s",temp.getId(),event.getNewValue(),
                        temp.getValue(),model.getLowerLimit(),temp.getTime().getTimestamp()));
            }
        });
    }
}
