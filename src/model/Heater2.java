package model;

public class Heater2 extends HeaterStates {
    public void HeatUp(Heater heater) {
        heater.setHeaterState(new Heater3(heater));

    }

    public void HeatDown(Heater heater) {
        heater.setHeaterState(new Heater1());

    }

    @Override
    public int getPower() {
        return 2;
    }
}
