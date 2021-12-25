package Sterben.Game;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{

    public static int width;
    public static int height;

    private boolean run = false;
    private Thread th;
    private BufferedImage img;
    private Graphics2D g2;

    public GamePanel(int w, int h){
        this.width = w;
        this.height = h;
        setPreferredSize(new Dimension(w,h));
        setFocusable(true);
        requestFocus();
    }

    public void addNotify(){
        super.addNotify();
        if(th == null){
            th = new Thread(this,"GameThread");
            th.start();
        }
    }

    public void init(){
        this.run = true;
        this.img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        this.g2 = (Graphics2D) img.getGraphics();
    }

    private int y = 0 ;

    public void update(){
        y++;
        System.out.println(y);
    }

    public void draw(){

    }

    public void render(){

    }

    public void run(){
        init();
        while(run){
            update();
            render();
            draw();
        }
    }
}
