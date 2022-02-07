import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Zombie here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zombie extends Actor
{
    private boolean movingVertically = Greenfoot.getRandomNumber(2) == 0;
    
    GifImage rightWalk = new GifImage("Zombie 1 Walking Right-5.gif");
    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage( rightWalk.getCurrentImage() );
        
        Player player = (Player)getWorld().getObjects(Player.class).get(0);
        // Add your action code here.
        Actor a = getOneIntersectingObject(Bullet.class);
        followPlayer();
        if (a != null)
        {
            player.score++;
            getWorld().removeObject(a);
            getWorld().removeObject(this);
        }
            
    }
    
    private void followPlayer()
    {
        Actor actor = (Actor)getWorld().getObjects(Player.class).get(0);
        if (Greenfoot.getRandomNumber(100) == 0) movingVertically = Greenfoot.getRandomNumber(2) == 0;
        // change axis if no movement required along current axis
        if ((movingVertically && getY() == actor.getY()) || (!movingVertically && getX() == actor.getX())) movingVertically = !movingVertically;
        // move along current axis
        if (movingVertically) setLocation(getX(), getY()+(int)Math.signum(actor.getY()-getY()));
        else setLocation(getX()+(int)Math.signum(actor.getX()-getX()), getY());
    }
    
    
    
    public boolean tooNear()
    {
        return !getObjectsInRange(100, Player.class).isEmpty(); //100 is the range around the Player where no zombie should be placed. adjust as needed
    }   
}
