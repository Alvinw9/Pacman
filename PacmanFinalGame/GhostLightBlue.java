import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class GhostLightBlue here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GhostLightBlue extends Actor
{
    private boolean turnSpace;
    private boolean up;
    private boolean down;
    private boolean right;
    private boolean left;
    private int time;
    private List<Squares> squareArray;
    private boolean move;
    private int counter;
    private int flip;
    private boolean canTurn;
    private int counter2;
    private int pearlCounter;
    private int moveCounter;
    private int counterInitial;
   
    public GhostLightBlue()
    {
        squareArray = new ArrayList<Squares>();
        GreenfootImage image = getImage();
        image.scale(31,31);
        setImage(image);
        move = true;
        counter = 0;
        canTurn = true;
        counter2 = 0;
        pearlCounter = 0;
        moveCounter = 0;
        counterInitial = 0;
    }
    
    public void act() 
    {
        counter++;
        counter2++;
        counterInitial++;
        rot();
        
        if(isTouching(Pacman.class))
        {
            getWorld().addObject(new Lose(),335,220);
        }
        
        if(counter == 1)
        {
            ((MyWorld)getWorld()).setLightBlue(1);
        }
        
        if(counterInitial == 1 && !((MyWorld)getWorld()).isPearl())
        {
            setRotation(270);
        }
        
        if(counterInitial == 22 && !((MyWorld)getWorld()).isPearl())
        {
            int randomNum = (int)(Math.random()*2);
            if(randomNum == 0)
            {
                setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} 
                        flip++;
            }
            else
            {
                setRotation(0);
            }
        }
        
        if(((MyWorld)getWorld()).isPearl())
         {
            ifPearl();
         }
        
        if(counter == 10)
        {
            move = true;
        }
        
        while(moveCounter<500000)
        {
            setLocation(getX(),getY());
            moveCounter++;
        } 
        
        ifTrue();
        if(flip > 0)
        {
            move(-3);
        }
        else
        {
            move(3);
        }
    }
    
    public void rot()
    {
        if(isTouching(BlueG.class))
        {
            Actor test = getOneIntersectingObject(BlueG.class);
            setRotation(test.getRotation());
        }
    }
    
    public void ifPearl()
    {
        if(pearlCounter < 1 && !isTouching(BlueG.class) && ((MyWorld)getWorld()).turnBlueLB())
        {
            getWorld().addObject(new BlueG(),getX(),getY());
            ((MyWorld)getWorld()).setLightBlueR(getRotation());
            ((MyWorld)getWorld()).setTurnBlueLB(false);
        }
        
         if(((MyWorld)getWorld()).isPearl() && pearlCounter == 2)
        {
            if(isTouching(BlueG.class))
            {
                removeTouching(BlueG.class);
                
            }
            //((MyWorld)getWorld()).setPearl(false);
        }
        
        pearlCounter++;
    }
    
    public void setGhostLightBlueX()
    {
        ((MyWorld)getWorld()).setGhostLightBlueX(getX());
    }
    
    public void setGhostLightBlueY()
    {
        ((MyWorld)getWorld()).setGhostLightBlueY(getY());
    }
    
    public void ifTrue()
    {
        // if(isTouching(Squares.class) && flip == 0)
        // {
            // move(5);
        // }
        // else if(isTouching(Squares.class) && flip > 0)
        // {
            // move(-5);
        // }
        squareArray = getWorld().getObjects(Squares.class);
        for(Squares currentSquare: squareArray)
        {
            if(intersects(currentSquare) && move)
            {
                setLocation(currentSquare.getX(),currentSquare.getY());
                move = false;
                counter = 0;
            }
        }
        
        if(isTouching(Squares.class))
        {
            turnSpace = true;
        }
        
        if(counter2 == 8)
        {
            canTurn = true;
        }
        
        if(turnSpace && canTurn)
        {
            up = true;
            down = true;
            right = true;
            left = true;
            
            if(getX() > 630)
            {
                right = false;
                
                
            }
            if(((getX()>122 && getX()<150)&&(getY()>243 && getY()<271)) || ((getX()>286 && getX()<312)&&(getY()>25&&getY()<53)) || ((getX()>282&&getX()<310)&&(getY()>83&&getY()<111)) || ((getX()>280&&getX()<308)&&(getY()>356&&getY()<384)) || ((getX()>521&&getX()<549)&&(getY()>81&&getY()<109)) || ((getX()>521&&getX()<549)&&(getY()>293&&getY()<321)))
                {
                    right = false;
                }
            if(getX() < 60)
            {                                                                                                                                                                                                                                                                                                      
                left = false;
                
            }
            if(((getX()>123 && getX()<151)&&(getY()>81 && getY()<109)) || ((getX()>122 && getX()<150)&&(getY()>286&&getY()<314)) || ((getX()>363&&getX()<391)&&(getY()>22&&getY()<50)) || ((getX()>362&&getX()<390)&&(getY()>79&&getY()<107)) || ((getX()>362&&getX()<390)&&(getY()>361&&getY()<389)) || ((getX()>520&&getX()<548)&&(getY()>239&&getY()<267)))
                {                                                                                            
                    left = false;
                }
            if(getY() > 360)
            {                                                                                                                                                                                                       
                down = false;
                
            }
            if(((getX()>221 && getX()<249)&&(getY()>285 && getY()<313)) || ((getX()>283 && getX()<311)&&(getY()>142&&getY()<170)) || ((getX()>364&&getX()<392)&&(getY()>142&&getY()<170)) || ((getX()>427&&getX()<455)&&(getY()>285&&getY()<313)))
                {
                    down = false;
                }
            if(getY() < 60)
            {                                                                                                                                                                                                 
                up = false;
                
            }
            if(((getX()>218 && getX()<246)&&(getY()>144 && getY()<172)) || ((getX()>282 && getX()<310)&&(getY()>280&&getY()<308)) || ((getX()>366&&getX()<394)&&(getY()>280&&getY()<308)) || ((getX()>426&&getX()<454)&&(getY()>143&&getY()<171)))
                {
                    up = false;
                }
            
            
            //setRotation(90); flip = 0; //down
            //setRotation(270); flip = 0; //up
            int random = 0;        
            if(isTouching(Squares.class))
            {
                ////
                if(((MyWorld)getWorld()).getPacY()<getY() && ((MyWorld)getWorld()).getPacX()<getX())
                { 
                    if(up && left)
                    {
                        random = (int)(Math.random()*2);
                        if(random == 0)
                        {
                            setRotation(270); flip = 0;
                        }
                        else
                        {
                            setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();}                             flip++;
                        }
                    }
                    else if(up)
                    {
                        setRotation(270); flip = 0;
                    }
                    else if(left)
                    {
                        setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} 
                        flip++;
                    }
                    else
                    {
                        if(down)
                        {
                            setRotation(90); flip = 0;
                        }
                        else
                        {
                            setRotation(0); flip = 0;
                        }
                    }
                }
                else if(((MyWorld)getWorld()).getPacY()<getY() && ((MyWorld)getWorld()).getPacX()>getX())
                {
                    if(up && right)
                    {
                        random = (int)(Math.random()*2);
                        if(random == 0)
                        {
                            setRotation(270); flip = 0;
                        }
                        else
                        {
                            setRotation(0); flip = 0;
                        }
                    }
                    else if(up)
                    {
                        setRotation(270); flip = 0;
                    }
                    else if(right)
                    {
                        setRotation(0); flip = 0;
                    }
                    else
                    {
                        if(down)
                        {
                            setRotation(90); flip = 0;
                        }
                        else
                        {
                            setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} 
                            flip++;
                        }
                    }
                }
                else if(((MyWorld)getWorld()).getPacY()>getY() && ((MyWorld)getWorld()).getPacX()<getX())
                {
                    if(down && left)
                    {
                        random = (int)(Math.random()*2);
                        if(random == 0)
                        {
                            setRotation(90); flip = 0;
                        }
                        else
                        {
                            setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} 
                            flip++;
                        }
                    }
                    else if(down)
                    {
                        setRotation(90); flip = 0;
                    }
                    else if(left)
                    {
                        setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} 
                        flip++;
                    }
                    else
                    {
                        if(up)
                        {
                            setRotation(270); flip = 0;
                        }
                        else
                        {
                            setRotation(0); flip = 0;
                        }
                    }
                }
                else if(((MyWorld)getWorld()).getPacY()>getY() && ((MyWorld)getWorld()).getPacX()>getX())
                {
                    if(down && right)
                    {
                        random = (int)(Math.random()*2);
                        if(random == 0)
                        {
                            setRotation(90); flip = 0;
                        }
                        else
                        {
                            setRotation(0); flip = 0;
                        }
                    }
                    else if(down)
                    {
                        setRotation(90); flip = 0;
                    }
                    else if(right)
                    {
                        setRotation(0); flip = 0;
                    }
                    else
                    {
                        if(up)
                        {
                            setRotation(270); flip = 0;
                        }
                        else
                        {
                            setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} 
                            flip++;
                        }
                    }
                }
                else if(((MyWorld)getWorld()).getPacY()<getY() && ((MyWorld)getWorld()).getPacX()==getX())
                {
                    if(up)
                    {
                        setRotation(270); flip = 0;
                    }
                    if(right)
                    {
                        setRotation(0); flip = 0;
                    }
                    if(left)
                    {
                        setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} 
                        flip++;
                    }
                    if(down)
                    {
                        setRotation(90); flip = 0;
                    }
                }
                else if(((MyWorld)getWorld()).getPacY()>getY() && ((MyWorld)getWorld()).getPacX()==getX())
                {
                    if(down)
                    {
                        setRotation(90); flip = 0;
                    }
                    if(left)
                    {
                        setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} 
                        flip++;
                    }
                    if(right)
                    {
                        setRotation(0); flip = 0;
                    }
                    if(up)
                    {
                        setRotation(270); flip = 0;
                    }
                }
                else if(((MyWorld)getWorld()).getPacY()==getY() && ((MyWorld)getWorld()).getPacX()<getX())
                {
                    if(left)
                    {
                        setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} 
                        flip++;
                    }
                    if(up)
                    {
                        setRotation(270); flip = 0;
                    }
                    if(down)
                    {
                        setRotation(90); flip = 0;
                    }
                    if(right)
                    {
                        setRotation(0); flip = 0;
                    }
                }
                else 
                {
                    if(right)
                    {
                        setRotation(0); flip = 0;
                    }
                    if(down)
                    {
                        setRotation(90); flip = 0;
                    }
                    if(up)
                    {
                        setRotation(270); flip = 0;
                    }
                    if(left)
                    {
                        setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} 
                        flip++;
                    }
                }
            ////
                counter2 = 0;
                canTurn = false;
            }
        }
        
         
    }
}

