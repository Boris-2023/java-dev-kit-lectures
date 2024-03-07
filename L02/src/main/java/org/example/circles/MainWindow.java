package org.example.circles;

import org.example.common.CanvasRepaintListener;
import org.example.common.Interactable;
import org.example.common.MainCanvas;
import org.example.common.Sprite;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    public static final int POS_X = 400;
    public static final int POS_Y = 200;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 600;
    private final Interactable[] sprites = new Sprite[20];

    public MainWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y,WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");

        for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }

        MainCanvas canvas = new MainCanvas(this);
        add(canvas);

        setVisible(true);
    }

    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime){
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime){
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g){
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
