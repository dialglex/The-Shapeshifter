import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bacon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bacon extends Actor
{
    /**
     * Act - do whatever the Bacon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    public void addedToWorld(World world)
    {
        GreenfootImage image = getImage();
        image.scale(image.getHeight() * 6, image.getWidth() * 6);
    }
}
