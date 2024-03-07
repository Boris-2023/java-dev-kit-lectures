package org.example.circles;

import org.example.common.Interactable;
import org.example.common.MainCanvas;

import java.awt.*;

public class Background implements Interactable {
    private float time;
    public static final float AMPLITUDE = 255f/2f;
    private Color color;

    @Override
    public void update(MainCanvas canvas, float deltaTime){
        time += deltaTime;

        int red = Math.round(AMPLITUDE + AMPLITUDE*(float) Math.sin(time*1f));
        int green = Math.round(AMPLITUDE + AMPLITUDE*(float) Math.sin(time*2f));
        int blue = Math.round(AMPLITUDE + AMPLITUDE*(float) Math.sin(time*3f));

        color = new Color(red, green, blue);
    }

    @Override
    public void render(MainCanvas canvas, Graphics g){
        canvas.setBackground(color);
    }

}
