import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    int bulletSpawnRate = 20;
    int score = 0;
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        movement();
        if (bulletSpawnRate >= 20)
            spawnBullet();
        else
            bulletSpawnRate++;
        
    }
    
    private void movement()
    {
        if(Greenfoot.isKeyDown("d")) setLocation(getX()+2, getY());
        else if(Greenfoot.isKeyDown("a")) setLocation(getX()-2, getY());
        else if(Greenfoot.isKeyDown("s")) setLocation(getX(), getY()+2);
        else if(Greenfoot.isKeyDown("w")) setLocation(getX(), getY()-2);
    }
    
    private void spawnBullet()
    {
        Bullet bullet = new Bullet();
        getWorld().addObject(bullet, getX(), getY());
        if(Greenfoot.isKeyDown("up")) bullet.direction = "up";
        else if(Greenfoot.isKeyDown("down")) bullet.direction = "down";
        else if(Greenfoot.isKeyDown("left")) bullet.direction = "left";
        else if(Greenfoot.isKeyDown("right")) bullet.direction = "right";
        else {
            getWorld().removeObject(bullet);
            return;
        }
        bulletSpawnRate = 0;
    }
}
