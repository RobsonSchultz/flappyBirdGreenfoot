import greenfoot.*;  


public class Pipe extends Actor
{
    
    public static int random;
    public int distan;
    
    public void act()
    {
    }
    
    public void moveLeft()
    {
       move(-2); 
    }
    
    public int RandomY(){
        random = Greenfoot.getRandomNumber(210) + 290;
        return random;
    }
    
    public int Distance(){
        if(Scorepoint.score < 10) distan = 390;
        else if(Scorepoint.score < 20) distan = 380;
        else if(Scorepoint.score < 30) distan = 370;
        else distan = 360;
        return distan;
    }
    
    public void respawnBp()
    {
        if(getX() <= -24)
        {
            RandomY();
            setLocation(624, random);
        }
    }
    
    public void respawnTp()
    {
        if(getX() <= -24)
        {
            Distance();
            setLocation(624, random - distan);
        }
    }
}
