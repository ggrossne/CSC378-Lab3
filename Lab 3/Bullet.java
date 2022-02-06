import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    String direction;
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(direction == "right") setLocation(getX()+2, getY());
        else if(direction == "left") setLocation(getX()-2, getY());
        else if(direction == "down") setLocation(getX(), getY()+2);
        else if(direction == "up") setLocation(getX(), getY()-2);
        
        if (isAtEdge())
            getWorld().removeObject(this);
    }
}
