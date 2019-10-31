import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public enum BallSpeed{
    FAST(1), NORMAL(10), SLOW(20);
    private int speed;

    BallSpeed(int speed){
        this.speed = speed;
    }
    int speed(){
        return speed;
    }
}
