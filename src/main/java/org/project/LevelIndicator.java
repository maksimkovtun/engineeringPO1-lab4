package org.project;

import javax.swing.*;
import java.awt.*;

public class LevelIndicator extends JPanel {
    private final int minValue;
    private final int maxValue;
    private final int warningLow;
    private final int warningHigh;
    private int currentValue;

    public LevelIndicator(int minValue, int maxValue, int warningLow, int warningHigh, int criticalLow, int criticalHigh) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.warningLow = warningLow;
        this.warningHigh = warningHigh;
        this.currentValue = minValue;
        setPreferredSize(new Dimension(100, 300));
    }

    public void setValue(int value) {
        this.currentValue = Math.max(minValue, Math.min(maxValue, value));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        int barHeight = (int) ((double) (currentValue - minValue) / (maxValue - minValue) * height);
        Color barColor;
        if (currentValue >= warningHigh) {
            barColor = Color.RED;
        } else if (currentValue >= warningLow) {
            barColor = Color.YELLOW;
        } else {
            barColor = Color.GREEN;
        }
        g2d.setColor(barColor);
        g2d.fillRect(0, height - barHeight, width, barHeight);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(0, 0, width - 1, height - 1);
    }
}

