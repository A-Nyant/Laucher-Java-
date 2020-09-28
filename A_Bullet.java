//'Programmer: Afia Nyantakyi
//Date: 11/5/19
//Goal: To create the moving bullet for the game.
//Program name: A_Bullet.java


import objectdraw.*;
import java.awt.*;

public class A_Bullet extends ActiveObject {
    
    // set how far (in pixels) that the ball will fly in each step
    private double DX = 10;
      
    private FilledOval bullet;
    private Text board;	  
    private DrawingCanvas canvas;
    public asnTarget Target;
    private int score = 0, count = 0;
    private int []both = new int [2];
    private boolean hit;   
    private Color D_color [] = {Color.blue, Color.cyan, Color.green, Color.yellow, Color.orange, Color.red, Color.pink, Color.gray, Color.magenta}; 
    	
    
    public A_Bullet(Location startPoint, DrawingCanvas pCanvas, asnTarget Ball, Text scoreboard, int S_Amount, int T_hit) 
    {
        canvas = pCanvas;
        score = S_Amount;
        count = T_hit;
        //both [0] = S_Amount;
        //both [1] = T_hit;
        board = scoreboard;
        bullet = new FilledOval (startPoint, 20, 20, canvas);
        bullet.setColor(Color.green);
        Target = Ball;      
        start();	// activates the run() routine below
    }
    
    public void run() 
    {
        count++;
        while (bullet.getX() < canvas.getWidth()) 
        {
            if (Target.contains(bullet.getLocation()))
            {
                    hit = true;
            }
            else
            {
               bullet.move(DX, 0);	// draw ball in new location
               pause(100);
            }
            if (hit)
            {
               Text A = new Text ("HIT", canvas.getWidth()/2, 20, canvas);
               score++;
               showDot();
               A.removeFromCanvas();
               pause(100);
               if (Target != null && count == 1)
                  //Target.removeFromCanvas();
               board.setText ("Shots fired: " + count + " Target hits: " + score + " Hit Rate: " + (score/count) * 100);
               //for (int k = 0; k <= 1; k++)
                  //update (both [k]);
               break;
            }
            //for (int k = 0; k <= 1; k++)
            //update (k);
            
        }
       bullet.removeFromCanvas();
     }
     public int update(int j)
     {
        return both [j];
     }
     public void showDot ()
     {
         FilledOval [] dots = new FilledOval [10];
         RandomIntGenerator place = new RandomIntGenerator (0, 300);
         for (int k = 0; k < 10; k++)
         {
            dots [k] = new FilledOval (place.nextValue(), place.nextValue(), 30, 30, canvas);
            RandomIntGenerator num_color = new RandomIntGenerator (0, 8);
            dots[k].setColor(D_color [num_color.nextValue()]);
            pause(100);
         }
         for (int k = 0; k < 10; k++)
         {
            dots [k].removeFromCanvas();
            pause(300);
         }
     }
} // end of class
