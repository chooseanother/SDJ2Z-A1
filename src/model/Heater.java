package model;

public class Heater {
    private HeaterStates heaterState;

    public Heater() {
        heaterState = new Heater0();
    }

    public void heatUp() {
        heaterState.HeatUp(this);
        System.out.println("HeatingUp");
    }

    public void heatDown() {
        heaterState.HeatDown(this);
        System.out.println("HeatingDown");
    }

    public void setHeaterState(HeaterStates heaterState) {
        System.out.println(heaterState.getPower());
        this.heaterState = heaterState;
    }

}
