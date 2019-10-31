import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
public class Paddle extends BreakoutShape{
    public static final int WIDTH = 75;
    public static final int HEIGHT = 10;
    public static final int START_X = 230;
    public static final int START_Y = 430;
    private static final int SPEED = 10;

    private BreakoutPanel panel;

    public Paddle(Color color, BreakoutPanel panel){
        super(new Rectangle2D.Double(START_X, Paddle.START_Y, Paddle.WIDTH,
        Paddle.HEIGHT), color, true);
        this.panel = panel;
    }

    public void move(int dx){
      if((dx - WIDTH/2 >= 0) && (dx + WIDTH/2 <= panel.getWidth())
        ){
        movePaddle(dx - WIDTH/2);
        }
    }

    public void moveRight(){
      move(SPEED);
    }

    public void moveLeft(){
      move(-SPEED);
    }
  }
