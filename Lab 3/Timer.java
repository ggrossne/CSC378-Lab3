import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Timer extends UI
{
    private int timer = 18000;
    private int spawnrate = 300;
    private int spawncount = 300;
    public void act() 
    {
        //GreenfootImage img = new GreenfootImage(""+timer / 60, 35, Color.WHITE, new Color(0, 0, 0, 0));
        //setImage(img);
        Random rand = new Random();
        timer--;
        spawncount++;
        if (spawncount >= spawnrate) {
            int rand_int = rand.nextInt(3) + 2;
            ((MyWorld)getWorld()).spawnZombie(rand_int);
            spawnrate -= 2;
            spawncount = 0;
        }
        if (timer <= 0) {
            Greenfoot.stop();
        }
    }
}
