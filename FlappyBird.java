import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class FlappyBird extends Actor
{
    private double dy = 0;
    private final double gravity = 0.3;
    private final int boost = 5;
    private boolean isUp = true;
    public LineScore linescorenew;
    
    GreenfootImage[] fly = new GreenfootImage[4];
    private int animCounter = 0;
    
    public FlappyBird()
    {
        initAnimationSprites();
    }
    
    public void act()
    {
        int i;
        physics();
       isTouchingPipe();
       isTouchingScore();
    }
    
    public void physics()
    {
        setLocation(getX(), (int)(getY() + dy));
         dy += gravity; //dy = dy + 1;
         
         if(isUp && Greenfoot.isKeyDown("space"))
         {
             dy = -boost;
             isUp = false;
             animateFlight();
             Greenfoot.playSound("sfx_wing.wav");
         }
         
         if(!isUp && !Greenfoot.isKeyDown("space"))
         {
            isUp = true;
            animateFlight();
         }
         
         if(getY() > getWorld().getHeight() - 10)
         {
             World W = getWorld();
             W.addObject(new GameOver(), W.getWidth()/2, W.getHeight()/2);
             Greenfoot.stop();
         }
         
         if(dy <= -10)
         {
             setRotation(-30);
         }
         else
         {
             if(dy >= 10)
             {
                 setRotation(30);
             }
             else
             {
                 setRotation((int)(dy*3));
             }
            }
         
         if(getY() <= -5)
         {
             setLocation(getX(), -5);
         }
    }
    
    public void isTouchingPipe()
    {
        if(isTouching(Pipe.class))
        {
            World W = getWorld();
            W.addObject(new GameOver(), W.getWidth()/2, W.getHeight()/2);
            Greenfoot.playSound("sfx_hit.wav");
            Greenfoot.stop(); 
        }
    }
    
    public void isTouchingScore()
    {
        if(isTouching(LineScore.class))
        {
            World W = getWorld();
            Scorepoint.score++;
            removeTouching(LineScore.class);
            Greenfoot.playSound("sfx_point.wav");
            linescorenew = new LineScore();
            W.addObject(linescorenew, 762, 200);
        }
    }
    
    public void initAnimationSprites()
    {
        fly[0] = new GreenfootImage("flappybird1.png");
        fly[1] = new GreenfootImage("flappybird2.png");
        fly[2] = new GreenfootImage("flappybird3.png");
        fly[3] = new GreenfootImage("flappybird2.png");
    }
    
    public void animateFlight()
    {
        setImage(fly[animCounter++ % 4]);
    }
}
