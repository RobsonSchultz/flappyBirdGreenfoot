import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Scorepoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Scorepoint extends Score
{
    public static int score;
    
    public Scorepoint()
    {
      score = 0;
      GreenfootImage Image = new GreenfootImage("Score: " + score, 25, Color.WHITE, null);
      setImage(Image);
    }
    
    public void act()
    {
      GreenfootImage Image = new GreenfootImage("Score: " + score, 25, Color.WHITE, null);
      setImage(Image);
      if (score == 10) {
            getWorld().setBackground(new GreenfootImage("flappy_background_night.png"));
        } else if (score == 20) {
            getWorld().setBackground(new GreenfootImage("flappy_background_hell.png"));
        }
    }
    }

