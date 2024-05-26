package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bullet {
    private Sprite spr;
    private float xVel, yVel;

    public Bullet(float x, float y, float xVel, float yVel, Texture tx) {
        this.xVel = xVel;
        this.yVel = yVel;
        spr = new Sprite(tx);
        spr.setPosition(x, y);
        spr.setBounds(x, y, 10, 10);
    }

    public void update() {
        spr.translate(xVel, yVel);
    }

    public void draw(SpriteBatch batch) {
        spr.draw(batch);
    }
    
    public Rectangle getBoundingRectangle() {
        return spr.getBoundingRectangle();
    }

}
