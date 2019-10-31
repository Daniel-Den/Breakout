import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public enum BallColor{
    Red(Color.RED), Blue(Color.BLUE), Green(Color.GREEN);
    private Color color;

    BallColor(Color color){
        this.color = color;
    }
    Color color(){
        return color;
    }
}
