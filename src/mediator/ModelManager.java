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
        heater = new Heater();
        temperatureList = new TemperatureList();
        property = new PropertyChangeSupport(this);
        limits = new Limits(30,10);
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
            //create new warning (too be implemented)
            //add to warning list (too be implemented)

            property.firePropertyChange("overtop",temp,"too hot");
            System.out.println("too hot");
        }
        else if (limits.isUnderLowerLimit(temperature)){
            //create new warning (too be implemented)
            //add to warning list (too be implemented)

            property.firePropertyChange("underbottom",temp,"too cold");
            System.out.println("too cold");

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

    @Override public void setUpperLimit(double value) throws Exception {
        Double old = getUpperLimit();
        limits.setUpper(value);
        property.firePropertyChange("setUpperLimit",old,value);
    }

    @Override public void setLowerLimit(double value) throws Exception {
        Double old = getLowerLimit();
        limits.setLower(value);
        property.firePropertyChange("setLowerLimit",old,value);
    }

    @Override
    public double getUpperLimit() {
        return limits.getUpper();
    }

    @Override
    public double getLowerLimit() {
        return limits.getLower();
    }

    @Override
    public int getHeatPower() {
        return heater.getPower();
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
