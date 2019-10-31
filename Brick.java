import java.awt.geom.*;
import java.awt.*;

public class Brick extends BreakoutShape{
    public static final int HEIGHT = 10;
    public static final int WIDTH = 30;
    public static final int BRICK_H_GAP = 5;
    public static final int BRICK_V_GAP = 5;


    public Brick(int row, int col, Color color){
      super(new Rectangle2D.Double(BRICK_H_GAP + col * (BRICK_H_GAP +
        Brick.WIDTH), BRICK_V_GAP + row * (BRICK_V_GAP + Brick.HEIGHT),
        WIDTH, HEIGHT), color, true);
    }

    private Brick(Rectangle2D rectangle, Color color){
      super(rectangle, color, true);
    }

    public Brick add(Brick other){
      Rectangle2D rectangle1 = super.getBounds();
      Rectangle2D rectangle2 = other.getBounds();
      rectangle1.add(rectangle2);
      return new Brick(rectangle1, super.getColor());
    }

}
