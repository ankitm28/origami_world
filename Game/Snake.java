import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Snake here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Snake extends Actor
{
    // instance data
    private boolean hasScored;
    private GreenfootSound eat;
    /*
     * Constructor of snake class which sets up sound
     * and scoring controller.
     */
    public Snake()
    {
        hasScored = false;
        eat = new GreenfootSound("slurp.wav");
    }
    /**
     * Act - do whatever the Snake wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MyWorld wrld = (MyWorld) getWorld();
        setLocation(getX() - 3, getY());
        if(wrld.getGameState().equals("running"))
        {
            // code that checks if the bird collided with the snake.
            if(isTouching(Origami_Bird.class))
            {
                eat.play();
                wrld.setGameState("finished");
            }
            // code for adding a point to the score when snake passes.
            if (getX() < wrld.getOrigamiBird().getX() / 2 - wrld.getOrigamiBird().getX() / 3 && !hasScored && getY()< wrld.getHeight())
            {
                wrld.updateScore(1);
                hasScored = true;
                
            }
        }
    }    
}
