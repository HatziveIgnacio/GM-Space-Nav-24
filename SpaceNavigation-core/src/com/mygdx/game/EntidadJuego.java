package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class EntidadJuego {
    protected float x;
    protected float y;
    protected float xVel;
    protected float yVel;
    protected Sprite sprite;

    public EntidadJuego(float x, float y, Texture texture) {
        this.x = x;
        this.y = y;
        this.sprite = new Sprite(texture);
        this.sprite.setPosition(x, y);
    }

    public abstract void update();

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public Rectangle getBoundingRectangle() {
        return sprite.getBoundingRectangle();
    }

    public boolean checkCollision(EntidadJuego other) {
        return this.getBoundingRectangle().overlaps(other.getBoundingRectangle());
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setPosition(float x, float y) {
        this.x = x;
        this.y = y;
        this.sprite.setPosition(x, y);
    }

    public void setVelocity(float xVel, float yVel) {
        this.xVel = xVel;
        this.yVel = yVel;
    }

    public float getXVel() {
        return xVel;
    }

    public float getYVel() {
        return yVel;
    }
    
    public void setVelX(float xVel) {
        this.xVel = xVel;
    }
    public void setVelY(float yVel) {
        this.yVel = yVel;
    }
}
