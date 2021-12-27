package com.pillarmen.entity;

import com.pillarmen.graphics.SpriteSheet;
import com.pillarmen.math.Vector2f;

import java.awt.Graphics2D;

public class Gathers extends Entity {

    private int material;

    public Gathers(SpriteSheet sprite, Vector2f origin, int size, int material) {
        super(sprite, origin, size);
        this.material = material;
    }

    public int getMaterial() { return material; }
    
    public void update() {

    }

    public void render(Graphics2D g) {

    }


}