import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

//there are initial yellow dots

public class MyWorld extends World
{
    private boolean win;
    private boolean lose;
    private int numYellowDots;
    
    private int ghostRedX;
    private int ghostRedY;
    private int ghostPinkX;
    private int ghostPinkY;
    private int ghostLightBlueX;
    private int ghostLightBlueY;
    private int ghostYellowX;
    private int ghostYellowY;
    
    private int blueGX;
    private int blueGY;
    private int squareX;
    private int squareY;
    private int pacX;
    private int pacY;
    private boolean pearl;
    private int pearlCount;
    
    private int RedR;
    private int YellowR;
    private int PinkR;
    private int LightBlueR;
    private int BlueGR;
    
    private int red;
    private int yellow;
    private int pink;
    private int lightBlue;
    
    private int counter;
    
    private boolean turnBlueR;
    private boolean turnBlueP;
    private boolean turnBlueY;
    private boolean turnBlueLB;
    
    private boolean touchingRed;
    private boolean touchingPink;
    private boolean touchingYellow;
    private boolean touchingLightBlue;
    
    private int score;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {   
        super(675, 450, 1, false); 
        pearlCount = 2;
        pearl = false;
        red = 0;
        yellow = 0;
        lightBlue = 0;
        counter = 0;
        turnBlueR = true;
        turnBlueP = true;
        turnBlueY = true;
        turnBlueLB = true;
        touchingRed = true;
        touchingPink = true;
        touchingYellow = true;
        touchingLightBlue = true;
        score = 0;
        //top
        Wall border = new Wall();
        GreenfootImage image = border.getImage();
        image.scale(image.getWidth(), image.getHeight()-200);
        border.setImage(image);
        Wall border2 = new Wall();
        GreenfootImage image2 = border2.getImage();
        border2.setImage(image);
        Wall border3 = new Wall();
        border3.setImage(image);
        Wall border4 = new Wall();
        border4.setImage(image);
        addObject(border, image.getWidth()/2, 0);
        addObject(border2, image.getWidth()*3/2, 0);
        addObject(border3, image.getWidth()*5/2, 0);
        
        
        //bottom
        Wall bot = new Wall();
        GreenfootImage imageB = bot.getImage();
        imageB.scale(imageB.getWidth(), imageB.getHeight()-175);
        bot.setImage(imageB);
        addObject(bot, imageB.getWidth() / 2, 425);
        Wall bot2 = new Wall();
        bot2.setImage(imageB);
        addObject(bot2, imageB.getWidth()*3/2, 425);
        Wall bot3 = new Wall();
        bot3.setImage(imageB);
        addObject(bot3, imageB.getWidth()*5/2, 425);
        
        
        //left-side
        Wall left = new Wall();
        GreenfootImage imageL = left.getImage();
        imageL.scale(imageL.getWidth() - 200, imageL.getHeight());
        left.setImage(imageL);
        addObject(left, 0, 120);
        Wall left1 = new Wall();
        left1.setImage(imageL);
        addObject(left1, 0, 400);
        
        //right-side
        Wall right = new Wall();
        right.setImage(imageL);
        addObject(right, 675, 120);
        Wall right1 = new Wall();
        right1.setImage(imageL);
        addObject(right1, 675, 400);
        
        //inner part
        
        //above the box
        Wall aBig = new Wall();
        GreenfootImage imageBig = aBig.getImage();
        imageBig.scale(50, 60);
        aBig.setImage(imageBig);
        addObject(aBig, 87, 87);
        Wall bBig = new Wall();
        bBig.setImage(imageBig);
        addObject(bBig, 87, 200);
        Wall cBig = new Wall();
        cBig.setImage(imageBig);
        addObject(cBig, 87, 315);
        Wall dBig = new Wall();
        dBig.setImage(imageBig);
        addObject(dBig, 588, 87);
        Wall eBig = new Wall();
        eBig.setImage(imageBig);
        addObject(eBig, 588, 200);
        Wall rBig = new Wall();
        rBig.setImage(imageBig);
        addObject(rBig, 588, 315);
        
        Wall aSkin = new Wall();
        GreenfootImage imageSkin = aSkin.getImage();
        imageSkin.scale(100, 10);
        aSkin.setImage(imageSkin);
        addObject(aSkin, 215, 63);
        Wall bSkin = new Wall();
        bSkin.setImage(imageSkin);
        addObject(bSkin, 455, 63);
        Wall cSkin = new Wall();
        cSkin.setImage(imageSkin);
        addObject(cSkin, 215, 125);
        Wall dSkin = new Wall();
        dSkin.setImage(imageSkin);
        addObject(dSkin, 455, 125);
        
        Wall amid = new Wall();
        GreenfootImage imagemid = amid.getImage();
        imagemid.scale(20, 120);
        amid.setImage(imagemid);
        addObject(amid, 337, 70);
        Wall bmid = new Wall();
        bmid.setImage(imagemid);
        addObject(bmid, 337, 380);
        
        Wall side = new Wall();
        GreenfootImage imageSide = side.getImage();
        imageSide.scale(10, 100);
        side.setImage(imageSide);
        addObject(side, 195, 230);
        Wall sideB = new Wall();
        sideB.setImage(imageSide);
        addObject(sideB, 480, 230);
        
        Wall botMid = new Wall();
        GreenfootImage imageBMid = botMid.getImage();
        imageBMid.scale(100, 20);
        botMid.setImage(imageBMid);
        addObject(botMid, 215, 340);
        Wall botMidb = new Wall();
        botMidb.setImage(imageBMid);
        addObject(botMidb, 460, 340);
        
        
        //ghost box(minus gate)
        Wall midS = new Wall();
        GreenfootImage imageS = midS.getImage();
        imageS.scale(4, 84);
        midS.setImage(imageS);
        addObject(midS, 272, 225);
        Wall midS2 = new Wall();
        midS2.setImage(imageS);
        addObject(midS2, 402, 225);
        Wall midB = new Wall();
        GreenfootImage imageM = midB.getImage();
        imageM.scale( 134, 4);
        midB.setImage(imageM);
        addObject(midB, 337, 267);
        Wall top1 = new Wall();
        GreenfootImage imageT = top1.getImage();
        imageT.scale(46, 4);
        top1.setImage(imageT);
        Wall top2 = new Wall();
        top2.setImage(imageT);
        addObject(top1, 381, 183);
        addObject(top2, 293, 183);
        
        //ghost box gate
        
        
        //candies
        
        Lives life1 = new Lives();
        addObject(life1, 30, 425);
        // Lives life2 = new Lives();
        // addObject(life2, 65, 425);
        // Lives life3 = new Lives();
        // addObject(life3, 100, 425);
      
        addObject(new Label2(),250,425);
        addObject(new Label3(),480,425);
        
        prepare();
        Pacman pman = new Pacman();
        addObject(pman, 337, 295);
        
    
        for(int i = 35; i < 325; i+=25) 
        {
            YellowDots dots = new YellowDots();
            addObject(dots,i,35);
            numYellowDots++;
        }
        for(int i = 360; i < 650; i+=25)
        {
            YellowDots dots = new YellowDots();
            addObject(dots,i,35);
            numYellowDots++;
        }
        for(int i = 35; i < 380; i+=25)
        {
            YellowDots dots = new YellowDots();
            addObject(dots,35,i);
            numYellowDots++;
        }
        for(int i = 60; i < 380; i+=25)
        {
            YellowDots dots = new YellowDots();
            addObject(dots,635,i);
            numYellowDots++;
        }
        for(int i = 35; i < 325; i+=25)
        {
            YellowDots dots = new YellowDots();
            addObject(dots,i,378);
            numYellowDots++;
        }
        for(int i = 360; i < 650; i+=25)
        {
            YellowDots dots = new YellowDots();
            addObject(dots,i,378);
            numYellowDots++;
        }
        
       act();
    }
    
