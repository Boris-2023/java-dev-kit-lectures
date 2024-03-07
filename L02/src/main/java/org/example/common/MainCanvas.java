package org.example.common;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {

    private final CanvasRepaintListener controller;
    private long lastFrameTime;
    public MainCanvas(CanvasRepaintListener controller) {
        setBackground(Color.GRAY);

        this.controller = controller;
        lastFrameTime = System.nanoTime();
    }

    @Override
    protected void paintComponent(Graphics g) {     // do {
        super.paintComponent(g);                    // something

        try {                                       // sleep
            Thread.sleep(16);                     // 16 ms = fps ~ 60
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        float deltaTime = (System.nanoTime() - lastFrameTime)*.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = System.nanoTime();

        repaint();                                  // while (true)
    }

    public int getLeft() {
        return 0;
    }

    public int getRight() {
        return getWidth() - 1;
    }

    public int getTop() {
        return 0;
    }

    public int getBottom() {
        return getHeight() - 1;
    }

}
