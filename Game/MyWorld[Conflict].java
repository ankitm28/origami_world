import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    // variable declarations
    private GreenfootImage image, image0, image1, image2;
    private Background background1, background2;
    private Mountain mountain1, mountain2;
    private String gameState;
    private Text showScore;
    private int score;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
   public MyWorld()
   {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 533, 1, false); 
        prepareWorld();
        setPaintOrder(Text.class ,Origami_Bird.class, Snake.class, Mountain.class, Background.class);
        
   }
   public void act()
    {
        // creates new snake and adds it to the screen with a probablity
        // of 1 %
        if(Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Snake(), getWidth() + getWidth()/2, Greenfoot.getRandomNumber(1000));
        }
    }
   /*
    * This method prepares the world. 
    * It adds instantiate,scale, and add objects to the screen. 
    */
   private void prepareWorld()
   {
        // creates a background scale and sets it.
        image = new GreenfootImage("YellowBackground.png");
        image.scale(getWidth(), getHeight());
        setBackground(image);
        
        // code for moving background and where to add them.
        image = new GreenfootImage("YellowBackground.png");
        image.scale(getWidth(), getHeight());
        image0 = new GreenfootImage("YellowBackgroundInverted.png");
        image0.scale(getWidth(), getHeight());
        
        background1 = new Background();
        background2 = new Background();
        background1.setImage(image);
        background2.setImage(image0);
        
        addObject(background1, getWidth() - getWidth() / 2, getHeight() / 2);
        addObject(background2, background1.getX() + background1.getImage().getWidth(), getHeight() / 2);

        // code for scrolling mountains and where to add them
        image1 = new GreenfootImage("MountainPhoto.png");
        image1.scale(500, 350);
        image2 = new GreenfootImage("MountainPhotoInverted.png");
        image2.scale(500, 350);
        
        mountain1 = new Mountain();
        mountain2 = new Mountain();
        mountain1.setImage(image1);
        mountain2.setImage(image2);
        
        addObject(mountain1, getWidth() - 250, getHeight()/ 2 + 93);
        addObject(mountain2, mountain1.getX() + mountain1.getImage().getWidth(), getHeight() / 2 + 93);
        
        // creates bird and add it to the screen.
        Origami_Bird bird = new Origami_Bird();
        addObject(bird, 100, getHeight() / 2 - 45);
        
        // creates a snake.
        Snake snake = new Snake();
        score = 0;
   }
}