    public void act()
    {
        counter++;
        if(numYellowDots == 0)
        {
            addObject(new Win(),335,220);
        }
        // if(pearlCount < 2)
        // {
            // pearl = true;
        // }
        // else
        // {
            // pearl = false;
        // }
        if(red<1 && touchingRed)// && !pearl)
        {
            GhostRed test = new GhostRed();
            addObject(test,335,220);
            red++;
            counter = 0;
            touchingRed = false;
        }
        if(pink<1 && counter == 70 && touchingPink)// && !pearl)
        {
            GhostPink ghostpink = new GhostPink();
            addObject(ghostpink,372,165);
            ghostpink.setLocation(335,220);
            pink++;
            counter = 0;
            touchingPink = false;
        }
        if(lightBlue<1 && counter == 70 && touchingLightBlue)// && !pearl)
        {
            GhostLightBlue ghostlightblue = new GhostLightBlue();
            addObject(ghostlightblue,243,304);
            ghostlightblue.setLocation(335,220);
            lightBlue++;
            counter = 0;
            touchingLightBlue = false;
        }
        if(yellow<1 && counter == 70 && touchingYellow)// && !pearl)
        {
            GhostYellow ghostyellow = new GhostYellow();
            addObject(ghostyellow,492,317);
            ghostyellow.setLocation(335,220);
            yellow++;
            counter = 0;
            touchingYellow = false;
        }
        
        
        
        
        
        
        // if(red<1 && touchingRed && !pearl)
        // {
            // System.out.println("REDNEW"+ counter);
            // GhostRed test = new GhostRed();
            // addObject(test,335,220);
            // red++;
            // counter = 0;
            // touchingRed = false;
        // }
        // if(pink<1  && touchingPink && !pearl)
        // {System.out.println("pinknew"+ counter);
            // //GhostPink ghostpink = ;
            // addObject(new GhostPink(),335,220);  //addObject(new GhostPink(),372,165);
            // //ghostpink.setLocation(335,220);
            // pink++;
            // counter = 0;
            // touchingPink = false;
        // }
        // if(lightBlue<1  && touchingLightBlue && !pearl)
        // {System.out.println("lbnew"+ counter);
            // GhostLightBlue ghostlightblue = new GhostLightBlue();
            // addObject(ghostlightblue,243,304);
            // ghostlightblue.setLocation(335,220);
            // lightBlue++;
            // counter = 0;
            // touchingLightBlue = false;
        // }
        // if(yellow<1  && touchingYellow && !pearl)
        // {System.out.println("yellnew" + counter);
            // GhostYellow ghostyellow = new GhostYellow();
            // addObject(ghostyellow,492,317);
            // ghostyellow.setLocation(335,220);
            // yellow++;
            // counter = 0;
            // touchingYellow = false;
        // }
    }
    
