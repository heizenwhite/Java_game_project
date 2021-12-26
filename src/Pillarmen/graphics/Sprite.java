package Pillarmen.graphics;

import Pillarmen.Math.Vector2f;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

public class Sprite {

    private final BufferedImage SPRITE_SHEET = null;
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE = 32;

    public int w;
    public int h;

    private int wSprite;
    private int hSprite;

    public Sprite(String file){

        w = TILE_SIZE;
        h = TILE_SIZE;

        System.out.println("LOADING " + file + " ...");
        SPRITE_SHEET = loadSprite(file);

        loadSpriteArray();

    }

    public Sprite(String file, int w, int h){

        this.h = h;
        this.w = w;

        System.out.println("LOADING " + file + " ...");
        SPRITE_SHEET = loadSprite(file);

        wSprite = SPRITE_SHEET.getWidth() / w;
        hSprite = SPRITE_SHEET.getHeight() / h;

        loadSpriteArray();
    }

    public void setSize(int width, int height){

        setHeight(height);
        setWidth(width);

    }

    public void setHeight(int i){
        w = i;
        wSprite = SPRITE_SHEET.getWidth() / w;
    }
    public void setWidth(int i){
        h =i;
        hSprite = SPRITE_SHEET.getHeight() / h;
    }

    public int getWidth(){return w;}
    public int getHeight(){return h;}

    private BufferedImage loadSprite(String file){

        BufferedImage sprite = null;

        try{
            sprite = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
        }catch(Exception e){
            System.err.println("ERROR : could not load file - "+e);
        }
        return sprite;
    }

    private void loadSpriteArray(){

        spriteArray = new BufferedImage[wSprite][hSprite];

        for (int x = 0 ; x < wSprite ; x++){
            for( int y = 0 ; y < hSprite ; y++ ){
                spriteArray[x][y] = getSprite(x,y);
            }
        }
    }

    public BufferedImage getSpriteSheet(){
        return SPRITE_SHEET;
    }

    public BufferedImage getSprite(int x, int y){
        return SPRITE_SHEET.getSubimage(x * w ,y * h ,w,h);
    }

    public BufferedImage[] getSpriteArray(int i){
        return spriteArray[i];
    }

    public BufferedImage[][] getSpriteArray2(){
        return spriteArray;
    }

    public static void drawArray(Graphics2D g, ArrayList<BufferedImage> img, Vector2f pos, int width, int height, int xOffset, int yOffset){
        float x = pos.x;
        float y = pos.y;

        for(int i = 0 ; i < img.size() ; i++){
            if(img.get(i) != null){
                g.drawImage(img.get(i),(int) x, (int) y ,width , height, null);
            }

            x+= xOffset;
            y+= yOffset;
        }
    }

    public static void drawArray(Graphics2D g, Font f, String word , Vector2f pos, int width, int height, int xOffset, int yOffset){
        float x = pos.x;
        float y = pos.y;

        for(int i = 0 ; i < word.length() ; i++){
            if(word.charAt(i) != 32){
                g.drawImage(f.getFont(word.charAt(i)),(int) x, (int) y ,width , height, null);
            }

            x+= xOffset;
            y+= yOffset;
        }
    }
}
