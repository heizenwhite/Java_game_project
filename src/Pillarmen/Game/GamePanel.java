package Pillarmen;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable{

    //Resolution Window
    public static int width;
    public static int height;

    //Window Elements
    private boolean run = false;
    private Thread th;
    private BufferedImage img;
    private Graphics2D g2;

    //Create GamePanel with Width and Height
    public GamePanel(int w, int h){
        width = w;
        height = h;
        setPreferredSize(new Dimension(w,h));
        setFocusable(true);
        requestFocus();
    }

    //Create thread if doesn't exist
    public void addNotify(){
        super.addNotify();
        if(th == null){
            th = new Thread(this,"GameThread");
            th.start();
        }
    }

    //Initialize Window view
    public void init(){
        this.run = true;
        this.img = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        this.g2 = (Graphics2D) img.getGraphics();
    }

    //Update generated elements
    public void update(){

    }

    //Draw elements to generate
    public void draw(){
        Graphics g = (Graphics) this.getGraphics();
        g.drawImage(img, 0 , 0 ,width, height, null);
        g.dispose();
    }

    //Render elements on screen
    public void render(){
        if(g2 != null){
            g2.setColor(new Color(60,130,240));
            g2.fillRect(0, 0 , width, height);
        }
    }

    public void input(){

    }

    //Game Loop to run
    public void run(){

        //Initialize the image
        init();

        //Hertz of refresh
        final double GAME_HERTZ = 60.0;
        //Time Before Update
        final double TBU = 1000000000 / GAME_HERTZ;
        //Must update before update
        final int MUBR = 5;

        //Update Time before and after
        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        //FPS set
        final double TARGET_FPS = 60.0;
        //Total Time before render
        final double TTBR = 1000000000 /TARGET_FPS;

        //Frames
        int frameCount = 0;
        //Frame render element
        int lastSecondTime = (int) lastUpdateTime / 1000000000;
        //Fame count before last update
        int oldFrameCount = 0;


        //Game Loop Set to run if "Run" is true
        while(run){

            double now = System.nanoTime();
            int updateCount = 0;

            while((now - lastUpdateTime) > TBU && (updateCount < MUBR) ){

                update();
                input();
                lastUpdateTime += TBU;
                updateCount++;
            }

            if( (now - lastUpdateTime) > TBU){
                lastUpdateTime = now - TBU ;
            }

            input();
            render();
            draw();

            lastRenderTime = now ;
            frameCount++;

            int thisSecond =  (int) (lastUpdateTime / 1000000000);

            if (thisSecond > lastSecondTime){

                if( frameCount != oldFrameCount){

                    System.out.println("New Second : " +thisSecond  + " " + frameCount);

                    oldFrameCount = frameCount;
                }

                frameCount = 0;
                lastSecondTime = thisSecond;
            }

            while(now - lastRenderTime < TTBR && now - lastUpdateTime < TBU ){

                Thread.yield();
                try {
                    Thread.sleep(1);
                }catch(Exception e){
                    System.err.print("ERROR : Thread yielding - "+e);
                }
                now = System.nanoTime();

            }
        }
    }
}