    private void prepare()
    {
        Squares squares = new Squares();
        addObject(squares,527,255);

        removeObject(squares);
        Squares squares2 = new Squares();
        addObject(squares2,375,157);
        Squares squares3 = new Squares();
        addObject(squares3,301,158);
        Squares squares4 = new Squares();
        addObject(squares4,388,91);
        squares4.setLocation(378,94);
        Squares squares5 = new Squares();
        addObject(squares5,383,41);
        Squares squares6 = new Squares();
        addObject(squares6,531,46);
        squares6.setLocation(538,37);
        Squares squares7 = new Squares();
        addObject(squares7,645,43);
        squares7.setLocation(638,37);
        Squares squares8 = new Squares();
        addObject(squares8,511,94);
        squares8.setLocation(537,95);
        Squares squares9 = new Squares();
        addObject(squares9,634,138);
        squares9.setLocation(636,144);
        Squares squares10 = new Squares();
        addObject(squares10,634,264);
        squares10.setLocation(639,261);
        Squares squares11 = new Squares();
        addObject(squares11,526,149);
        squares11.setLocation(522,160);
        Squares squares12 = new Squares();
        addObject(squares12,423,168);
        squares12.setLocation(441,171);
        squares12.setLocation(440,156);
        Squares squares13 = new Squares();
        addObject(squares13,544,259);
        squares13.setLocation(524,255);
        Squares squares14 = new Squares();
        addObject(squares14,523,309);
        squares14.setLocation(536,300);
        Squares squares15 = new Squares();
        addObject(squares15,633,380);
        squares15.setLocation(637,372);
        Squares squares16 = new Squares();
        addObject(squares16,532,366);
        squares16.setLocation(538,373);
        Squares squares17 = new Squares();
        addObject(squares17,366,376);
        squares17.setLocation(379,375);
        Squares squares18 = new Squares();
        addObject(squares18,394,320);
        squares18.setLocation(374,293);
        Squares squares19 = new Squares();
        addObject(squares19,444,289);
        squares19.setLocation(441,304);
        Squares squares20 = new Squares();
        addObject(squares20,282,90);
        squares20.setLocation(297,90);
        squares3.setLocation(296,158);
        Squares squares21 = new Squares();
        addObject(squares21,301,32);
        squares21.setLocation(298,32);
        Squares squares22 = new Squares();
        addObject(squares22,136,41);
        squares22.setLocation(138,39);
        Squares squares23 = new Squares();
        addObject(squares23,28,30);
        squares23.setLocation(40,39);
        Squares squares24 = new Squares();
        addObject(squares24,295,359);
        squares24.setLocation(294,374);
        Squares squares25 = new Squares();
        addObject(squares25,285,295);
        squares25.setLocation(296,294);
        squares17.setLocation(376,375);
        Squares squares26 = new Squares();
        addObject(squares26,144,371);
        squares26.setLocation(133,375);
        Squares squares27 = new Squares();
        addObject(squares27,25,367);
        squares27.setLocation(40,369);
        Squares squares28 = new Squares();
        addObject(squares28,27,251);
        squares28.setLocation(39,258);
        Squares squares29 = new Squares();
        addObject(squares29,35,138);
        Squares squares30 = new Squares();
        addObject(squares30,137,95);
        Squares squares31 = new Squares();
        addObject(squares31,126,144);
        Squares squares32 = new Squares();
        addObject(squares32,135,259);
        Squares squares33 = new Squares();
        addObject(squares33,236,167);

        squares33.setLocation(232,158);
        squares21.setLocation(298,39);
        squares5.setLocation(377,36);
        squares4.setLocation(376,93);
        squares20.setLocation(296,97);
        squares3.setLocation(297,156);
        squares2.setLocation(378,156);
        squares12.setLocation(440,157);
        squares13.setLocation(537,255);
        squares14.setLocation(535,303);
        squares11.setLocation(535,152);
        squares13.setLocation(534,253);
        squares8.setLocation(535,95);
        squares6.setLocation(533,35);
        squares7.setLocation(639,34);
        squares9.setLocation(639,144);
        squares10.setLocation(640,260);
        squares15.setLocation(638,373);
        squares27.setLocation(38,375);
        squares26.setLocation(137,375);
        squares30.setLocation(137,95);
        squares31.setLocation(138,151);
        squares32.setLocation(136,257);
        Squares squares34 = new Squares();
        addObject(squares34,226,307);
        squares19.setLocation(441,299);
        squares18.setLocation(380,294);
        squares34.setLocation(235,299);
        Squares squares35 = new Squares();
        addObject(squares35,145,299);
        squares35.setLocation(136,300);
        squares29.setLocation(39,145);

        YellowDots yellowdots = new YellowDots();
        addObject(yellowdots,610,142);
        YellowDots yellowdots2 = new YellowDots();
        addObject(yellowdots2,594,145);
        YellowDots yellowdots3 = new YellowDots();
        addObject(yellowdots3,564,145);
        yellowdots3.setLocation(567,143);
        yellowdots2.setLocation(586,144);
        yellowdots.setLocation(605,143);
        yellowdots2.setLocation(586,143);
        YellowDots yellowdots4 = new YellowDots();
        addObject(yellowdots4,609,261);
        YellowDots yellowdots5 = new YellowDots();
        addObject(yellowdots5,591,262);
        YellowDots yellowdots6 = new YellowDots();
        addObject(yellowdots6,568,263);
        yellowdots5.setLocation(587,260);
        yellowdots6.setLocation(567,258);
        yellowdots6.setLocation(566,261);
        yellowdots5.setLocation(587,261);
        YellowDots yellowdots7 = new YellowDots();
        addObject(yellowdots7,67,261);
        yellowdots7.setLocation(67,256);
        YellowDots yellowdots8 = new YellowDots();
        addObject(yellowdots8,92,259);
        yellowdots8.setLocation(85,256);
        YellowDots yellowdots9 = new YellowDots();
        addObject(yellowdots9,108,261);
        yellowdots9.setLocation(105,256);
        YellowDots yellowdots10 = new YellowDots();
        addObject(yellowdots10,69,144);
        yellowdots10.setLocation(62,141);
        YellowDots yellowdots11 = new YellowDots();
        addObject(yellowdots11,87,146);
        yellowdots11.setLocation(82,142);
        YellowDots yellowdots12 = new YellowDots();
        addObject(yellowdots12,106,147);
        yellowdots12.setLocation(103,141);
        yellowdots11.setLocation(84,141);
        YellowDots yellowdots13 = new YellowDots();
        addObject(yellowdots13,536,67);
        YellowDots yellowdots14 = new YellowDots();
        addObject(yellowdots14,536,97);
        YellowDots yellowdots15 = new YellowDots();
        addObject(yellowdots15,539,124);
        YellowDots yellowdots16 = new YellowDots();
        addObject(yellowdots16,541,156);
        yellowdots16.setLocation(541,153);
        yellowdots13.setLocation(535,60);
        yellowdots14.setLocation(534,83);
        yellowdots15.setLocation(536,112);
        yellowdots14.setLocation(535,85);
        yellowdots15.setLocation(535,112);
        yellowdots16.setLocation(537,140);
        YellowDots yellowdots17 = new YellowDots();
        addObject(yellowdots17,541,171);
        yellowdots17.setLocation(536,169);
        YellowDots yellowdots18 = new YellowDots();
        addObject(yellowdots18,536,211);
        yellowdots18.setLocation(536,198);
        YellowDots yellowdots19 = new YellowDots();
        addObject(yellowdots19,540,237);
        yellowdots19.setLocation(536,222);
        YellowDots yellowdots20 = new YellowDots();
        addObject(yellowdots20,536,349);
        YellowDots yellowdots21 = new YellowDots();
        addObject(yellowdots21,538,327);
        yellowdots21.setLocation(534,322);
        YellowDots yellowdots22 = new YellowDots();
        addObject(yellowdots22,535,300);
        yellowdots22.setLocation(533,298);
        YellowDots yellowdots23 = new YellowDots();
        addObject(yellowdots23,534,273);
        YellowDots yellowdots24 = new YellowDots();
        addObject(yellowdots24,538,249);
        yellowdots23.setLocation(536,270);
        yellowdots22.setLocation(535,296);
        YellowDots yellowdots25 = new YellowDots();
        addObject(yellowdots25,381,70);
        yellowdots25.setLocation(376,60);
        YellowDots yellowdots26 = new YellowDots();
        addObject(yellowdots26,393,102);
        YellowDots yellowdots27 = new YellowDots();
        addObject(yellowdots27,383,96);
        YellowDots yellowdots28 = new YellowDots();
        addObject(yellowdots28,395,141);
        YellowDots yellowdots29 = new YellowDots();
        addObject(yellowdots29,382,129);
        yellowdots27.setLocation(376,82);
        yellowdots26.setLocation(376,102);
        yellowdots25.setLocation(374,57);
        yellowdots29.setLocation(376,128);
        yellowdots25.setLocation(376,56);
        yellowdots28.setLocation(378,152);
        yellowdots28.setLocation(376,152);
        YellowDots yellowdots30 = new YellowDots();
        addObject(yellowdots30,411,99);
        YellowDots yellowdots31 = new YellowDots();
        addObject(yellowdots31,465,96);
        YellowDots yellowdots32 = new YellowDots();
        addObject(yellowdots32,440,96);
        YellowDots yellowdots33 = new YellowDots();
        addObject(yellowdots33,484,100);
        YellowDots yellowdots34 = new YellowDots();
        addObject(yellowdots34,517,97);
        yellowdots34.setLocation(511,98);
        yellowdots33.setLocation(490,97);
        yellowdots31.setLocation(465,99);
        yellowdots33.setLocation(490,99);
        yellowdots32.setLocation(439,97);
        yellowdots31.setLocation(463,97);
        yellowdots33.setLocation(487,97);
        yellowdots30.setLocation(411,96);
        yellowdots34.setLocation(511,97);
        YellowDots yellowdots35 = new YellowDots();
        addObject(yellowdots35,388,354);
        yellowdots35.setLocation(378,355);
        YellowDots yellowdots36 = new YellowDots();
        addObject(yellowdots36,395,327);
        yellowdots36.setLocation(376,331);
        yellowdots36.setLocation(379,331);
        YellowDots yellowdots37 = new YellowDots();
        addObject(yellowdots37,519,165);
        yellowdots37.setLocation(512,157);
        YellowDots yellowdots38 = new YellowDots();
        addObject(yellowdots38,487,158);
        yellowdots38.setLocation(489,157);
        YellowDots yellowdots39 = new YellowDots();
        addObject(yellowdots39,474,165);
        yellowdots39.setLocation(466,156);
        YellowDots yellowdots40 = new YellowDots();
        addObject(yellowdots40,443,160);
        yellowdots40.setLocation(441,158);
        yellowdots39.setLocation(466,157);
        YellowDots yellowdots41 = new YellowDots();
        addObject(yellowdots41,301,71);
        yellowdots41.setLocation(297,60);
        YellowDots yellowdots42 = new YellowDots();
        addObject(yellowdots42,313,96);
        yellowdots42.setLocation(298,83);
        YellowDots yellowdots43 = new YellowDots();
        addObject(yellowdots43,317,116);
        yellowdots43.setLocation(297,104);
        YellowDots yellowdots44 = new YellowDots();
        addObject(yellowdots44,320,130);
        yellowdots44.setLocation(297,127);
        YellowDots yellowdots45 = new YellowDots();
        addObject(yellowdots45,316,165);
        yellowdots45.setLocation(297,152);
        YellowDots yellowdots46 = new YellowDots();
        addObject(yellowdots46,335,162);
        yellowdots46.setLocation(321,152);
        YellowDots yellowdots47 = new YellowDots();
        addObject(yellowdots47,367,156);
        yellowdots47.setLocation(349,152);
        YellowDots yellowdots48 = new YellowDots();
        addObject(yellowdots48,250,102);
        yellowdots48.setLocation(264,92);
        YellowDots yellowdots49 = new YellowDots();
        addObject(yellowdots49,249,104);
        yellowdots49.setLocation(239,91);
        YellowDots yellowdots50 = new YellowDots();
        addObject(yellowdots50,212,110);
        yellowdots50.setLocation(212,91);
        yellowdots49.setLocation(238,93);
        yellowdots50.setLocation(213,92);
        YellowDots yellowdots51 = new YellowDots();
        addObject(yellowdots51,190,98);
        yellowdots51.setLocation(190,92);
        YellowDots yellowdots52 = new YellowDots();
        addObject(yellowdots52,161,98);
        yellowdots52.setLocation(167,91);
        YellowDots yellowdots53 = new YellowDots();
        addObject(yellowdots53,138,97);
        yellowdots53.setLocation(140,91);
        YellowDots yellowdots54 = new YellowDots();
        addObject(yellowdots54,144,77);
        yellowdots54.setLocation(141,72);
        YellowDots yellowdots55 = new YellowDots();
        addObject(yellowdots55,155,53);
        yellowdots55.setLocation(139,51);
        yellowdots54.setLocation(138,72);
        yellowdots54.setLocation(140,72);
        yellowdots54.setLocation(139,71);
        YellowDots yellowdots56 = new YellowDots();
        addObject(yellowdots56,152,130);
        yellowdots56.setLocation(139,114);
        YellowDots yellowdots57 = new YellowDots();
        addObject(yellowdots57,147,149);
        yellowdots57.setLocation(125,143);
        YellowDots yellowdots58 = new YellowDots();
        addObject(yellowdots58,143,151);
        yellowdots58.setLocation(145,141);
        yellowdots58.setLocation(138,180);
        yellowdots57.setLocation(138,142);
        yellowdots55.setLocation(136,51);
        yellowdots54.setLocation(136,72);
        yellowdots53.setLocation(136,91);
        yellowdots56.setLocation(135,114);
        yellowdots57.setLocation(134,145);
        yellowdots58.setLocation(134,170);
        YellowDots yellowdots59 = new YellowDots();
        addObject(yellowdots59,156,224);
        yellowdots59.setLocation(134,193);
        YellowDots yellowdots60 = new YellowDots();
        addObject(yellowdots60,169,239);
        yellowdots60.setLocation(134,216);
        YellowDots yellowdots61 = new YellowDots();
        addObject(yellowdots61,128,253);
        yellowdots61.setLocation(133,239);
        YellowDots yellowdots62 = new YellowDots();
        addObject(yellowdots62,156,281);
        yellowdots62.setLocation(133,266);
        YellowDots yellowdots63 = new YellowDots();
        addObject(yellowdots63,140,312);
        yellowdots63.setLocation(134,298);
        YellowDots yellowdots64 = new YellowDots();
        addObject(yellowdots64,148,344);
        yellowdots64.setLocation(135,326);
        YellowDots yellowdots65 = new YellowDots();
        addObject(yellowdots65,156,362);
        yellowdots65.setLocation(136,355);
        YellowDots yellowdots66 = new YellowDots();
        addObject(yellowdots66,306,351);
        yellowdots66.setLocation(298,354);
        YellowDots yellowdots67 = new YellowDots();
        addObject(yellowdots67,299,333);
        yellowdots67.setLocation(296,330);
        yellowdots36.setLocation(377,330);
        yellowdots67.setLocation(298,329);
        YellowDots yellowdots68 = new YellowDots();
        addObject(yellowdots68,178,161);
        yellowdots68.setLocation(270,152);
        YellowDots yellowdots69 = new YellowDots();
        addObject(yellowdots69,244,155);
        yellowdots69.setLocation(241,154);
        YellowDots yellowdots70 = new YellowDots();
        addObject(yellowdots70,222,160);
        yellowdots70.setLocation(217,155);
        YellowDots yellowdots71 = new YellowDots();
        addObject(yellowdots71,202,159);
        yellowdots71.setLocation(193,156);
        YellowDots yellowdots72 = new YellowDots();
        addObject(yellowdots72,188,159);
        yellowdots72.setLocation(166,155);
        YellowDots yellowdots73 = new YellowDots();
        addObject(yellowdots73,413,160);
        yellowdots73.setLocation(409,158);
        YellowDots yellowdots74 = new YellowDots();
        addObject(yellowdots74,444,189);
        yellowdots74.setLocation(439,189);
        YellowDots yellowdots75 = new YellowDots();
        addObject(yellowdots75,449,242);
        yellowdots75.setLocation(438,215);
        yellowdots74.setLocation(439,185);
        yellowdots75.setLocation(441,210);
        YellowDots yellowdots76 = new YellowDots();
        addObject(yellowdots76,449,257);
        yellowdots76.setLocation(439,235);
        YellowDots yellowdots77 = new YellowDots();
        addObject(yellowdots77,430,286);
        yellowdots77.setLocation(440,258);
        yellowdots76.setLocation(441,235);
        yellowdots74.setLocation(442,183);
        yellowdots77.setLocation(441,260);
        YellowDots yellowdots78 = new YellowDots();
        addObject(yellowdots78,456,307);
        yellowdots78.setLocation(441,285);
        YellowDots yellowdots79 = new YellowDots();
        addObject(yellowdots79,449,317);
        yellowdots79.setLocation(441,309);
        YellowDots yellowdots80 = new YellowDots();
        addObject(yellowdots80,517,317);
        yellowdots80.setLocation(511,308);
        YellowDots yellowdots81 = new YellowDots();
        addObject(yellowdots81,488,317);
        yellowdots81.setLocation(493,308);
        YellowDots yellowdots82 = new YellowDots();
        addObject(yellowdots82,477,321);
        yellowdots82.setLocation(462,308);
        YellowDots yellowdots83 = new YellowDots();
        addObject(yellowdots83,415,302);
        YellowDots yellowdots84 = new YellowDots();
        addObject(yellowdots84,401,303);
        yellowdots84.setLocation(377,303);
        YellowDots yellowdots85 = new YellowDots();
        addObject(yellowdots85,407,313);
        yellowdots85.setLocation(398,304);
        yellowdots83.setLocation(420,307);
        yellowdots85.setLocation(397,311);
        yellowdots83.setLocation(419,308);
        yellowdots85.setLocation(397,309);
        yellowdots81.setLocation(488,310);
        yellowdots84.setLocation(376,306);
        yellowdots84.setLocation(378,309);
        YellowDots yellowdots86 = new YellowDots();
        addObject(yellowdots86,238,196);
        yellowdots86.setLocation(232,179);
        YellowDots yellowdots87 = new YellowDots();
        addObject(yellowdots87,243,233);
        yellowdots87.setLocation(232,204);
        YellowDots yellowdots88 = new YellowDots();
        addObject(yellowdots88,236,251);
        yellowdots88.setLocation(231,229);
        YellowDots yellowdots89 = new YellowDots();
        addObject(yellowdots89,245,274);
        yellowdots89.setLocation(233,257);
        yellowdots88.setLocation(232,229);
        yellowdots89.setLocation(233,253);
        YellowDots yellowdots90 = new YellowDots();
        addObject(yellowdots90,253,297);
        yellowdots90.setLocation(234,277);
        YellowDots yellowdots91 = new YellowDots();
        addObject(yellowdots91,246,317);
        yellowdots91.setLocation(237,312);
        yellowdots91.setLocation(234,312);
        YellowDots yellowdots92 = new YellowDots();
        addObject(yellowdots92,246,306);
        yellowdots92.setLocation(234,294);
        YellowDots yellowdots93 = new YellowDots();
        addObject(yellowdots93,266,303);
        yellowdots93.setLocation(252,305);
        YellowDots yellowdots94 = new YellowDots();
        addObject(yellowdots94,283,311);
        yellowdots94.setLocation(273,306);
        YellowDots yellowdots95 = new YellowDots();
        addObject(yellowdots95,299,318);
        yellowdots95.setLocation(294,307);
        yellowdots95.setLocation(295,307);
        yellowdots93.setLocation(253,310);
        yellowdots94.setLocation(274,310);
        yellowdots95.setLocation(295,311);
        YellowDots yellowdots96 = new YellowDots();
        addObject(yellowdots96,217,311);
        yellowdots96.setLocation(215,312);
        YellowDots yellowdots97 = new YellowDots();
        addObject(yellowdots97,189,312);
        yellowdots97.setLocation(194,312);
        YellowDots yellowdots98 = new YellowDots();
        addObject(yellowdots98,197,313);
        yellowdots98.setLocation(175,313);
        YellowDots yellowdots99 = new YellowDots();
        addObject(yellowdots99,159,316);
        yellowdots99.setLocation(153,313);

        Pearl pearl2 = new Pearl();
        addObject(pearl2,337,155);
    }
    
    
    public int getPacX()
    {
        return pacX;
    }
    
