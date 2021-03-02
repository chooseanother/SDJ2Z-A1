package model;

public class Heater1 extends HeaterStates {
    public void HeatUp(Heater heater) {
        heater.setHeaterState(new Heater2());

    }
    public void HeatDown(Heater heater) {
        heater.setHeaterState(new Heater0());

    }

    @Override
    public int getPower() {
        return 1;
    }
}
