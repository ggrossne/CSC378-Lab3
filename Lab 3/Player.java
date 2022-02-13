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
    public GreenfootSound oop = new GreenfootSound("oop.mp3");
    
    GifImage rightWalk = new GifImage("Rainbow Drag Queen Walking Right.gif");
    GifImage leftWalk = new GifImage("Rainbow Drag Queen Walking Left.gif");
    GifImage rightShoot = new GifImage("Rainbow Drag Queen Walking Right Shooting.gif");
    GifImage leftShoot = new GifImage("Rainbow Drag Queen Walking Left Shooting.gif");
    
    private boolean start = true;
    private boolean leftOrRight = false;
    
    GreenfootSound pew = new GreenfootSound("laser.mp3");
    

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(start)
        {
            start = false;
            setImage( rightWalk.getCurrentImage() );
        }
        
        movement();
        
        if (bulletSpawnRate >= 20)
            spawnBullet();
        else
            bulletSpawnRate++;
            
        Actor a = getOneIntersectingObject(Zombie.class);
        if (a != null)
        {
            oop.play();
            getWorld().removeObject(a);
            ((MyWorld)getWorld()).updateHealth();
        }
        
    }
    
    private void movement()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            setImage( rightWalk.getCurrentImage() );
            leftOrRight = true;
            setLocation(getX()+4, getY());
        }
        else if(Greenfoot.isKeyDown("a"))
        {
            setImage( leftWalk.getCurrentImage() );
            leftOrRight = false;
            setLocation(getX()-4, getY());
        }
        else if(Greenfoot.isKeyDown("s"))
        {
            if(leftOrRight)setImage( rightWalk.getCurrentImage() );
            else setImage( leftWalk.getCurrentImage() );
            
            setLocation(getX(), getY()+4);
        }
        else if(Greenfoot.isKeyDown("w"))
        {
            if(leftOrRight)setImage( rightWalk.getCurrentImage() );
            else setImage( leftWalk.getCurrentImage() );
            
            setLocation(getX(), getY()-4);
        }
    }
    
    private void spawnBullet()
    {
        Bullet bullet = new Bullet();
        getWorld().addObject(bullet, getX(), getY());
        if(Greenfoot.isKeyDown("up"))
        {
            if(leftOrRight)setImage( rightShoot.getCurrentImage() );
            else setImage( leftShoot.getCurrentImage() );
            
            bullet.direction = "up";
        }
        else if(Greenfoot.isKeyDown("down"))
        {
            if(leftOrRight)setImage( rightShoot.getCurrentImage() );
            else setImage( leftShoot.getCurrentImage() );
            
            bullet.direction = "down";
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            setImage( leftShoot.getCurrentImage() );
            leftOrRight = false;
            bullet.direction = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            setImage( rightShoot.getCurrentImage() );
            leftOrRight = true;
            bullet.direction = "right";
        }
        else 
        {
            getWorld().removeObject(bullet);
            return;
        }
        pew.stop();
        pew.play();
        bulletSpawnRate = 0;
    }
}