    public int getPacY()
    {
        return pacY;
    }
    
    public void setPacX(int x)
    {
        this.pacX = x;
    }
    
    public void setPacY(int y)
    {
        this.pacY = y;
    }
    
    public int getGhostRedX()
    {
        return ghostRedX;
    }
    
    public int getGhostRedY()
    {
        return ghostRedY;
    }
    
    public void setGhostRedX(int x)
    {
        this.ghostRedX = x;
    }
    
    public void setGhostRedY(int y)
    {
        this.ghostRedY = y;
    }
    
    
    
    public int getGhostPinkX()
    {
        return ghostPinkX;
    }
    
    public int getGhostPinkY()
    {
        return ghostPinkY;
    }
    
    public void setGhostPinkX(int x)
    {
        this.ghostPinkX = x;
    }
    
    public void setGhostPinkY(int y)
    {
        this.ghostPinkY = y;
    }
    
    
    public int getGhostLightBlueX()
    {
        return ghostLightBlueX;
    }
    
    public int getGhostLightBlueY()
    {
        return ghostLightBlueY;
    }
    
    public void setGhostLightBlueX(int x)
    {
        this.ghostLightBlueX = x;
    }
    
    public void setGhostLightBlueY(int y)
    {
        this.ghostLightBlueY = y;
    }
    
    
    public int getGhostYellowX()
    {
        return ghostYellowX;
    }
    
