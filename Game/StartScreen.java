import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    // instance data
    private Text startScreenInfo, controls;
    private Origami origami;
    private WORLD world;
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        
        super(800, 533, 1);
        Greenfoot.start();
        
        origami = new Origami();
        addObject(origami, getWidth() / 2 + 15, getHeight() / 2);
        
        world = new WORLD();
        addObject(world, getWidth()/ 2 + 10, getHeight()/2 + 100);
        
        startScreenInfo = new Text("Welcome to", 42, Color.RED, null);
        addObject(startScreenInfo, getWidth() / 2, getHeight() / 2 - 150);
        
        controls = new Text("There are three levels in the game\n Starting with beginner to impossible.", 22, Color.DARK_GRAY, null);
        addObject(controls, getWidth() / 2, getHeight() / 2 + 200);
    }
    /*
     * sets the new world when enter is pressed.
     */
    public void act()
    {
        Greenfoot.delay(100);
        controls.setText("You will use up arrow key to fly.\n Don't keep it pressed, release the key after pressing once.");
        Greenfoot.delay(100);
        controls.setText("Press 'Enter' to start the game");
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new MyWorld());
        }
        
    }
}
