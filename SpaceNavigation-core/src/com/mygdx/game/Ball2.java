package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;

public class Ball2 extends EntidadJuego {

    public Ball2(float x, float y, int radius, float xVel, float yVel, Texture texture) {
        super(x, y, texture);
        setVelocity(xVel, yVel);
    }

    @Override
    public void update() {
        setPosition(x + xVel, y + yVel);
        if (x < 0 || x + sprite.getWidth() > Gdx.graphics.getWidth()) xVel *= -1;
        if (y < 0 || y + sprite.getHeight() > Gdx.graphics.getHeight()) yVel *= -1;
    }
   
}
