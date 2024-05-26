package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Nave4 {
    private boolean destruida = false;
    private int vidas = 3;
    private float xVel = 0;
    private float yVel = 0;
    private Sprite spr;
    private Sound sonidoHerido;
    private Sound soundBala;
    private Texture txBala;
    private boolean herido = false;
    private int tiempoHeridoMax = 50;
    private int tiempoHerido;
    private PantallaJuego juego;

    public Nave4(int x, int y, Texture tx, Sound soundChoque, Texture txBala, Sound soundBala, PantallaJuego juego) {
        this.sonidoHerido = soundChoque;
        this.soundBala = soundBala;
        this.txBala = txBala;
        this.juego = juego;
        spr = new Sprite(tx);
        spr.setPosition(x, y);
        spr.setBounds(x, y, 45, 45);
    }

    public void update() {
        float x = spr.getX();
        float y = spr.getY();

        if (!herido) {
            xVel = 0;
            yVel = 0;

            if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) xVel = -5;
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) xVel = 5;
            if (Gdx.input.isKeyPressed(Input.Keys.UP)) yVel = 5;
            if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) yVel = -5;

            if (x + xVel < 0 || x + xVel > Gdx.graphics.getWidth() - spr.getWidth()) xVel = 0;
            if (y + yVel < 0 || y + yVel > Gdx.graphics.getHeight() - spr.getHeight()) yVel = 0;

            spr.setPosition(x + xVel, y + yVel);
        } else {
            spr.setX(spr.getX() + MathUtils.random(-2, 2));
            tiempoHerido--;
            if (tiempoHerido <= 0) herido = false;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            Bullet bala = new Bullet(spr.getX() + spr.getWidth() / 2 - 5, spr.getY() + spr.getHeight() - 5, 0, 3, txBala);
            juego.agregarBala(bala);
            soundBala.play();
        }
    }

    public void draw(SpriteBatch batch) {
        spr.draw(batch);
    }
    
    public boolean checkCollision(Ball2 ball) {
        return spr.getBoundingRectangle().overlaps(ball.getBoundingRectangle());
    }

    public void setVidas1(int vidas) {
        this.vidas = vidas;
    }
    
    public boolean isHerido() {
        return herido;
    }

    public void setHerido(boolean herido) {
        this.herido = herido;
    }

    public int getTiempoHeridoMax() {
        return tiempoHeridoMax;
    }

    public void setTiempoHeridoMax(int tiempoHeridoMax) {
        this.tiempoHeridoMax = tiempoHeridoMax;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public Sound getSonidoHerido() {
        return sonidoHerido;
    }
    
    public void setTiempoHerido(int tiempoHerido) {
        this.tiempoHerido = tiempoHerido;
    }
}
