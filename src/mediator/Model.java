package mediator;

import model.Temperature;
import utility.observer.subject.UnnamedPropertyChangeSubject;

public interface Model extends UnnamedPropertyChangeSubject
{
    void heatUp();
    void heatDown();
    void addTemperature(String id, double temperature);
    Temperature getLastInsertedTemperature();
    Temperature getLastInsertedTemperature(String id);
    void setUpperLimit(double value) throws Exception;
    void setLowerLimit(double value) throws Exception;
    double getUpperLimit();
    double getLowerLimit();
    int getHeatPower();
}
