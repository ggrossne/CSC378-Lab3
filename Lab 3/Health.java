import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health extends UI
{
    GreenfootImage heart = new GreenfootImage("heart.png");
    public Health()
    {
        heart.scale(heart.getWidth()/8, heart.getHeight()/8);
    }
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(heart);
    }
}
