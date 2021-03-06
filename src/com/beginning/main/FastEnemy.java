/*
 * Class inhereted of GameObject Class
 */
package com.beginning.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

    private Handler handler;

    public FastEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 2;
        velY = 8;

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        /**
         * if an Enemy hits our window wall, his velocity will reverse - he just
         * bounce off(multiplying by -1)
         */
        if (x > Game.WIDTH - 16 || x < 0) {
            velX *= -1;
        }
        if (y > Game.HEIGHT - 16 || y < 0) {
            velY *= -1;
        }

        handler.addObject(new Trail(x, y, Color.ORANGE, 16.0f, 16.0f, 0.025f, ID.Trail, handler));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);  //set color of render object
        g.fillRect((int)x, (int)y, 16, 16);  //fill renctangle - Dimenstion of him is 16x16px
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, 16, 16);  //16 x 16 is dimensions of our rectangle
    }

}
