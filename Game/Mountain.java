import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mountain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mountain extends Actor
{
    /**
     * Act - do whatever the Mountain wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // moves the mountains
        MyWorld wrld = (MyWorld) getWorld();
        if (wrld.getGameState().equals("running"))
        {
            setLocation(getX() - 2, getY());
            if(getX() == -250)
            {
                setLocation(1050, getY());
            }
        }
    }    
}
