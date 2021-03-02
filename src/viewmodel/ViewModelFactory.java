package viewmodel;


import mediator.Model;

public class ViewModelFactory {
    private LogViewModel logViewModel;
    private CentralHeatingViewModel centralHeatingViewModel;
    private LimitViewModel limitViewModel;
    private HistoryViewModel historyViewModel;

    public ViewModelFactory(Model model){
        logViewModel = new LogViewModel(model);
        centralHeatingViewModel = new CentralHeatingViewModel(model);
        limitViewModel = new LimitViewModel(model);
        historyViewModel = new HistoryViewModel(model);
    }

    public LogViewModel getLogViewModel() {
        return logViewModel;
    }

    public CentralHeatingViewModel getCentralHeatingViewModel() {
        return centralHeatingViewModel;
    }

    public LimitViewModel getLimitViewModel() {
        return limitViewModel;
    }

    public HistoryViewModel getHistoryViewModel() {
        return historyViewModel;
    }
}
