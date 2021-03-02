package viewmodel;


import javafx.beans.property.SimpleStringProperty;
import model.Model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class WarningLogViewModel implements  PropertyChangeListener  {
    private Model model;
    private ObservableList<String> log;
    private SimpleStringProperty warning;

    public WarningLogViewModel(Model model) {
        this.model = model;
        log = FXCollections.observableArrayList();
        this.warning = new SimpleStringProperty();

    }

    public ObservableList<String> getLog() {
        return log;
    }

    public void clear(){
        log.clear();
    }

    public SimpleStringProperty getWarning() {
        return warning;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Platform.runLater(()->log.add(0,evt.getOldValue()+": "+evt.getNewValue()));
    }
}
