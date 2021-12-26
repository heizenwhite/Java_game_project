package Pillarmen.States;

import Pillarmen.Utils.KeyHandler;
import Pillarmen.Utils.MouseHandler;

import java.awt.*;

public class PlayState extends GameState {

    public PlayState(GameStateManager gsm){
        super(gsm);
    }

    @Override
    public void update() {

    }

    @Override
    public void input(MouseHandler mouse, KeyHandler key) {

        if(key.up.down) {
            System.out.println("'Z' is being pressed.");
        }
    }

    @Override
    public void render(Graphics2D g) {

        g.setColor(Color.orange);
        g.fillRect(0, 0, 64, 64);
    }
}
