import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Squares here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Squares extends Actor
{
    public Squares()
    {
        GreenfootImage image = getImage();
        image.scale(1,1);
        setImage(image);
        
    }
    
    /**
     * Act - do whatever the Squares wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        setSquareX();
        setSquareY();
    }    
    
    public void setSquareX()
    {
        ((MyWorld)getWorld()).setSquareX(getX());
    }
    
    public void setSquareY()
    {
        ((MyWorld)getWorld()).setSquareY(getY());
    }
}
