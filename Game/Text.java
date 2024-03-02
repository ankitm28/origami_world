import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    // instance data
    GreenfootImage transparent;
    private String txt;
    private int sz;
    private Color color;
    /*
     * Constructor that sets up attributes of the image.
     */
    public Text(String str, int size, Color foreground, Color background)
    {
        txt = str;
        sz = size;
        color = foreground;
        transparent = new GreenfootImage(txt, sz, color, null); 
        setImage(transparent);
    }
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    /*
     * Method that helps change the text once written.
     */
    public void setText(String str)
    {
        transparent = new GreenfootImage(str, sz, color, null);
        setImage(transparent);
    }
}
