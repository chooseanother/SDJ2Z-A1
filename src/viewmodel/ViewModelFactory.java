package viewmodel;


import model.Model;

public class ViewModelFactory {
    private WarningLogViewModel heaterViewModel;
    private CentralHeatingViewModel temperatureViewModel;
    private LimitViewModel limitViewModel;

    public ViewModelFactory(Model model){
        heaterViewModel = new WarningLogViewModel(model);
        temperatureViewModel = new CentralHeatingViewModel(model);
        limitViewModel = new LimitViewModel(model);
    }

    public WarningLogViewModel getHeaterViewModel() {
        return heaterViewModel;
    }

    public CentralHeatingViewModel getTemperatureViewModel() {
        return temperatureViewModel;
    }

    public LimitViewModel getLimitViewModel() {
        return limitViewModel;
    }
}
