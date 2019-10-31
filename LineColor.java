import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public enum LineColor{
    Black(Color.BLACK), White(Color.WHITE), Gray(Color.GRAY), LightGray(Color.LIGHT_GRAY), DarkGray(Color.DARK_GRAY), Yellow(Color.YELLOW), Green(Color.GREEN), Purple(Color.MAGENTA), Red(Color.RED), Blue(Color.BLUE);
    public Color color;

    LineColor(Color color){
        this.color = color;
    }
    Color color(){
        return color;
    }
}
