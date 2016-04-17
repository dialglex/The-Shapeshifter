import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hunter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hunter extends Actor
{
    public boolean flipped = false;
    private int shootTimer = 0;
    /**
     * Act - do whatever the Hunter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        shootTimer++;
        if(shootTimer == 25 && flipped == true)
        {
            getWorld().addObject(new Bullet(true), getX(), getY());
            shootTimer = 0;
        }
        else if(shootTimer == 25 && flipped == false)
        {
            getWorld().addObject(new Bullet(false), getX(), getY());
            shootTimer = 0;
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
        if(flipped == true)
        {
            getImage().mirrorHorizontally();
        }
    }
    public Hunter(boolean flipped)
    {
        this.flipped = flipped;
    }
}
