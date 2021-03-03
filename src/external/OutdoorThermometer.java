package external;

import mediator.Model;

public class OutdoorThermometer implements Runnable{
    private double t;
    private double t0;
    private String id;
    private boolean running;
    private Thread runningThread;
    private Model model;

    public OutdoorThermometer(Model model, String id, double min, double max)
    {
        this.id = id;
        this.t0 = 0.0;  // outdoor initial temperature
        this.model = model;
    }

    @Override public void run()
    {
        running = true;
        runningThread = Thread.currentThread();
        while (running)
        {
            try
            {

                int seconds = (int) (Math.random() * 4 + 4);
                Thread.sleep(seconds * 1000);
                t = externalTemperature(t0, -10,30);
                System.out.printf(id + " %.1f\n", t);
                model.addTemperature(id,t);
            }
            catch (InterruptedException e)
            {
                //
            }
        }
    }

    public void stop()
    {
        running = false;
        if (runningThread != null)
        {
            runningThread.interrupt();
        }
    }

    /**
     * Calculating the external temperature.
     * Values are only valid if the temperature is being measured
     * approximately every 10th second.
     *
     * @param t0 the last measured external temperature
     * @param min a lower limit (may temporally be deceeded)
     * @param max an upper limit (may temporally be exceeded)
     * @return an updated external temperature
     */

    public double externalTemperature(double t0, double min, double max)
    {
        double left = t0 - min;
        double right = max - t0;
        int sign = Math.random() * (left + right) > left ? 1 : -1;
        t0 += sign * Math.random();
        return t0;
    }
}
