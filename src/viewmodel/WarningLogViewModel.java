package viewmodel;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.Model;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Temperature;
import view.WarningLogViewController;

import java.awt.*;
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
        //loadFromModel();

    }

    public ObservableList<String> getLog() {
        return log;
    }

    public void clear(){
        log.clear();
        warning.setValue("");
    }

    public StringProperty getWarning() {
        return warning;
    }
   // public addWarning(Warning warning)  {  log.add(new Warning(warning))  }


  //  private void loadFromModel(){
  //       if (model.getAllWarnings().size()>0) {
  //           for (Warning e : model.getAllWarnings()) {
  //               log.add(new Warning(e));
  //            }
  //        }
  //    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        Platform.runLater(()->{
            if (evt.getPropertyName().equals("overtop")) {

                Temperature temp = ((Temperature) evt.getOldValue());

                log.add("ID of thermometer: "+ temp.getId() + "  temperature: "+String.format("%.2f",temp.getValue())+" time: "+temp.getTime() + "  its too hot");
                //addWarning((Warning) evt.getNewValue());

            }
            if (evt.getPropertyName().equals("underbottom")) {

                Temperature temp = ((Temperature) evt.getOldValue());
                log.add("ID of thermometer: "+ temp.getId() + "  temperature: "+String.format("%.2f",temp.getValue())+" time: "+temp.getTime().getTimestamp() + "  its too cold");
                //addWarning((Warning) evt.getNewValue());

            }
        });

    }
}
