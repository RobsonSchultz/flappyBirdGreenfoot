import greenfoot.*;  


public class FlappyWorld extends World
{
    FlappyBird flappy;
    TopPipe toppipe1;
    BottomPipe bottompipe1;
    TopPipe toppipe2;
    BottomPipe bottompipe2;
    LineScore linescore1;
    LineScore linescore2;
    public FlappyWorld()
    {    
        super(600, 400, 1, false); 
        addBird();
        addPipe();
        addScore();
    }
    
    public void addBird()
    {
        flappy = new FlappyBird();
        addObject(flappy, 100, getHeight()/2 );
    }
    
    public void addPipe()
    {
      toppipe1 = new TopPipe(); 
      bottompipe1 = new BottomPipe();
      toppipe2 = new TopPipe(); 
      bottompipe2 = new BottomPipe();
      linescore1 = new LineScore();
      linescore2 = new LineScore();
      
      addObject(bottompipe1, 550, 500);     //270
      addObject(toppipe1, 550, 110);        //130
      
      addObject(bottompipe2, 250, 290);     //290_500
      addObject(toppipe2, 250, -100);        //-100_110
      
      addObject(linescore1, 550, 200);     //290_500
      addObject(linescore2, 250, 200);    //-100_110
      
    }
    
    public void addScore()
    {
        addObject(new Scorepoint(), 50, 25);
    }
}
