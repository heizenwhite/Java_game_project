package Pillarmen.States;

import Pillarmen.Graphics.Sprite;
import Pillarmen.Math.Vector2f;
import Pillarmen.Utils.KeyHandler;
import Pillarmen.Utils.MouseHandler;
import Pillarmen.Graphics.Font;

import java.awt.*;

public class PlayState extends GameState {

    private final Font font;

    public PlayState(GameStateManager gsm){
        super(gsm);
        font = new Font("res/font/ZeldaFont.png", 16, 16);
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
        Sprite.drawArray(g, font, "HELIKOPTER HELIKOPTER", new Vector2f(100, 100), 32, 32, 32, 0);
        g.setColor(Color.orange);
        g.fillRect(0, 0, 64, 64);
    }
}
