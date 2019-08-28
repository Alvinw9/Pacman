import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class Turtle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlueG extends Actor
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
    private int newGhostCounter;
    private boolean red;
    private boolean yellow;
    private boolean pink;
    private boolean lightBlue;
    
    public BlueG()
    {
        squareArray = new ArrayList<Squares>();
        GreenfootImage image = getImage();
        image.scale(30,30);
        setImage(image);
        move = true;
        counter = 0;
        canTurn = true;
        counter2 = 0;
        pearlCounter = 0;
        newGhostCounter = 0;
    }
    
    
    public void act() 
    {
        
        counter++;
        counter2++;
        rotation();
        ifTrue();
        if(((MyWorld)getWorld()).isPearl())
        {
            ifPearl();
        }
        
        if(counter == 20)
        {
            move = true;
        }
        ifTrue();
        if(flip > 0)
        {
            move(-2);
        }
        else
        {
            move(2);
        }
    }   
    
    public void rotation()
    {
        ((MyWorld)getWorld()).setBlueGR(getRotation());
    }
    
    public void ifPearl()
    {
        // if(isTouching(Pacman.class) && red)
        // {
            // ((MyWorld)getWorld()).setRed(0);
        // }
        // if(isTouching(Pacman.class) && yellow)
        // {
            // ((MyWorld)getWorld()).setYellow(0);
        // }
        // if(isTouching(Pacman.class) && pink)
        // {
            // ((MyWorld)getWorld()).setPink(0);
        // }
        // if(isTouching(Pacman.class) && lightBlue)
        // {
            // ((MyWorld)getWorld()).setLightBlue(0);
        // }
        
        if(((MyWorld)getWorld()).isPearl() && pearlCounter < 1)
        {
            if(isTouching(GhostRed.class))
            {
                setRotation(((MyWorld)getWorld()).RedR());
                red = true;
                //((MyWorld)getWorld()).setTouchingRed(true);
            }
            if(isTouching(GhostYellow.class))
            {
                setRotation(((MyWorld)getWorld()).YellowR());
                yellow = true;
                //((MyWorld)getWorld()).setTouchingYellow(true);
                
            }
            if(isTouching(GhostPink.class))
            {
                setRotation(((MyWorld)getWorld()).PinkR());
                pink = true;
                //((MyWorld)getWorld()).setTouchingPink(true);
            }
            if(isTouching(GhostLightBlue.class))
            {
                setRotation(((MyWorld)getWorld()).LightBlueR());
                lightBlue = true;
                //((MyWorld)getWorld()).setTouchingLightBlue(true);
                
            }
            Actor first = getOneIntersectingObject(GhostRed.class);
            getWorld().removeObject(first);
            Actor second = getOneIntersectingObject(GhostLightBlue.class);
            getWorld().removeObject(second);
            Actor third = getOneIntersectingObject(GhostYellow.class);
            getWorld().removeObject(third);
            Actor fourth = getOneIntersectingObject(GhostPink.class);
            getWorld().removeObject(fourth);
        }
        
        
        if(((MyWorld)getWorld()).isPearl() && pearlCounter > 70)
        {
            if(newGhostCounter == 0 && red)
            getWorld().addObject(new GhostRed(),getX(),getY());
            if(newGhostCounter == 0 && yellow)
            getWorld().addObject(new GhostYellow(),getX(),getY());
            if(newGhostCounter == 0 && pink)
            getWorld().addObject(new GhostPink(),getX(),getY());
            if(newGhostCounter == 0 && lightBlue)
            getWorld().addObject(new GhostLightBlue(),getX(),getY());
            
            newGhostCounter++;
        }
        
        pearlCounter++;
    }
    
    public void setBlueCX()
    {
        ((MyWorld)getWorld()).setBlueCX(getX());
    }
    
    public void setBlueCY()
    {
        ((MyWorld)getWorld()).setBlueCY(getY());
    }
    
    public void ifTrue()
    {
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
        
        if(counter2 == 6)
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
            
            
            
            int random = 0;
            if(isTouching(Squares.class))
            { 
                
                if(Math.abs(((MyWorld)getWorld()).getPacY()-getY()) < 300 && Math.abs(((MyWorld)getWorld()).getPacX()-getX()) < 200)
                {
                    if(((MyWorld)getWorld()).getPacY()<getY() && ((MyWorld)getWorld()).getPacX()<getX())
                    {
                        if(down && right)
                        {
                            random = (int)(Math.random()*2);
                            if(random == 0)
                            {
                                setRotation(90); flip =0;
                            }
                            else
                            {
                                setRotation(0); flip =0;
                            }
                        }
                        else if(right)
                        {
                            setRotation(0); flip =0;
                        }
                        else if(down)
                        {
                            setRotation(90); flip =0;
                        }
                        else
                        {
                            if(up)
                            {
                                setRotation(270); flip =0;
                            }
                            else
                            {
                                setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                            }
                        }
                    }
                    else if(((MyWorld)getWorld()).getPacY()<getY() && ((MyWorld)getWorld()).getPacX()>getX())
                    {
                        if(down && left)
                        {
                            random = (int)(Math.random()*2);
                            if(random == 0)
                            {
                                setRotation(90); flip =0;
                            }
                            else
                            {
                                setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                            }
                        }
                        else if(left)
                        {
                            setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                        else if(down)
                        {
                            setRotation(90); flip =0;
                        }
                        else
                        {
                            if(up)
                            {
                                setRotation(270); flip =0;
                            }
                            else
                            {
                                setRotation(0); flip =0;
                            }
                        }
                    }
                    else if(((MyWorld)getWorld()).getPacY()>getY() && ((MyWorld)getWorld()).getPacX()<getX())
                    {
                        if(up && right)
                        {
                            random = (int)(Math.random()*2);
                            if(random == 0)
                            {
                                setRotation(270); flip =0;
                            }
                            else
                            {
                                setRotation(0); flip =0;
                            }
                        }
                        else if(right)
                        {
                            setRotation(0); flip =0;
                        }
                        else if(up)
                        {
                            setRotation(270); flip =0;
                        }
                        else
                        {
                            if(down)
                            {
                                setRotation(90); flip =0;
                            }
                            else
                            {
                                setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                            }
                        }
                    }
                    else if(((MyWorld)getWorld()).getPacY()>getY() && ((MyWorld)getWorld()).getPacX()>getX())
                    {
                        if(up && left)
                        {
                            random = (int)(Math.random()*2);
                            if(random == 0)
                            {
                                setRotation(270); flip =0;
                            }
                            else
                            {
                                setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                            }
                        }
                        else if(left)
                        {
                            setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                        else if(up)
                        {
                            setRotation(270); flip =0;
                        }
                        else
                        {
                            if(down)
                            {
                                setRotation(90); flip =0;
                            }
                            else
                            {
                                setRotation(0); flip =0;
                            }
                        }
                    }
                    else if(((MyWorld)getWorld()).getPacY()<getY() && ((MyWorld)getWorld()).getPacX()==getX())
                    {
                        if(right)
                        {
                            setRotation(0); flip =0;
                        }
                        if(left)
                        {
                            setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                        if(down)
                        {
                            setRotation(90); flip =0;
                        }
                        if(up)
                        {
                            setRotation(270); flip =0;
                        }
                    }
                    else if(((MyWorld)getWorld()).getPacY()>getY() && ((MyWorld)getWorld()).getPacX()==getX())
                    {
                        if(left)
                        {
                            setRotation(0); if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                        if(right)
                        {
                            setRotation(0); flip =0;
                        }
                        if(up)
                        {
                            setRotation(270); flip =0;
                        }
                        if(down)
                        {
                            setRotation(90); flip =0;
                        }
                    }
                    else if(((MyWorld)getWorld()).getPacY()==getY() && ((MyWorld)getWorld()).getPacX()<getX())
                    {
                        if(up)
                        {
                            setRotation(270); flip =0;
                        }
                        if(down)
                        {
                            setRotation(90); flip =0;
                        }
                        if(right)
                        {
                            setRotation(0); flip =0;
                        }
                        if(left)
                        {
                            setRotation(0);if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                    }
                    else 
                    {
                        if(down)
                        {
                            setRotation(90); flip =0;
                        }
                        if(up)
                        {
                            setRotation(270); flip =0;
                        }
                        if(left)
                        {
                            setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                        if(right)
                        {
                            setRotation(0); flip =0;
                        }
                    }
                }  
                else
                {
                    if(up && down && right && left)
                    {
                        random = (int)(Math.random()*4);
                        if(random == 0)
                        {
                            setRotation(0); flip =0;
                        }
                        else if(random == 1)
                        {
                            setRotation(90); flip =0;
                        }
                        else if(random == 2)
                        {
                            setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                        else
                        {
                            setRotation(270); flip =0;
                        }
                    }
                    else if(up && down && right)
                    {
                        random = (int)(Math.random()*3);
                        if(random == 0)
                        {
                            setRotation(0); flip =0;
                        }
                        else if(random == 1)
                        {
                            setRotation(90); flip =0;
                        }
                        else
                        {
                            setRotation(270); flip =0;
                        }
                    }
                    else if(up && down && left)
                    {
                        random = (int)(Math.random()*3);
                        if(random == 0)
                        {
                            setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                        else if(random == 1)
                        {
                            setRotation(90); flip =0;
                        }
                        else
                        {
                            setRotation(270); flip =0;
                        }
                    }
                    else if(up && left && right)
                    {
                        random = (int)(Math.random()*3);
                        if(random == 0)
                        {
                            setRotation(0); flip =0;
                        }
                        else if(random == 1)
                        {
                            setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                        else
                        {
                            setRotation(270); flip =0;
                        }
                    }
                    else if(left && down && right)
                    {
                        random = (int)(Math.random()*3);
                        if(random == 0)
                        {
                            setRotation(0); flip =0;
                        }
                        else if(random == 1)
                        {
                            setRotation(90); flip =0;
                        }
                        else
                        {
                            setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                    }
                    else if(up && down)
                    {
                        random = (int)(Math.random()*2);
                        if(random == 0)
                        {
                            setRotation(270); flip =0;
                        }
                        else
                        {
                            setRotation(90); flip =0;
                        }
                    }
                    else if(up && right)
                    {
                        random = (int)(Math.random()*2);
                        if(random == 0)
                        {
                            setRotation(270); flip =0;
                        }
                        else
                        {
                            setRotation(0); flip =0;
                        }
                    }
                    else if(up && left)
                    {
                        random = (int)(Math.random()*2);
                        if(random == 0)
                        {
                            setRotation(270); flip =0;
                        }
                        else
                        {
                            setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                    }
                    else if(left && down)
                    {
                        random = (int)(Math.random()*2);
                        if(random == 0)
                        {
                            setRotation(90); flip =0;
                        }
                        else
                        {
                            setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                    }
                    else if(right && down)
                    {
                        random = (int)(Math.random()*2);
                        if(random == 0)
                        {
                            setRotation(0); flip =0;
                        }
                        else
                        {
                            setRotation(90); flip =0;
                        }
                    }
                    else if(right && left)
                    {
                        random = (int)(Math.random()*2);
                        if(random == 0)
                        {
                            setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                        }
                        else
                        {
                            setRotation(0); flip =0;
                        }
                    }
                    else if(up)
                    {
                        setRotation(270); flip =0;
                    }
                    else if(down)
                    {
                        setRotation(90); flip =0;
                    }
                    else if(right)
                    {
                        setRotation(0); flip =0;
                    }
                    else 
                    {
                        setRotation(0);  if(flip == 0) {getImage().mirrorHorizontally();} flip++;
                    }
                }
                counter2 = 0;
                canTurn = false;
            }
        }
    }
}
