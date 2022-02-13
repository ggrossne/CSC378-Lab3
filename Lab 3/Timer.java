import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends UI
{
    private int timer = 18000;
    public void act() 
    {
        GreenfootImage img = new GreenfootImage(""+timer / 60, 35, Color.WHITE, new Color(0, 0, 0, 0));
        setImage(img);
        timer--;
        if (timer % 300 == 0)
            ((MyWorld)getWorld()).spawnZombie(2);
        if (timer <= 0) {
            Greenfoot.stop();
        }
    }
}
