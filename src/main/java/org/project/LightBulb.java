package org.project;

public class LightBulb extends Device {
    public LightBulb(String id, double power) {
        super(id, power);
    }
    @Override
    public void updateState() {
        // Лампочка не изменяет состояния, просто включена/выключена
    }
}

