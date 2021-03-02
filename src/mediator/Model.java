package mediator;

import model.Temperature;
import utility.observer.subject.UnnamedPropertyChangeSubject;

public interface Model extends UnnamedPropertyChangeSubject{
    void addTemperature(String id, double temperature);
    Temperature getLastInsertedTemperature();
    Temperature getLastInsertedTemperature(String id);
}
