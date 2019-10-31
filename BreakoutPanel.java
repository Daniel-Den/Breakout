import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;
import java.awt.geom.*;
import javax.imageio.*;

class BreakoutPanel extends JPanel {

	public static final int NUM_BRICK_COLUMNS = 13;
	public static final int NUM_BRICK_ROWS = 13;
	private javax.swing.Timer timer;
	private Ball ball;
	private ArrayList<Brick> bricks;
	private Paddle paddle;
	private Player player;
	private boolean gameStarted = false;
	private int liney = 450;
	private LineColor lineColor;

	public BreakoutPanel(){
		ball = new Ball(BallColor.Red, this);
		paddle = new Paddle(Color.BLUE, this);
		bricks = new ArrayList<>();
		player = new Player();
		createBricks();
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e){
				String s = KeyEvent.getKeyText(e.getKeyCode());
				if(e.getKeyCode() == KeyEvent.VK_LEFT) {
					paddle.moveLeft();
				}
				if(s.equals("Right")) {
					paddle.moveRight();
				}
				repaint();
			}
		});
		setFocusable(true);
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseMoved(MouseEvent e){
				paddle.move(e.getX());
				repaint();
			}
		});
	}

	private Color getRandomColor(){
		Color color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
		if (getBackground().equals(color)){
			return Color.RED;
		}
		return color;
	}
	private void createBricks() {
		for(int row = 2; row < NUM_BRICK_ROWS; row++){
			for(int col = 0; col < NUM_BRICK_COLUMNS; col++) {
				bricks.add(new Brick(row, col, getRandomColor()));
			}
		}
	}

  public void start() {
        gameStarted = true;
        if(timer != null){
            timer.stop();
        }
        if(!player.isAlive()){
            player = new Player();
            ball = new Ball(BallColor.Red, this);
            createBricks();
        }
        timer = new javax.swing.Timer(ball.getSpeed().speed(), new TimerListener());
        timer.start();
        repaint();
    }

	public void pause(){
		if(timer == null) {
			return;
		}
		timer.stop();
	}


	public void showMessage(String s, Graphics2D g2){
		Font myFont = new Font("SansSerif", Font.BOLD + Font.ITALIC, 40);
		g2.setFont(myFont);
		if (bricks.size() == 0){
			g2.setColor(Color.GREEN);
		}
		else if (!player.isAlive()){
			g2.setColor(Color.RED);
		}
		Rectangle2D textBox = myFont.getStringBounds(s,g2.getFontRenderContext());
		g2.drawString(s,(int) (getWidth()/2-textBox.getWidth()/2),(int)(getHeight()/2-textBox.getHeight()));
	}


	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		if (bricks.size() == 0){
			showMessage("YOU WIN!", g2);
		}
		else if (!player.isAlive()){
			showMessage("GAME OVER!", g2);
			pause();
		}
		else{
			ball.draw(g2);
			paddle.draw(g2);
			for(Brick brick: bricks){
				brick.draw(g2);
			}
		}
		player.draw(g2);
		g.setColor(Color.white);
		g.drawLine(0,liney,480,liney);
		g.drawString(String.valueOf(bricks.size()), 0, 500);
	}


  	public void changeBallSpeed(BallSpeed speed){
		ball.setSpeed(speed);
		repaint();
  	}

    public void changeBallColor(BallColor color){
        ball.changeColor(color.color());
        repaint();
    }


  	class TimerListener implements ActionListener{
		public void bounceBall(Ball ball, Brick brick){
			if(ball.below(brick)){
				ball.goDown();
			}
			if(ball.above(brick)){
				ball.goUp();
			}
			if(ball.leftOf(brick)){
				ball.goLeft();
			}
			if(ball.rightOf(brick)){
				ball.goRight();
			}
		}


		public void actionPerformed(ActionEvent e){
			for(int i = 0; i < bricks.size(); i++){
				if (bricks.get(i).intersects(ball)){
					bounceBall(ball, bricks.get(i));
					bricks.remove(i);
				}
			}


			if (ball.intersects(paddle)){
				ball.goUp();
				if(ball.getX() + ball.getWidth() / 2 < paddle.getX() + paddle.getWidth() / 2){
					ball.goLeft();
				}
				else{
					ball.goRight();
				}
			}

			if(ball.getY() >= paddle.getY()){
				player.killPlayer();
				ball.goUp();
			}

			ball.move();
			repaint();
		}
  	}

  public void setLineColor(LineColor color){
      lineColor = color;
  }

}
