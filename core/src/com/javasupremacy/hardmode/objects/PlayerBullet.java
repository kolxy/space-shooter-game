package com.javasupremacy.hardmode.objects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class PlayerBullet {

    public static final int SPEED = 100;
    public static final int DEFAULT_Y = 1;

    //    public static final int WIDTH = 3;
    //    public static final int HEIGHT = 12;

    private static Texture texture;

    float x, y;
//    CollisionRect rect;
    public boolean remove = false;

    public PlayerBullet(float x) {
        this.x = x;
        this.y = DEFAULT_Y;
//        this.rect = new CollisionRect(x, y, WIDTH, HEIGHT);

        if (texture == null)
            texture = new Texture("bulletBeige.png");
    }

    public void update (float deltaTime) {
        y += SPEED * deltaTime;
        if (y > Gdx.graphics.getHeight())
            remove = true;

//        rect.move(x, y);
    }

    public void render (SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

//    public CollisionRect getCollisionRect () {
//        return rect;
//    }

}