import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;



public class BreakoutFrame extends JFrame {
    public static final int HEIGHT = 600;
    public static final int WIDTH = 460;

    private BreakoutPanel panel = new BreakoutPanel();

    public static final int LOCATION_X = 100;
    public static final int LOCATION_Y = 100;


    public BreakoutFrame(){
        panel.setBackground(Color.BLACK);
        setLocation(LOCATION_X, LOCATION_Y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayMenu();
        setSize(WIDTH, HEIGHT);


        add(panel);
        setResizable(false);
    }
    public void displayMenu(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new GameMenu());
        menuBar.add(new ColorMenu());
        menuBar.add(new SpeedMenu());
        menuBar.add(new BackgroundColorMenu());
        menuBar.add(new LineColorMenu());
        setJMenuBar(menuBar);
    }
    private class GameMenu extends JMenu{
        public GameMenu(){
            super("Game");
            JMenuItem startGameMI = new JMenuItem("Start", 'S');
            startGameMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
            JMenuItem pauseMI = new JMenuItem("Pause", 'P');
            pauseMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
            JMenuItem quitMI = new JMenuItem("Quit");
            startGameMI.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    panel.start();
                }
            });
            pauseMI.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    panel.pause();
                }
            });
            quitMI.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }
            });
            add(startGameMI);
            add(pauseMI);
            add(quitMI);
        }
    }
    private class ColorMenu extends JMenu{
        public ColorMenu(){
            super("Ball Color");
            for(BallColor color : BallColor.values()){
                JMenuItem menuItem = new JMenuItem(color.name() + "Ball");
                menuItem.addActionListener(new BallColorListener(color));
                add(menuItem);
            }
        }
    }
    private class BallColorListener implements ActionListener{
        private BallColor color;
        public void actionPerformed(ActionEvent e){
            panel.changeBallColor(color);
        }
        public BallColorListener(BallColor color){
            this.color = color;
        }
    }

    private class SpeedMenu extends JMenu{
        public SpeedMenu(){
            super("Ball Speed");
            for(BallSpeed s : BallSpeed.values()){
                JMenuItem menuItem = new JMenuItem(s.name());
                menuItem.addActionListener(new BallSpeedListener(s));
                add(menuItem);
            }
        }
    }

    private class BallSpeedListener implements ActionListener{
        private BallSpeed speed;
        public void actionPerformed(ActionEvent e){
            panel.changeBallSpeed(speed);
        }
        public BallSpeedListener(BallSpeed speed) {
            this.speed = speed;
        }
    }

    private class BackgroundColorMenu extends JMenu{
        public BackgroundColorMenu(){
            super("Background Color");
            for(BackgroundColor color : BackgroundColor.values()){
                JMenuItem menuItem = new JMenuItem(color.name() + " Background");
                menuItem.addActionListener(new BackgroundColorListener(color));
                add(menuItem);
            }

        }
    }
    private class BackgroundColorListener implements ActionListener{
        private BackgroundColor color;
        public void actionPerformed(ActionEvent e){
            panel.setBackground(color.color);
        }
        public BackgroundColorListener(BackgroundColor color){
            this.color = color;
        }
    }

    private class LineColorMenu extends JMenu{
        public LineColorMenu(){
            super("Line Color");
            for(LineColor color : LineColor.values()){
                JMenuItem menuItem = new JMenuItem(color.name() + " Line Color");
                menuItem.addActionListener(new LineColorListener(color));
                add(menuItem);
            }
        }
    }
    private class LineColorListener implements ActionListener{
        private LineColor color;
        public void actionPerformed(ActionEvent e){
            panel.setLineColor(color);
        }
        public LineColorListener(LineColor color){
            this.color = color;
        }
    }
}