    public int getGhostYellowY()
    {
        return ghostYellowY;
    }
    
    public void setGhostYellowX(int x)
    {
        this.ghostYellowX = x;
    }
    
    public void setGhostYellowY(int y)
    {
        this.ghostYellowY = y;
    }
    
    
    
    public int getBlueGX()
    {
        return blueGX;
    }
    
    public int getBlueGY()
    {
        return blueGY;
    }
    
    public void setBlueCX(int x)
    {
        //this.ghostCX = x;
    }
    
    public void setBlueCY(int y)
    {
        //this.ghostCY = y;
    }
    
    public int getSquareX()
    {
        return squareX;
    }
    
    public int getSquareY()
    {
        return squareY;
    }
    
    public void setSquareX(int x)
    {
        this.squareX = x;
    }
    
    public void setSquareY(int y)
    {
        this.squareY = y;
    }
    
    public boolean isPearl()
    {
        return pearl;
    }
    
    public void setPearl(boolean yay)
    {
        pearl = yay;
    }
    
    public int getPearlCount()
    {
        return pearlCount;
    }
    
    public void setPearlCount(int p)
    {
        this.pearlCount = p;
    }
    
    public int RedR()
    {
        return RedR;
    }
    
    public void setRedR(int r)
    {
        this.RedR = r;
    }
    
