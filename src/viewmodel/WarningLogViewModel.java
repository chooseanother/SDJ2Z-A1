package viewmodel;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.Model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WarningLogViewModel implements  PropertyChangeListener  {
    private Model model;
    private ObservableList<String> log;
    private StringProperty warning;

    public WarningLogViewModel(Model model) {
        this.model = model;
        this.model.addListener(this);
        log = FXCollections.observableArrayList();
        this.warning = new SimpleStringProperty("");
    }

    public ObservableList<String> getLog() {
        return log;
    }

    public void clear(){
        log.clear();
    }

    public StringProperty getWarning() {
        return warning;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        Platform.runLater(()->{
            if (evt.getPropertyName().equals("overtop")) {

                Temperature temp = ((Temperature) evt.getOldValue());

                log.add("ID of thermometer: "+ temp.getId() + "  temperature: "+
                        String.format("%.1f",temp.getValue())+" limit: "+model.getUpperLimit()+
                        " time: "+temp.getTime().getTimestamp() + "  its too hot");
            }
            if (evt.getPropertyName().equals("underbottom")) {

                Temperature temp = ((Temperature) evt.getOldValue());
                log.add("ID of thermometer: "+ temp.getId() + "  temperature: "+
                        String.format("%.1f",temp.getValue())+" limit: "+model.getLowerLimit()+
                        " time: "+temp.getTime().getTimestamp() + "  its too cold");
            }
        });

    }
}
