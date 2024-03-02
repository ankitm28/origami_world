import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    // instance data
    private GreenfootImage image, image0, image1, image2;
    private Background background1, background2;
    private Mountain mountain1, mountain2;
    private Origami_Bird bird;
    private GameOver gameOver;
    private String gameState, gameLevel;
    private Text showScore, gamePlay, restartGame, gameCleared, showTimer;
    private int score;
    private int waitCount, counter, timeCounter;
    private int timer;
    private GreenfootSound back;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 533, 1, false); 
        prepareWorld();
        setPaintOrder(Text.class, GameOver.class, Origami_Bird.class, Nut.class, Snake.class, Mountain.class, Background.class);
        gameState = "startup";
        gameLevel = "beginner";
        counter = 0;
        waitCount = 50 + Greenfoot.getRandomNumber(50);
        timer = 500;
        timeCounter = 60;
        back = new GreenfootSound("Wind.wav");
        
    }
    /*
     * Act method of the MyWorld, changes diffculty level of the 
     * game using methods, and change the volume of the sound.
     */
    public void act()
    {
        if (gameLevel.equals("beginner"))
        {
            levelOne();
            
        }
        else if (gameLevel.equals("intermediate"))
        {
            levelTwo();
            
        }
        else if (gameLevel.equals("impossible"))
        {
            levelThree();
            
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
        bird = new Origami_Bird();
        addObject(bird, getWidth() / 2 - getWidth() / 3, getHeight() / 2 - 45);
        
        // creates a snake.
        Snake snake = new Snake();
        
        // creates game over image
        gameOver = new GameOver();
        
        //tracks and add score image 
        score = 0;
        showScore = new Text("0", 32, Color.BLACK, null);
        addObject(showScore, getWidth() - 100, 100);
        
        // text variables
        restartGame = new Text("Press r to start the game again", 32, Color.BLACK, null);
        gamePlay = new Text("Press 'UP' arrow key to fly \n Press 'Space' to shoot nuts", 32, Color.BLACK, null);
        showTimer = new Text("500", 32, Color.BLACK, null);
        addObject(showTimer, getWidth() - 100, 50);
        gameCleared = new Text("Hooray!!! \n Game Accomplished", 40, Color.BLUE, null);
        
    }
    /* 
     * Method for beginner level of the game.
     * sets up parameters that changes the frequency 
     * of the snakes that appears on the screen.
     */
    private void levelOne()
    {
        
        if (gameState.equals("startup"))
        {
            startup();
        }
        else if (gameState.equals("running"))
        {
            running(30, 15, 1000, 30, "intermediate");
            
        }
        else if (gameState.equals("finished"))
        {
            finished();
        }
    }
    /* 
     * Method for intermediate level of the game.
     * sets up parameters that changes the frequency 
     * of the snakes that appears on the screen.
     */
    private void levelTwo()
    {
        if (gameState.equals("startup"))
        {
            startup();
        }
        else if (gameState.equals("running"))
        {
            running(15, 5,800, 50, "impossible");
            
        }
        else if (gameState.equals("finished"))
        {
            finished();
        }
    }
    /* 
     * Method for beginner level of the game.
     * sets up parameters that changes the frequency 
     * of the snakes that appears on the screen.
     */
    private void levelThree()
    {
        if (gameState.equals("startup"))
        {
            startup();
        }
        else if (gameState.equals("running"))
        {
            running(1, 3, 533, 60, "");
            
        }
        else if (gameState.equals("finished"))
        {
            finished();
        }
    }
    /*
     * code that runs when game is in startup mode.
     */
    private void startup()
    {
        addObject(gamePlay, getWidth() / 2, 200);
        if (Greenfoot.isKeyDown("up"))
        {
            gameState = "running";
        }
    }
    /*
     * code that accomplishes everything while the actual game 
     * is in progress. It adds score, add/remove Text objects, 
     * check if the bird is falling, and sets gameState to finished.
     */
    private void running(int x, int y,int z, int s, String str)
    {
        counter++;
        timer--;
        showTimer.setText(timer + "");
        back.play();
        removeObject(gamePlay);
        back.setVolume(s);
        if(counter == waitCount)
        {
            counter = 0;
            waitCount = x + Greenfoot.getRandomNumber(y);
            addObject(new Snake(), getWidth() + getWidth()/2, Greenfoot.getRandomNumber(z));
        }
        if (bird.getY() > getHeight())
        {
            gameState = "finished";
        }
        
        if (timer == 0)
        {
            timer = 500;
            showTimer.setText(timer + "");
            gameLevel = str;
            gameState = "startup";
        }
    }
    /*
     * method for finished game mode which helps restart the game
     * and sets up variables for another game.
     */
    private void finished()
    {
        removeObjects(getObjects(Snake.class));
        removeObjects(getObjects(Nut.class));
        addObject(gameOver, getWidth() / 2, getHeight() / 2);
        addObject(restartGame, getWidth() / 2, getHeight() - 100);
        if(Greenfoot.isKeyDown("r"))
        {
            bird.setLocation(getWidth() / 2 - getWidth() / 3, getHeight() / 2 - 45);
            score = 0;
            showScore.setText(score+"");
            timer = 500;
            showTimer.setText(timer + "");
            removeObject(gameOver);
            removeObject(restartGame);
             
            gameState = "startup";
            Greenfoot.setWorld(new StartScreen());
        }
        
    }
    /*
     * Method that update the score
     */
    public void updateScore(int x)
    {
        score += x;
        showScore.setText(score +"");
    }
    /*
     * this getter method returns the bird characteristics.
     */
    public Origami_Bird getOrigamiBird()
    {
        return bird;
    }
    /*
     * this method returns the game state
     */
    public String getGameState()
    {
        return gameState;
    }
    /*
     * this method sets the game state.
     */
    public void setGameState(String gs)
    {
        gameState = gs;
    }
}
