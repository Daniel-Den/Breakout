import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;

public enum BackgroundColor{
    Black(Color.BLACK), White(Color.WHITE), Gray(Color.GRAY), LightGray(Color.LIGHT_GRAY), DarkGray(Color.DARK_GRAY), Yellow(Color.YELLOW), Purple(Color.MAGENTA), Cyan(Color.CYAN);
    public Color color;

    BackgroundColor(Color color){
        this.color = color;
    }
    Color color(){
        return color;
    }
}
