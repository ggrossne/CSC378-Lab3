import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public Counter counter = new Counter("Score: ");
    Counter levelCounter = new Counter("Level: ");
    Counter healthCounter = new Counter("Health: ");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a 
        //cell size of 1x1 pixels.
        super(1200, 800, 1);

        addObject(new Player(), 600, 400);
        addObject(new UI(), 30, 20);
        addObject(new Timer(), 30, 20);

        addObject(counter, 535, 30);

        levelCounter.add(1);
        addObject(levelCounter, 540, 60);

        healthCounter.add(1);
        addObject(healthCounter, 540, 90);
        prepare();
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
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
