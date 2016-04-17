import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    public boolean reversed = false;
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(reversed == true)
        {
            setLocation(getX() + 6, getY());
        }
        else if(reversed == false)
        {
            setLocation(getX() - 6, getY());
        }
        
        if(getX() == 0 || getX() == 767)
        {
            destroy();
        }
    }    
    public void destroy()
    {
        getWorld().removeObject(this);
    }
    public void addedToWorld(World world)
    {
        GreenfootImage image = getImage();
        image.scale(image.getHeight() * 6, image.getWidth() * 6);
        if(reversed == true)
        {
            getImage().mirrorHorizontally();
        }
    }
    public Bullet(boolean reversed)
    {
        this.reversed = reversed;
    }    
}    
