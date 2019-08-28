import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pearl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pearl extends Actor
{
    /**
     * Act - do whatever the Pearl wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Pearl()
    {
        GreenfootImage image = getImage();
        image.scale(15,15);
        setImage(image);
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
