package org.project;

public interface DeviceListener {
    void onStateChanged(String deviceId, boolean isOn);
    void onPowerChanged(String deviceId, double power);
}

