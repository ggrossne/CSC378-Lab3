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
    
    GifImage bullet = new GifImage("Rainbow Projectile-2.gif");
    
    
    public void act()
    {
        setImage( bullet.getCurrentImage() );
        
        if(direction == "right") setLocation(getX()+5, getY());
        else if(direction == "left") setLocation(getX()-5, getY());
        else if(direction == "down") {
            setRotation(90);
            setLocation(getX(), getY()+5);
        }
        else if(direction == "up") {
            setRotation(90);
            setLocation(getX(), getY()-5);
        }
        
        
        
        if (isAtEdge())
            getWorld().removeObject(this);
    }
}
