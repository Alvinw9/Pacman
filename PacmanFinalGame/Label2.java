import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class label here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Label2 extends Actor
{
    private int score;
    
    public void act() 
    {
        score = ((MyWorld)getWorld()).score();
        setImage(new GreenfootImage("Yellow Dots: +5 Points", 25, null, null));
    }    
}