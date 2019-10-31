import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import javax.imageio.*;
import javax.imageio.ImageIO;

class Player{
    public static int INITIAL_NUM_LIVES = 3;
    public static int IMAGE_DISTANCE = 40;
    public static int IMAGE_Y_POSITION = 450;
    public static int IMAGE_H_GAP = 20;
    private int numLives;

    public Player(){
      this.numLives = INITIAL_NUM_LIVES;
    }

    public void killPlayer(){
      numLives--;
    }

    public boolean isAlive(){
      return (numLives > 0);
    }

    public void draw(Graphics2D g2){
      try{
        Image image = ImageIO.read(new File("player.gif"));
        for (int x = 0; x < numLives; x++) {
          g2.drawImage(image, x * (image.getWidth(null) + IMAGE_H_GAP), IMAGE_Y_POSITION, null);
        }
    }  catch (Exception newException) {
    }
    }
}
