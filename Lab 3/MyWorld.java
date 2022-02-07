import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int level = 1;
    //private int health = 10;
    Counter counter = new Counter("Score: ");
    Counter levelCounter = new Counter("Level: ");
    Counter healthCounter = new Counter("Health: ");
    //level counter vs level??
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a 
        //cell size of 1x1 pixels.
        super(1200, 800, 1);
        Player player = new Player();
        addObject(player, 600, 400);
        addObject(new Timer(), 30, 20);
        
        addObject(counter, 535, 30);
        
        levelCounter.add(1);
        addObject(levelCounter, 540, 60);
        
        healthCounter.subtract(1);
        addObject(healthCounter, 540, 90);
        
        //addObject(new ScoreBoard(), 300, 365);
    }
    
    public void upLevel()
    {
        level++; //seems repetitive??
        levelCounter.add(1);
    }
    
    public int getLevel()
    {
        return level;
    }

    public void score()
    {
        counter.add(1);
    }
    
    public void health()
    {
        healthCounter.subtract(1);
    }
    
    public void spawnZombie(int numZombies)
    {
        for (int i=0; i<numZombies; i++)
        {
            Zombie z = new Zombie();
            addObject(z, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
            while (z.tooNear())
            {
                i--;
                removeObject(z);
                addObject(z, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
            }
        }
}
}
