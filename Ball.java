import java.awt.geom.*;
import java.awt.*;

public class Ball extends BreakoutShape {
  public static final int SIZE = 10;
  public static final int START_X = 230;
  public static final int START_Y = 400;
  private BreakoutPanel panel;
  private BallSpeed speed;
  private int dx = 1;
  private int dy = -1;

  public Ball(BallColor color, BreakoutPanel panel){
    super(new Ellipse2D.Double(Ball.START_X, Ball.START_Y, Ball.SIZE, Ball.SIZE), color.color(), true);
    this.panel = panel;
    this.speed = BallSpeed.NORMAL;
  }

  public void move(){
	if(getX() + dx < 0){
	  dx = 1;
	}
	if(getX() + getWidth() + dx > panel.getWidth()){
	  dx = -1;
	}
	if(getY() + dy < 0){
	  dy = 1;
	}
	if(getY() + getWidth() + dy > panel.getWidth()){
	  dy = -1;
	}
	super.move(dx, dy);
  }


  public boolean below(BreakoutShape other){
	  return getY() - dy >= other.getY() + other.getHeight();

  }

  public boolean above(BreakoutShape other){
	  return getY() + getHeight() - dy <= other.getY();
  }

  public boolean leftOf(BreakoutShape other){
	  return getX() + getWidth() - dx <= other.getX();
  }

  public boolean rightOf(BreakoutShape other){
	  return getX() - dx >= other.getX() + other.getWidth();
  }


  public void goUp(){
	dy = -1;
  }

  public void goDown(){
	dy = 1;
  }

  public void goLeft(){
	dx = -1;
  }

  public void goRight(){
	dx = 1;
  }
  public BallSpeed getSpeed(){
      return speed;
  }
  public void setSpeed(BallSpeed s){
      this.speed = s;
  }
}
