package org.project;

public abstract class Device {
    protected String id;
    protected double power;
    protected boolean isOn;
    protected DeviceListener listener;
    public Device(String id, double power) {
        this.id = id;
        this.power = power;
        this.isOn = false;
    }
    public void setListener(DeviceListener listener) {
        this.listener = listener;
    }
    public void turnOn() {
        isOn = true;
        if (listener != null) listener.onStateChanged(id, true);
    }
    public void turnOff() {
        isOn = false;
        if (listener != null) listener.onStateChanged(id, false);
    }
    public double getPower() {
        return isOn ? power : 0;
    }
    public abstract void updateState();
}
