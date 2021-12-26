package Pillarmen.Utils;

import Pillarmen.Game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class KeyHandler implements KeyListener {

    public static List<Key> keys = new ArrayList<Key>();

    public class Key {

        public int presses, absorbs;
        public boolean down, clicked;

        public Key() {

            keys.add(this);
        }

        public void toggle(boolean pressed) {

            if(pressed != down) {
                down = pressed;
            }
            if(pressed) {
                presses++;
            }
        }

        public void tick() {

            if (absorbs < presses) {
                absorbs++;
                clicked = true;
            } else {
                clicked = false;
            }
        }
    }

    //instantiation of used keys, subject to modifications
    public Key up =  new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key attack = new Key();
    public Key interact = new Key();
    public Key menu = new Key();
    public Key dodge = new Key();

    public KeyHandler(GamePanel game) {

        game.addKeyListener(this);
    }

    public void releaseAll() {

        for(int i = 0; i < keys.size(); i++) {
            keys.get(i).down = false;
        }
    }

    public void tick() {

        for (int i = 0; i < keys.size(); i++) {
            keys.get(i).tick();
        }
    }

    public void toggle(KeyEvent e, boolean pressed) {

        if(e.getKeyCode() == KeyEvent.VK_Z) up.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_S) down.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_Q) left.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_D) right.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_SHIFT) attack.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_E) interact.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) dodge.toggle(pressed);
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE) menu.toggle(pressed);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //nothing happens
    }

    @Override
    public void keyPressed(KeyEvent e) {

        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {

        toggle(e, false);
    }
}
