package org.project;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller implements DeviceListener {
    private final List<Device> devices = new ArrayList<>();
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final boolean isRunning = true;
    private final LevelIndicator powerIndicator;
    public Controller(LevelIndicator powerIndicator) {
        this.powerIndicator = powerIndicator;
    }
    public void addDevice(Device device) {
        devices.add(device);
        device.setListener(this);
        notifyPowerChange();
    }
    public void start() {
        executor.submit(() -> {
            while (isRunning) {
                for (Device device : devices) {
                    device.updateState();
                }
                notifyPowerChange();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    private void notifyPowerChange() {
        double totalPower = devices.stream().mapToDouble(Device::getPower).sum();
        powerIndicator.setValue((int) totalPower);
        if (totalPower > 1000) {
            devices.forEach(Device::turnOff);
            System.out.println("Перегрузка сети! Все устройства выключены.");
        }
    }
    @Override
    public void onStateChanged(String deviceId, boolean isOn) {
        System.out.println("Устройство " + deviceId + " изменило состояние: " + (isOn ? "включено" : "выключено"));
    }
    @Override
    public void onPowerChanged(String deviceId, double power) {
        System.out.println("Устройство " + deviceId + " использует мощность: " + power + " Вт");
    }
}
