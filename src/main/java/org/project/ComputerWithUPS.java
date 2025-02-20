package org.project;

public class ComputerWithUPS extends Device {
    private int upsTime = 5;
    public ComputerWithUPS(String id, double power) {
        super(id, power);
    }
    @Override
    public void updateState() {
        if (!isOn && upsTime > 0) {
            upsTime--;
            if (upsTime == 0) {
                System.out.println("ИБП выключился, компьютер выключен.");
            }
        } else if (isOn) {
            upsTime = 5;
        }
    }
}

