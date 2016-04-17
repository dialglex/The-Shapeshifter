import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(768, 768, 1); 
        GreenfootImage image = getBackground();
        image.scale(image.getHeight() * 6, image.getWidth() * 6);
        char[][] terrain = {
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'e', 'e', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'a', 'b', 'b', 'a', 'a', 'a', 'a', 'b', 'b', 'a', 'a', 'a', 'a', 'b', 'b', 'a'},
            {'a', 'a', 'a', 'f', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'h', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'a', 'b', 'b', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b', 'b', 'a'},
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a', 'b', 'b', 'a', 'a', 'a', 'a', 'b', 'b', 'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b', 'b', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'p', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
            {'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}
            
            // b = block, p = player, e = end, h = hunter, f = flipped hunter
        };
        for(int y = 0; y < terrain.length; y++){
            for(int x = 0; x < terrain[y].length; x++){
                if(terrain[y][x] == 'b'){
                    addObject(new Block(), 2 * 12 + x * 4 * 12, 2 * 12 + y * 4 * 12);
                }
                if(terrain[y][x] == 'p'){
                    addObject(new Player(), 2 * 12 + x * 4 * 12, 2 * 12 + y * 4 * 12);
                }
                if(terrain[y][x] == 'e'){
                    addObject(new Bacon(), 2 * 12 + x * 4 * 12, 2 * 12 + y * 4 * 12);
                }
                if(terrain[y][x] == 'h'){
                    addObject(new Hunter(false), 2 * 12 + x * 4 * 12, 2 * 12 + y * 4 * 12);
                }
                if(terrain[y][x] == 'f'){
                    addObject(new Hunter(true), 2 * 12 + x * 4 * 12, 2 * 12 + y * 4 * 12);
                }
            }
        }
    }
}
