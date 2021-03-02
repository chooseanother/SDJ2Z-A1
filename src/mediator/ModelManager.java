package mediator;

import model.Heater;
import model.Limits;
import model.Temperature;
import model.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
    private Heater heater;
    private PropertyChangeSupport property;
    private TemperatureList temperatureList;
    private Limits limits;

    public ModelManager()
    {
        temperatureList = new TemperatureList();
        property = new PropertyChangeSupport(this);
        limits = new Limits(0,50);
    }

    public void heatUp()
    {
        heater.heatUp();
    }

    public void heatDown()
    {
        heater.heatDown();
    }

    @Override
    public void addTemperature(String id, double temperature)
    {
        Temperature temp = new Temperature(id, temperature);
        Temperature old = getLastInsertedTemperature(id);
        this.temperatureList.addTemperature(temp);
        if (old != null && old.getValue() != temp.getValue()) {
            System.out.println("--> new=" + temperature + " (old=" + old + ")");
        } else if (old == null) {
            System.out.println("--> new=" + temperature + " (old=" + old + ")");
        }
        property.firePropertyChange("temperature",old,temperature);

        if (limits.isOverUpperLimit(temperature)){
           property.firePropertyChange("over top",old,"too hot");
        }
        else if (limits.isUnderLowerLimit(temperature)){
           property.firePropertyChange("over bottom",old,"too cold");
        }
    }

    @Override
    public Temperature getLastInsertedTemperature() {
        return temperatureList.getLastTemperature(null);
    }

    @Override
    public Temperature getLastInsertedTemperature(String id) {
        return temperatureList.getLastTemperature(id);
    }

    @Override
    public void addListener(PropertyChangeListener listener) {
        property.addPropertyChangeListener(listener);
    }

    @Override
    public void removeListener(PropertyChangeListener listener) {
        property.removePropertyChangeListener(listener);
    }
}
