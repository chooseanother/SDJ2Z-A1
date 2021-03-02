package viewmodel;


import model.Model;

public class ViewModelFactory {
    private HeaterViewModel heaterViewModel;
    private TemperatureViewModel temperatureViewModel;

    public ViewModelFactory(Model model){
        heaterViewModel = new HeaterViewModel(model);
        temperatureViewModel = new TemperatureViewModel(model);
    }

    public HeaterViewModel getHeaterViewModel() {
        return heaterViewModel;
    }

    public TemperatureViewModel getTemperatureViewModel() {
        return temperatureViewModel;
    }
}
