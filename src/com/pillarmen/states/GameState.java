package com.pillarmen.states;

import com.pillarmen.utils.KeyHandler;
import com.pillarmen.utils.MouseHandler;

import java.awt.Graphics2D;

public abstract class GameState {

    protected GameStateManager gsm;

    public GameState(GameStateManager gsm) {
        this.gsm = gsm;
    }

    public abstract void update(double time);
    public abstract void input(MouseHandler mouse, KeyHandler key);
    public abstract void render(Graphics2D g);
}
