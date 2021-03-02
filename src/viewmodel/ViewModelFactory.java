package viewmodel;


import mediator.Model;

public class ViewModelFactory {
    private WarningLogViewModel heaterViewModel;
    private CentralHeatingViewModel temperatureViewModel;
    private LimitViewModel limitViewModel;
    private HistoryViewModel historyViewModel;

    public ViewModelFactory(Model model){
        heaterViewModel = new WarningLogViewModel(model);
        temperatureViewModel = new CentralHeatingViewModel(model);
        limitViewModel = new LimitViewModel(model);
        historyViewModel = new HistoryViewModel(model);
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

    public HistoryViewModel getHistoryViewModel() {
        return historyViewModel;
    }
}
