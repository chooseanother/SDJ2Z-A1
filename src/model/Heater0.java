package model;

public class Heater0 extends  HeaterStates{
    public void HeatUp(Heater heater) {
        heater.setHeaterState(new Heater1());
    }

    @Override
    public int getPower() {
        return 0;
    }


}
