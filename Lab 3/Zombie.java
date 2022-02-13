import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    private boolean movingVertically = Greenfoot.getRandomNumber(2) == 0;
    int rand_int;
    GifImage rightWalk = new GifImage("Zombie 1 Walking Right-5.gif");
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Zombie()
    {
        Random rand = new Random();
        rand_int = rand.nextInt(3) + 1;
    }
    
    public void act()
    {
        setImage( rightWalk.getCurrentImage() );
        
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        // Add your action code here.
        Actor a = getOneIntersectingObject(Bullet.class);
        MyWorld world = (MyWorld)getWorld();
        followPlayer();
        if (a != null)
        {
            player.score++;
            world.counter.score();
            getWorld().removeObject(a);
            getWorld().removeObject(this);
        }
            
    }
    
    private void followPlayer()
    {
        Actor actor = (Actor)getWorld().getObjects(Player.class).get(0);
        if (Greenfoot.getRandomNumber(50) == 0) movingVertically = Greenfoot.getRandomNumber(2) == 0;
        // change axis if no movement required along current axis
        if ((movingVertically && getY() == actor.getY()) || (!movingVertically && getX() == actor.getX())) movingVertically = !movingVertically;
        // move along current axis
        if (movingVertically) setLocation(getX(), getY()+((int)Math.signum(actor.getY()-getY())) * rand_int);
        else setLocation(getX()+((int)Math.signum(actor.getX()-getX())) * rand_int, getY());
    }
    
    
    
    public boolean tooNear()
    {
        return !getObjectsInRange(200, Player.class).isEmpty(); //100 is the range around the Player where no zombie should be placed. adjust as needed
    }   
}
