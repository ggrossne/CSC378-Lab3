import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends Actor
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    GreenfootImage title = new GreenfootImage("Title Screen.png");
    GreenfootImage controlscreen = new GreenfootImage("Controls Screen.png");
    GreenfootImage backstoryscreen = new GreenfootImage("Backstory Screen.jpg");

    private boolean firstTime = true;
    
    public void act()
    {
        if(firstTime)setImage(title);
        if(Greenfoot.isKeyDown("space") && firstTime)
        {
            firstTime = false;
            setImage(backstoryscreen);
        }
        if(Greenfoot.mouseClicked(this) && !firstTime)
        {
            Greenfoot.setWorld(new MyWorld());
            getWorld().removeObject(this);
        }
        if(Greenfoot.isKeyDown("c"))
        {
            //getWorld().removeObject(this);
            setImage(controlscreen);
        }

    }
}
