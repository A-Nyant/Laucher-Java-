//'Programmer: Afia Nyantakyi
//Date: 11/5/19
//Goal: To create the target for the game.
//Program name: asnTarget.java

import objectdraw.*;
import java.awt.*;

public class asnTarget{
      
    private FilledOval circle; //varible for the circle.	  
    private DrawingCanvas canvas; //variable for the canvas
    private FilledRect space; //create the opening in the circle
    
    public asnTarget(Location startPoint, DrawingCanvas pCanvas) {
        canvas = pCanvas;
        //create the target.
        circle = new FilledOval(startPoint, 70, 60, canvas);
        box = new FilledRect (startPoint.getX(), startPoint.getY() + 15, 70, 30, canvas);
        box.setColor(Color.white);
    }
    public boolean contains(Location p)
    {
        if (circle.contains (p) && !box.contains(p))
            return true;
        else
            return false;
    }
    public void removeFromCanvas()
    {
      circle.removeFromCanvas();
      box.removeFromCanvas();
    }
	  
} // end of class
