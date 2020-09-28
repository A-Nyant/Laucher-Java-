//'Programmer: Afia Nyantakyi
//Date: 11/5/19
//Goal: The controller of the game.
//Program name: asnLauncherA.java

import objectdraw.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class asnLauncherA extends WindowController
{        
    public static void main(String[] args)
    {
      new asnLauncherA().startController(400,400);    
    }
    
    private asnTarget ball; //The target
    private A_Bullet bullet; //The ball
    private launchZone Launchpad;
    
    //The instructions
    private FilledRect inst_box; 
    private Text instructionA, instructionB, instructionC, instructionD;
    private Text scoreboard;
    private int S_Amount = 0, T_hit = 0, hit_percent = 0, count = 0;
    //Location of the ball
    private Location Target_Point = new Location (200, 100);
    
    //Used to remove the instruction by counting how many times the mouse was press.
    
    
    
    //When the game begins.
    public void begin()
    {
        //The target is made
        ball = new asnTarget (Target_Point, canvas);
        //this the instruction box for the game
        inst_box = new FilledRect (50, 100, 250, 300, canvas);
        inst_box.setColor(Color.white);
        instructionA = new Text ("To play the game, you should press the" , 60, 110, canvas);
        instructionB = new Text ("mouse. Then a ball will appear and move", 60, 135, canvas);
        instructionC = new Text ("across the screen. Try to aim for the", 60, 150, canvas);
        instructionD = new Text ("middle of the target on the right side", 60, 165, canvas);
        scoreboard = new Text ("Shots fired: " + S_Amount + " Target hits: " + T_hit + " Hit Rate: " + hit_percent, 0, canvas.getHeight() - 30, canvas);
        Launchpad = new launchZone (0, 0, canvas);
    }
    
    
    //When the player press on the screen
    public void onMousePress(Location p)
    {
        //After the first press, the instructions disappear
        if (count == 0)
        {
            instructionA.removeFromCanvas();
            instructionB.removeFromCanvas();
            instructionC.removeFromCanvas();
            instructionD.removeFromCanvas();
            inst_box.removeFromCanvas();
            count+= 1;
         }
         //Game starts
         else
         {
            bullet = new A_Bullet (p, canvas, ball, scoreboard, S_Amount, T_hit);
         }
    }
       
} // end class
