import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nut here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nut extends Actor
{
    // instance data
    private int speed;
    private boolean doubleHasScored;
    
    /*
     * Constructor of the Nut class which sets up the shooting speed
     * and helps control the score.
     */
    public Nut()
    {
        speed = 15;
        doubleHasScored = false;
        
    }
    /**
     * Act - do whatever the Nut wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MyWorld wrld = (MyWorld) getWorld();
        if (wrld.getGameState().equals("running"))
        {
            // destroys the bullet if it is out of the world.
            if (IsOutOfRange())
            {
                getWorld().removeObject(this);
            }
            // checks if nut touched the snake class, and if it did, it removes the snake and adds two points
            // to it.
            if (isTouching(Snake.class))
            {
                removeTouching(Nut.class);
                removeTouching(Snake.class);
                if (!doubleHasScored)
                {
                    wrld.updateScore(2);
                    doubleHasScored = true;
                }
            }
            // make the bullets move towards right edge of the screen.
            setLocation(getX() + speed, getY());
        }
    }
    /*
     * this method checks if the bullet has reached the edge of  the world.
     */
    private boolean IsOutOfRange()
    {
        if (this.getX() == 800)
        {
            return true;
        }
        return false;
    }
}
