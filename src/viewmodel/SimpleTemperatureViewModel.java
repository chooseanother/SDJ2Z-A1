package viewmodel;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Temperature;

public class SimpleTemperatureViewModel {
  private StringProperty IDProperty;
  private DoubleProperty valueProperty;

  public SimpleTemperatureViewModel(Temperature temperature){
    IDProperty = new SimpleStringProperty(temperature.getId());
    valueProperty = new SimpleDoubleProperty(temperature.getValue());
  }

  public StringProperty getIDProperty(){
    return IDProperty;
  }
  public DoubleProperty getValueProperty(){
    return valueProperty;
  }
}