    public int YellowR()
    {
        return YellowR;
    }
    
    public void setYellowR(int r)
    {
        this.YellowR = r;
    }
    
    public int PinkR()
    {
        return PinkR;
    }
    
    public void setPinkR(int r)
    {
        this.PinkR = r;
    }
    
    public int LightBlueR()
    {
        return LightBlueR;
    }
    
    public void setLightBlueR(int r)
    {
        this.LightBlueR = r;
    }
    
    public int BlueGR()
    {
        return BlueGR;
    }
    
    public void setBlueGR(int r)
    {
        this.BlueGR = r;
    }
    
    public void setRed(int red)
    {
        this.red = red;
    }
    
    public void setPink(int red)
    {
        this.pink = red;
    }
    
    public void setYellow(int red)
    {
        this.yellow = red;
    }
    
    public void setLightBlue(int red)
    {
        this.lightBlue = red;
    }
    
    public boolean turnBlueR()
    {
        return turnBlueR;
    }
    
    public void setTurnBlueR(boolean blue)
    {
        this.turnBlueR = blue;
    }
    
    public boolean turnBlueP()
    {
        return turnBlueP;
    }
    
    public void setTurnBlueP(boolean blue)
    {
        this.turnBlueP = blue;
    }
    
    public boolean turnBlueY()
    {
        return turnBlueY;
    }
    
    public void setTurnBlueY(boolean blue)
    {
        this.turnBlueY = blue;
    }
    
    public boolean turnBlueLB()
    {
        return turnBlueLB;
    }
    
    public void setTurnBlueLB(boolean blue)
    {
        this.turnBlueLB = blue;
    }
    
    public boolean touchingRed()
    {
        return touchingRed;
    }
    
    public void setTouchingRed(boolean x)
    {
        this.touchingRed = x;
    }
    
    public boolean touchingPink()
    {
        return touchingPink;
    }
    
    public void setTouchingPink(boolean x)
    {
        this.touchingPink = x;
    }
    
    public boolean touchingYellow()
    {
        return touchingYellow;
    }
    
    public void setTouchingYellow(boolean x)
    {
        this.touchingYellow = x;
    }
    
    public boolean touchingLightBlue()
    {
        return touchingLightBlue;
    }
    
    public void setTouchingLightBlue(boolean x)
    {
        this.touchingLightBlue = x;
    }
    
    public int score()
    {
        return score;
    }
    
    public void setScore(int score)
    {
        this.score = score;
    }
    
    public void numYellowDots(int x)
    {
        this.numYellowDots -= x;
    }
}







