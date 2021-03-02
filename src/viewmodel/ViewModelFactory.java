package viewmodel;


import model.Model;

public class ViewModelFactory {
    private LogViewModel heaterViewModel;
    private CentralHeatingViewModel temperatureViewModel;

    public ViewModelFactory(Model model){
        heaterViewModel = new LogViewModel(model);
        temperatureViewModel = new CentralHeatingViewModel(model);
    }

    public LogViewModel getHeaterViewModel() {
        return heaterViewModel;
    }

    public CentralHeatingViewModel getTemperatureViewModel() {
        return temperatureViewModel;
    }
}
