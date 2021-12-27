package com.pillarmen.tiles;

import com.pillarmen.math.AABB;
import com.pillarmen.tiles.blocks.Block;

import java.awt.Graphics2D;

public abstract class TileMap {

    public abstract Block[] getBlocks();
    public abstract void render(Graphics2D g, AABB cam);
}
