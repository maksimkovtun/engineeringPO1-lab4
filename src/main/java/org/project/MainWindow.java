package org.project;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final Controller controller;

    public MainWindow() {
        setTitle("Система потребителей электроэнергии");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        LevelIndicator powerIndicator = new LevelIndicator(0, 1000, 300, 800, 0, 1000);
        controller = new Controller(powerIndicator);
        controller.start();
        add(powerIndicator, BorderLayout.CENTER);
        JPanel controls = new JPanel();
        JButton addKettleButton = new JButton("Добавить чайник");
        addKettleButton.addActionListener(e -> {
            Kettle kettle = new Kettle("Kettle1", 500);
            controller.addDevice(kettle);
            kettle.turnOn();
        });
        JButton addLightBulbButton = new JButton("Добавить лампочку");
        addLightBulbButton.addActionListener(e -> {
            LightBulb lightBulb = new LightBulb("Light1", 100);
            controller.addDevice(lightBulb);
            lightBulb.turnOn();
        });
        JButton addComputerWithUPSButton = new JButton("Добавить компьютер с ИБП");
        addComputerWithUPSButton.addActionListener(e -> {
            ComputerWithUPS computerWithUPS = new ComputerWithUPS("ComputerWithUPS1", 200);
            controller.addDevice(computerWithUPS);
            computerWithUPS.turnOn();
        });
        controls.add(addKettleButton);
        controls.add(addLightBulbButton);
        controls.add(addComputerWithUPSButton);
        add(controls, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainWindow::new);
    }
}
