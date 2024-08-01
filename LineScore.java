import greenfoot.*;

public class LineScore extends Score
{
    public void act()
    {
        setTransparency();
        moveLeft();
        respawn();
    }
    
    public void respawn()
    {
        if(getX() <= 115)
        {
            setLocation(762, getY());
        }
    }
    
    public void setTransparency()
    {
        getImage().setTransparency(0);
    }
}
