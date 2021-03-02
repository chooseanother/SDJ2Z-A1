package model;

public class Heater3 extends HeaterStates {
    private Thread thread;

    public Heater3(Heater heater) {
        Runnable runnable = (() -> {
            try {
                Thread.sleep(5000);
                heater.setHeaterState(new Heater2());
            } catch (InterruptedException e) {
                System.out.println("Interupting sleep lowering heat manualy");
            }
        });

        thread = new Thread(runnable);
        thread.start();
    }

    public void HeatDown(Heater heater) {
        thread.interrupt();
        heater.setHeaterState(new Heater2());

    }

    @Override
    public int getPower() {
        return 3;
    }

}

