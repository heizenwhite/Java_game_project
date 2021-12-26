package Pillarmen.States;

import Pillarmen.Utils.KeyHandler;
import Pillarmen.Utils.MouseHandler;

import java.awt.*;

public abstract class GameStates {

    private GameStatesManager gsm;

    public GameStates(GameStatesManager gsm){
        this.gsm = gsm;
    }

    public abstract void update();
    public abstract void input(MouseHandler mouse, KeyHandler key);
    public abstract void render(Graphics2D g);

}
