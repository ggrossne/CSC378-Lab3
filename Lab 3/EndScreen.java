import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EndScreen extends Actor
{
    /**
     * Act - do whatever the EndScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage ending = new GreenfootImage("End Screen.jpg");
    
    public void act()
    {
        // Add your action code here.
        setImage(ending);
        Greenfoot.stop();
        
    }
}
