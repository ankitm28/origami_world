import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Actor
{
    /**
     * Act - do whatever the Background wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // moves the background and adds another inverted image to the back of the back
        // of it, helps in animation.
        MyWorld wrld = (MyWorld) getWorld();
        if(wrld.getGameState().equals("running"))
        {
            setLocation(getX() - 2, getY());
            if(getX() < -.5 * getWorld().getWidth())
            {
                setLocation(getX() + 2 * getImage().getWidth() - 3, getY());
            }
        }
    }    
}
