package model;

import external.Thermometer;

public class Warning {
    private String message;
    private DateTime time;
    private Thermometer thermometer;

    public Warning(String message)
    {
        this.message = message;
        thermometer = null;
        time = new DateTime();
    }


}
