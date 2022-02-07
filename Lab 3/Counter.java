import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Counter extends UI
{
    private int value = 0;
    private int target = 0;
    private String text;
    private int stringLength;
    
    private int level = 1;
    
    public Counter()
    {
        this("");
    }
    
    public Counter(String prefix)
        {
            text = prefix;
            stringLength = (text.length() + 2) * 16;
    
            setImage(new GreenfootImage(stringLength, 24));
            //color.WHITE
            GreenfootImage image = getImage();
            Font font = image.getFont();
            image.setFont(font.deriveFont(20.0F));
            
            updateImage();
        }
        
    public void act() {
        if(value < target) {
            value++;
            updateImage();
        }
        else if(value > target) {
            value--;
            updateImage();
        }
    }

    public void add(int score)
    {
        target += score;
    }

    public void subtract(int score)
    {
        target -= score;
    }

    public int getValue()
    {
        return value;
    }
    
    public void upLevel()
    {
        level++; //seems repetitive??
        add(1);
    }
    
    public int getLevel()
    {
        return level;
    }

    public void score()
    {
        add(1);
    }
    
    public void health()
    {
        subtract(1);
    }

    /**
     * Make the image
     */
    private void updateImage()
    {
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(text + value, 1, 18);
    }
}
