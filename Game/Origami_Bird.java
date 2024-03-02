import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Origami_Bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Origami_Bird extends Actor
{
    //instance data
    private GreenfootImage image1;
    private GreenfootImage image2;
    private GreenfootImage image3;
    private int animationCount = 1;
    private int ANIMATION_SPEED = 7;
    private double dy = -12;
    private double GRAVITY = 1;;
    private int nutCounter, shootDelayTime;
    private GreenfootSound shot;
    private boolean isKeyPressed = false;
    /*
     * Constructor of the bird class.
     * Instansiates images, and sets up some counters that help 
     * nuts shoot.
     */
    public Origami_Bird()
    {
        image1 = new GreenfootImage("OrigamiBird1.png");
        image2 = new GreenfootImage("OrigamiBird2.png");
        image3 = new GreenfootImage("OrigamiBird3.png");
        shootDelayTime = 20;
        nutCounter = 0;
        shot = new GreenfootSound("Pop.wav");
        shot.setVolume(45);
    }
    /*
     * creates animation of the bird, creates gravity that
     * gives bird flying motion and shoots the nuts when space is pressed.
     */
    public void act() 
    {
        MyWorld wrld = (MyWorld) getWorld();
        
        if(wrld.getGameState().equals("running"))
        {
            animation();
            animationCount++;
            setLocation(getX(), (int)(getY() + dy));
            if(Greenfoot.isKeyDown("up") == true && !isKeyPressed)
            {
                dy = -12;
                isKeyPressed = true;
                if (atTopEdge() == true)
                {
                    dy = 1;
                }
            }
            if (!Greenfoot.isKeyDown("up") && isKeyPressed)
            {
                dy = -12;
                isKeyPressed = false;
                if (atTopEdge() == true)
                {
                    dy = 1;
                }
            }
            dy += GRAVITY;
            if (Greenfoot.isKeyDown("space"))
            {
                
                shoot();
                shot.play();
            }
            nutCounter++;
        }
    }
    /*
     * code that change images to create animation.
     */
    private void animation()
    {
        if(animationCount % ANIMATION_SPEED == 0)
        {
            if(getImage() == image1)
            {
                setImage(image2);
            }
            else if(getImage() == image2)
            {
                setImage(image3);
            }
            else
            {
                setImage(image1);
            }
        }
    }
    /*
     * code that helps bird shoot.
     */
    private void shoot()
    {
        if(nutCounter >= shootDelayTime)
        {
            getWorld().addObject(new Nut(), getX(), getY());
            nutCounter = 0;
        }
    }
    private boolean atTopEdge()
    {
        if (this.isAtEdge())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
