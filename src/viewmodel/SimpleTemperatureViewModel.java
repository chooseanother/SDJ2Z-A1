package viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Temperature;

public class SimpleTemperatureViewModel {
  private StringProperty IDProperty;
  private StringProperty valueProperty;
  private StringProperty timeProperty;

  public SimpleTemperatureViewModel(Temperature temperature){
    IDProperty = new SimpleStringProperty(temperature.getId());
    valueProperty = new SimpleStringProperty(String.format("%.1f",temperature.getValue()));
    timeProperty = new SimpleStringProperty(temperature.getTime().getTimestamp());
  }

  public StringProperty getIDProperty(){
    return IDProperty;
  }
  public StringProperty getValueProperty(){
    return valueProperty;
  }
  public StringProperty getTimeProperty(){return timeProperty;}
}
