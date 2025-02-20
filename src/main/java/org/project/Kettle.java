package org.project;

public class Kettle extends Device {
    private double temperature = 20.0;
    public Kettle(String id, double power) {
        super(id, power);
    }
    @Override
    public void updateState() {
        if (isOn) {
            temperature += 10;
            if (temperature >= 100) {
                turnOff();
                temperature = 100;
                System.out.println("Чайник закипел и выключился.");
            }
        } else {
            temperature -= 5;
            if (temperature < 20) temperature = 20;
        }
    }
}
