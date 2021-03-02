package viewmodel;


import model.Model;

public class ViewModelFactory {
    private LogViewModel heaterViewModel;
    private CentralHeatingViewModel temperatureViewModel;
    private LimitViewModel limitViewModel;
    private HistoryViewModel historyViewModel;

    public ViewModelFactory(Model model){
        heaterViewModel = new LogViewModel(model);
        temperatureViewModel = new CentralHeatingViewModel(model);
        limitViewModel = new LimitViewModel(model);
        historyViewModel = new HistoryViewModel(model);
    }

    public LogViewModel getHeaterViewModel() {
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
