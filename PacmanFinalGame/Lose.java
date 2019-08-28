import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lose extends Actor
{
    private int score;
    
    public void act() 
    {
        score = ((MyWorld)getWorld()).score();
        setImage(new GreenfootImage("You're not worthy \n Your Score: " +score, 85, Color.WHITE, null));
        Greenfoot.stop();
    }    
}
