import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends Actor
{
    private int timer = 18000;
    public void act() 
    {
        timer--;
        if (timer % 300 == 0)
            ((MyWorld)getWorld()).spawnZombie(1);
        if (timer <= 0) {
            Greenfoot.stop();
        }
    }
}
