import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pacman here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pacman extends Actor
{
    private boolean going;
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;
    private int lives;
    private boolean canTurn;
    private int turn;
    private boolean touchPearl;
    
    public Pacman()
    {
        GreenfootImage image = getImage();
        image.scale(30, 30);
        lives = 3;
        canTurn = true;
        touchPearl = false;
    }
    
    /**
     * Act - do whatever the Pacman wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void setPacX()
    {
        ((MyWorld)getWorld()).setPacX(getX());
    }
    
    public void setPacY()
    {
        ((MyWorld)getWorld()).setPacY(getY());
    }
    
    public void pearl()
    {
        ((MyWorld)getWorld()).setPearl(true);
    }
    
    public void act() 
    {
        setPacX();
        setPacY();
        turn++;
        touchPearl = false;
        
        if(isTouching(Pearl.class))
        {
            touchPearl = true;
        }
        
       
        
        if(touchPearl)
        {
            pearl();
            
        }
        Actor pearl = getOneIntersectingObject(Pearl.class);
        if(isTouching(Pearl.class))
        {
            getWorld().addObject(new Bomb(),335,220);
        }
        getWorld().removeObject(pearl);
        
        Actor dots = getOneIntersectingObject(YellowDots.class);
        if(isTouching(YellowDots.class))
        {
            ((MyWorld)getWorld()).setScore(((MyWorld)getWorld()).score()+5);
            ((MyWorld)getWorld()).numYellowDots(1);
        }
        getWorld().removeObject(dots);
        
        Actor blueG = getOneIntersectingObject(BlueG.class);
        if(isTouching(BlueG.class) && ((MyWorld)getWorld()).touchingRed())
        {
            ((MyWorld)getWorld()).setRed(0);
        }
        if(isTouching(BlueG.class) && ((MyWorld)getWorld()).touchingPink())
        {
            ((MyWorld)getWorld()).setPink(0);
        }
        if(isTouching(BlueG.class) && ((MyWorld)getWorld()).touchingYellow())
        {
            ((MyWorld)getWorld()).setYellow(0);
        }
        if(isTouching(BlueG.class) && ((MyWorld)getWorld()).touchingLightBlue())
        {
            ((MyWorld)getWorld()).setLightBlue(0);
        }
        if(isTouching(BlueG.class))
        {
            ((MyWorld)getWorld()).setScore(((MyWorld)getWorld()).score()+50);
        }
        getWorld().removeObject(blueG);
        
        if(turn == 3)
        {
            canTurn = true;
        }
        if(going)
            move(4);
        if(canTurn)
        {
            if(Greenfoot.isKeyDown("up"))
            {
                setRotation(270);
                down = false;
                left = false;
                right = false;
                up = true;
                going = true;
                canTurn = false;
                turn = 0;
            }
            if(Greenfoot.isKeyDown("down"))
            {
                setRotation(90);
                down = true;
                left = false;
                right = false;
                up = false;
                going = true;
                canTurn = false;
                turn = 0;
            }
            if(Greenfoot.isKeyDown("left"))
            {
                setRotation(180);
                down = false;
                left = true;
                right = false;
                up = false;
                going = true;
                canTurn = false;
                turn = 0;
                //setLocation(getX(), getY() + 3);
            }
            if(Greenfoot.isKeyDown("right"))
            {
                setRotation(0);
                
                down = false;
                left = false;
                right = true;
                up = false;
                going = true;
                canTurn = false;
                turn = 0;
                //setLocation(getX(), getY() + 3);
            }
        }
        if(isTouching(Wall.class))
        {
            
            going = false;
            if(up)
                setLocation(getX(), getY() + 6);
            if(down)
                setLocation(getX(), getY() - 6);
            if(left)
                setLocation(getX() + 6 , getY());
            if(right) 
                setLocation(getX() - 6, getY());
            canTurn = false;
            turn = 0;
        }
        
        if(isAtEdge())
        {
            int pos = Math.abs(getX() - 670);
            setLocation(pos, getY());
        }
        
        //ifTouchingYellowDots();
        //ifTouchingBlueG();
        //ifTouchingPearl();
    }    
    
    /*
    public void ifTouchingYellowDots()
    {
        removeTouching(YellowDots.class);
        getLabel.setScore(getLabel.getScore +5);
    }
    */
    
   /*
    public void ifTouchingBlueG()
    {
        removeTouching(BlueG);
        getLabel.setScore(getLabel.getScore +100);
    }
    
    public void ifTouchingPearl()
    {
        removeTouching(Pearl);
    }
    */
}
