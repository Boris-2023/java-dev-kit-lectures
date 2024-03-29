package org.example.bricks;

import org.example.common.Interactable;
import org.example.common.MainCanvas;
import org.example.common.Sprite;

import java.awt.*;
import java.util.Random;

public class Brick extends Sprite implements Interactable{

    private static Random rnd = new Random();
    private final Color color;
    private float vX, vY;

    public Brick() {
        halfHeight = 20 + (float) (Math.random()*50F);
        halfWidth = halfHeight;
        color = new Color(rnd.nextInt());

        vX = 100f + (float) (Math.random()*200f);
        vY = 100f + (float) (Math.random()*200f);
    }

    @Override
    public void render(MainCanvas canvas, Graphics g){
        g.setColor(color);
        g.fill3DRect((int) getLeft(), (int)getTop(), (int)getWidth(), (int) getHalfHeight(), true);
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime){
        x += vX * deltaTime;
        y += vY * deltaTime;

        if(getLeft() < canvas.getLeft()){
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if(getRight() > canvas.getRight()){
            setRight(canvas.getRight());
            vX = -vX;
        }
        if(getTop() < canvas.getTop()){
            setTop(canvas.getTop());
            vY = -vY;
        }
        if(getBottom() > canvas.getBottom()){
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }
}
