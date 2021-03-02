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
}
