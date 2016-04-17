import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    GreenfootImage human1 = new GreenfootImage("human1.png");
    GreenfootImage flippedHuman1;
    GreenfootImage hTransforming1 = new GreenfootImage("humanTransforming1.png");
    GreenfootImage hTransforming2 = new GreenfootImage("humanTransforming2.png");
    GreenfootImage hTransforming3 = new GreenfootImage("humanTransforming3.png");
    GreenfootImage middleTransforming = new GreenfootImage("middleTransforming.png");
    
    GreenfootImage bird1 = new GreenfootImage("bird1.png");
    GreenfootImage flippedBird1;
    GreenfootImage bTransforming1 = new GreenfootImage("birdTransforming1.png");
    GreenfootImage bTransforming2 = new GreenfootImage("birdTransforming2.png");
    GreenfootImage bTransforming3 = new GreenfootImage("birdTransforming3.png");
    
    GreenfootImage rhino1 = new GreenfootImage("rhino1.png");
    GreenfootImage flippedRhino1;
    GreenfootImage rTransforming1 = new GreenfootImage("rhinoTransforming1.png");
    GreenfootImage rTransforming2 = new GreenfootImage("rhinoTransforming2.png");
    GreenfootImage rTransforming3 = new GreenfootImage("rhinoTransforming3.png");
    
    GreenfootImage penguin1 = new GreenfootImage("penguin1.png");
    GreenfootImage flippedPenguin1;
    GreenfootImage pTransforming1 = new GreenfootImage("penguinTransforming1.png");
    GreenfootImage pTransforming2 = new GreenfootImage("penguinTransforming2.png");
    GreenfootImage pTransforming3 = new GreenfootImage("penguinTransforming3.png");
    
    GreenfootImage cat1 = new GreenfootImage("cat1.png");
    GreenfootImage flippedCat1;
    GreenfootImage cTransforming1 = new GreenfootImage("catTransforming1.png");
    GreenfootImage cTransforming2 = new GreenfootImage("catTransforming2.png");
    GreenfootImage cTransforming3 = new GreenfootImage("catTransforming3.png");
    
    
    private int transformTimer = 0;
    private boolean previouslyTransformed = false;  
    private String newForm = "";    
    private String form = "human";
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isTouching(Bacon.class))
        {
            getWorld().addObject(new youWin(), 384, 384);
        }
        if(form == "human")
        {
            checkTransform();
            if(newForm == "bird")
            {
                humanToBirdAct();
            }
            if(newForm == "rhino")
            {
                humanToRhinoAct();
            }
            if(newForm == "penguin")
            {
                humanToPenguinAct();
            }
            if(newForm == "cat")
            {
                humanToCatAct();
            }
            if(newForm == "")
            {
                humanAct();
            }
        }
        else if(form == "bird")
        {
            birdAct();
        }
        else if(form == "rhino")
        {
            rhinoAct();
        }
        else if(form == "penguin")
        {
            penguinAct();
        }
        else
        {
            catAct();
        }
    }
    public void checkTransform()
    {
        if(newForm == "")
        {
            if(Greenfoot.isKeyDown("z") && form != "bird")
            {
                newForm = "bird";
            }
            else if(Greenfoot.isKeyDown("x") && form != "rhino")
            {
                newForm = "rhino";
            }
            else if(Greenfoot.isKeyDown("c") && form != "penguin")
            {
                newForm = "penguin";
            }
            else if(Greenfoot.isKeyDown("v") && form != "cat")
            {
                newForm = "cat";
            }
        }
        
        if(!(Greenfoot.isKeyDown("z") || Greenfoot.isKeyDown("x") || Greenfoot.isKeyDown ("c") || Greenfoot.isKeyDown("v")))
        {
            newForm = "";
            previouslyTransformed = false;
            transformTimer = 0;
            setImage(human1);
        }
    }
    private int humanVelocity = 0;
    private int humanAcceleration = 1;
    public void humanAct()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 2, getY());
            setImage(flippedHuman1);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 2, getY());
            setImage(human1);
        }
        Actor block = getOneObjectAtOffset(0, -humanVelocity + getImage().getHeight() / 2, Block.class);
        if(block != null && humanVelocity <= 0)
        {
            int newY = block.getY() - block.getImage().getHeight() / 2 - getImage().getHeight() / 2;
            setLocation(getX(), newY);
        }
        else
        {
            setLocation(getX(), getY() - humanVelocity);
            humanVelocity -= humanAcceleration;
        }     
        
        if(isTouching(Bullet.class))
        {
            destroy();
        }
    }
    public void humanToBirdAct()
    {
        if(Greenfoot.isKeyDown("z") && previouslyTransformed == false)
        {
            transformTimer++;
            if(transformTimer == 10)
            {
                setImage(hTransforming1);
            }
            else if(transformTimer == 20)
            {
                setImage(hTransforming2);
            }
            else if(transformTimer == 30)
            {
                setImage(hTransforming3);
            }
            else if(transformTimer == 40)
            {
                setImage(middleTransforming);
            }
            else if(transformTimer == 50)
            {
                setImage(bTransforming1);
            }            
            else if(transformTimer == 60)
            {
                setImage(bTransforming2);
            }
            else if(transformTimer == 70)
            {
                setImage(bTransforming3);
            }
            //transformation completed
            else if(transformTimer == 80)
            {
                setImage(bird1);
                form = "bird";
                transformTimer = 0;
                previouslyTransformed = true;
            }
        }
        //cancel
        else if(transformTimer > 0)
        {
            transformTimer = 0;
            setImage(human1);
        }
        
        if(!Greenfoot.isKeyDown("z"))
        {
            previouslyTransformed = false;
        }
    }
    public void humanToRhinoAct()
    {
        if(Greenfoot.isKeyDown("x") && previouslyTransformed == false)
        {
            transformTimer++;
            if(transformTimer == 10)
            {
                setImage(hTransforming1);
            }
            else if(transformTimer == 20)
            {
                setImage(hTransforming2);
            }
            else if(transformTimer == 30)
            {
                setImage(hTransforming3);
            }
            else if(transformTimer == 40)
            {
                setImage(middleTransforming);
            }
            else if(transformTimer == 50)
            {
                setImage(rTransforming1);
            }            
            else if(transformTimer == 60)
            {
                setImage(rTransforming2);
            }
            else if(transformTimer == 70)
            {
                setImage(rTransforming3);
            }
            //transformation completed
            else if(transformTimer == 80)
            {
                setImage(rhino1);
                form = "rhino";
                transformTimer = 0;
                previouslyTransformed = true;
            }
        }
        //cancel
        else if(transformTimer > 0)
        {
            transformTimer = 0;
            setImage(human1);
        }
        
        if(!Greenfoot.isKeyDown("x"))
        {
            previouslyTransformed = false;
        }
    }
    public void humanToPenguinAct()
    {
        if(Greenfoot.isKeyDown("c") && previouslyTransformed == false)
        {
            transformTimer++;
            if(transformTimer == 10)
            {
                setImage(hTransforming1);
            }
            else if(transformTimer == 20)
            {
                setImage(hTransforming2);
            }
            else if(transformTimer == 30)
            {
                setImage(hTransforming3);
            }
            else if(transformTimer == 40)
            {
                setImage(middleTransforming);
            }
            else if(transformTimer == 50)
            {
                setImage(pTransforming1);
            }            
            else if(transformTimer == 60)
            {
                setImage(pTransforming2);
            }
            else if(transformTimer == 70)
            {
                setImage(pTransforming3);
            }
            //transformation completed
            else if(transformTimer == 80)
            {
                setImage(penguin1);
                form = "penguin";
                transformTimer = 0;
                previouslyTransformed = true;
            }
        }
        //cancel
        else if(transformTimer > 0)
        {
            transformTimer = 0;
            setImage(human1);
        }
        
        if(!Greenfoot.isKeyDown("c"))
        {
            previouslyTransformed = false;
        }
    }
    public void humanToCatAct()
    {
        if(Greenfoot.isKeyDown("v") && previouslyTransformed == false)
        {
            transformTimer++;
            if(transformTimer == 10)
            {
                setImage(hTransforming1);
            }
            else if(transformTimer == 20)
            {
                setImage(hTransforming2);
            }
            else if(transformTimer == 30)
            {
                setImage(hTransforming3);
            }
            else if(transformTimer == 40)
            {
                setImage(middleTransforming);
            }
            else if(transformTimer == 50)
            {
                setImage(cTransforming1);
            }            
            else if(transformTimer == 60)
            {
                setImage(cTransforming2);
            }
            else if(transformTimer == 70)
            {
                setImage(cTransforming3);
            }
            //transformation completed
            else if(transformTimer == 80)
            {
                setImage(cat1);
                form = "cat";
                transformTimer = 0;
                previouslyTransformed = true;
            }
        }
        //cancel
        else if(transformTimer > 0)
        {
            transformTimer = 0;
            setImage(human1);
        }
        
        if(!Greenfoot.isKeyDown("v"))
        {
            previouslyTransformed = false;
        }
    }
    private int birdVelocity = 5;
    private int birdAcceleration = 1;
    private boolean birdJustJumped = false;
    
    public void birdAct()
    {
        if(!(Greenfoot.isKeyDown("z") || Greenfoot.isKeyDown("x") || Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("v")))
        {
            if(Greenfoot.isKeyDown("up") & birdJustJumped == false)
            {
                birdVelocity = 12;
                birdJustJumped = true;
            }
            if(!Greenfoot.isKeyDown("up"))
            {
                birdJustJumped = false;
            }        
            if(Greenfoot.isKeyDown("left"))
            {
                setLocation(getX() - 3, getY());
                setImage(flippedBird1);
            }
            if(Greenfoot.isKeyDown("right"))
            {
                setLocation(getX() + 3, getY());
                setImage(bird1);
            }
        }
        Actor block = getOneObjectAtOffset(0, -birdVelocity + getImage().getHeight() / 2, Block.class);
        if(block != null && birdVelocity <= 0)
        {
            int newY = block.getY() - block.getImage().getHeight() / 2 - getImage().getHeight() / 2;
            setLocation(getX(), newY);
            birdVelocity = 0;
        }
        else
        {
            setLocation(getX(), getY() - birdVelocity);
            birdVelocity -= birdAcceleration;
        }     
        if((Greenfoot.isKeyDown("z") || Greenfoot.isKeyDown("x") || Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("v")) && previouslyTransformed == false)
        {
            transformTimer++;
            if(transformTimer == 10)
            {
                setImage(bTransforming3);
            }
            else if(transformTimer == 20)
            {
                setImage(bTransforming2);
            }
            else if(transformTimer == 30)
            {
                setImage(bTransforming1);
            }
            else if(transformTimer == 40)
            {
                setImage(middleTransforming);
            }
            else if(transformTimer == 50)
            {
                setImage(hTransforming3);
            }            
            else if(transformTimer == 60)
            {
                setImage(hTransforming2);
            }
            else if(transformTimer == 70)
            {
                setImage(hTransforming1);
            }
            //transformation completed
            else if(transformTimer == 80)
            {
                setImage(human1);
                form = "human";
                transformTimer = 0;
                previouslyTransformed = true;
            }
        }
        //cancel
        else if(transformTimer > 0)
        {
            transformTimer = 0;
            setImage(bird1);
        }
        
        if(!(Greenfoot.isKeyDown("z") || (Greenfoot.isKeyDown("x")) || (Greenfoot.isKeyDown("c")) || (Greenfoot.isKeyDown("v"))))
        {
            previouslyTransformed = false;
        }
        
        if(isTouching(Bullet.class))
        {
            destroy();
        }
    }
    private int leftAcceleration = 0;
    private int rightAcceleration = 0;
    private int rhinoMovingTimer = 0;
    private int rhinoVelocity = 0;
    private int rhinoAcceleration = 1;
    public void rhinoAct()
    {
        if(isTouching(Hunter.class))
        {
            ((Hunter) getWorld().getObjects(Hunter.class).get(0)).destroy();
        }
        if(!(Greenfoot.isKeyDown("z") || Greenfoot.isKeyDown("x") || Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("v")))
        {
            if(rhinoMovingTimer == 3)
            {
                if(Greenfoot.isKeyDown("left")& !Greenfoot.isKeyDown("right"))
                {
                    leftAcceleration++;
                    setLocation(getX() - leftAcceleration, getY());
                    setImage(flippedRhino1);
                }
                else
                {
                    leftAcceleration = 0;
                }
                if(Greenfoot.isKeyDown("right") && !Greenfoot.isKeyDown("left"))
                {
                    rightAcceleration++;
                    setLocation(getX() + rightAcceleration, getY());
                    setImage(rhino1);
                }
                else
                {
                    rightAcceleration = 0;
                }
                rhinoMovingTimer = 0;
            }
            rhinoMovingTimer++;
        }
        Actor block = getOneObjectAtOffset(0, -rhinoVelocity + getImage().getHeight() / 2, Block.class);
        if(block != null)
        {
            int newY = block.getY() - block.getImage().getHeight() / 2 - getImage().getHeight() / 2;
            setLocation(getX(), newY);
            rhinoVelocity = 0;
        }
        else
        {
            setLocation(getX(), getY() - rhinoVelocity);
            rhinoVelocity -= rhinoAcceleration;
        }     
        if((Greenfoot.isKeyDown("z") || Greenfoot.isKeyDown("x") || Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("v")) && previouslyTransformed == false)
        {
            leftAcceleration = 0;
            rightAcceleration = 0;
            rhinoMovingTimer = 0;
            transformTimer++;
            if(transformTimer == 10)
            {
                setImage(rTransforming3);
            }
            else if(transformTimer == 20)
            {
                setImage(rTransforming2);
            }
            else if(transformTimer == 30)
            {
                setImage(rTransforming1);
            }
            else if(transformTimer == 40)
            {
                setImage(middleTransforming);
            }
            else if(transformTimer == 50)
            {
                setImage(hTransforming3);
            }            
            else if(transformTimer == 60)
            {
                setImage(hTransforming2);
            }
            else if(transformTimer == 70)
            {
                setImage(hTransforming1);
            }
            //transformation completed
            else if(transformTimer == 80)
            {
                setImage(human1);
                form = "human";
                transformTimer = 0;
                previouslyTransformed = true;
            }
        }
        //cancel
        else if(transformTimer > 0)
        {
            transformTimer = 0;
            setImage(rhino1);
        }
        
        if(!(Greenfoot.isKeyDown("z") || (Greenfoot.isKeyDown("x")) || (Greenfoot.isKeyDown("c")) || (Greenfoot.isKeyDown("v"))))
        {
            previouslyTransformed = false;
        }
    }    
    private int penguinLeftAcceleration = 2;
    private int penguinRightAcceleration = 2;
    private int penguinLeftVelocity = 2;
    private int penguinRightVelocity = 2;
    private int penguinLeftAccelerationCounter = 0;
    private int penguinRightAccelerationCounter = 0;
    private boolean alreadyFlipped = false;
    
    private int penguinVelocity = 0;
    private int penguinAcceleration = 1;
    public void penguinAct()
    {
        if(Greenfoot.isKeyDown("left") && !(Greenfoot.isKeyDown("z") || Greenfoot.isKeyDown("x") || Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("v")))
        {
            setLocation(getX() - penguinLeftVelocity, getY());
            penguinLeftVelocity = 2;
            penguinLeftAcceleration = 2;
            penguinLeftAccelerationCounter = 0;
            
            penguinRightAccelerationCounter = 0;
            penguinRightAcceleration = 0;
            
            setImage(flippedPenguin1);
        }
        else
        {
            setLocation(getX() - penguinLeftAcceleration, getY());
            penguinLeftAccelerationCounter++;
            if(penguinLeftAcceleration >= 0 && penguinLeftAccelerationCounter == 20)
            {
                penguinLeftAcceleration--;
                penguinLeftAccelerationCounter = 0;
            }
        }
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + penguinLeftVelocity, getY());
            penguinRightVelocity = 2;
            penguinRightAcceleration = 2;
            penguinRightAccelerationCounter = 0;
            
            penguinLeftAccelerationCounter = 0;
            penguinLeftAcceleration = 0;
            
            setImage(penguin1);
        }
        else
        {
            setLocation(getX() + penguinRightAcceleration, getY());
            penguinRightAccelerationCounter++;
            if(penguinRightAcceleration >= 0 && penguinRightAccelerationCounter == 20)
            {
                penguinRightAcceleration--;
                penguinRightAccelerationCounter = 0;
            }
        }
        Actor block = getOneObjectAtOffset(0, -penguinVelocity + getImage().getHeight() / 2, Block.class);
        if(block != null)
        {
            int newY = block.getY() - block.getImage().getHeight() / 2 - getImage().getHeight() / 2;
            setLocation(getX(), newY);
            penguinVelocity = 0;
        }
        else
        {
            setLocation(getX(), getY() - penguinVelocity);
            penguinVelocity -= penguinAcceleration;
        }    
        if((Greenfoot.isKeyDown("z") || Greenfoot.isKeyDown("x") || Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("v")) && previouslyTransformed == false)
        {
            transformTimer++;
            if(transformTimer == 10)
            {
                setImage(pTransforming3);
            }
            else if(transformTimer == 20)
            {
                setImage(pTransforming2);
            }
            else if(transformTimer == 30)
            {
                setImage(pTransforming1);
            }
            else if(transformTimer == 40)
            {
                setImage(middleTransforming);
            }
            else if(transformTimer == 50)
            {
                setImage(hTransforming3);
            }            
            else if(transformTimer == 60)
            {
                setImage(hTransforming2);
            }
            else if(transformTimer == 70)
            {
                setImage(hTransforming1);
            }
            //transformation completed
            else if(transformTimer == 80)
            {
                setImage(human1);
                form = "human";
                transformTimer = 0;
                previouslyTransformed = true;
            }
        }
        //cancel
        else if(transformTimer > 0)
        {
            transformTimer = 0;
            setImage(penguin1);
        }
        
        if(!(Greenfoot.isKeyDown("z") || (Greenfoot.isKeyDown("x")) || (Greenfoot.isKeyDown("c")) || (Greenfoot.isKeyDown("v"))))
        {
            previouslyTransformed = false;
        }
        
        if(isTouching(Bullet.class))
        {
            destroy();
        }
    }    
    private int catAcceleration = 1;
    private int catVelocity = 0;
    private boolean catAlreadyJumped = false;
    public void catAct()
    {
        if(!(Greenfoot.isKeyDown("z") || Greenfoot.isKeyDown("x") || Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("v")))
        {
            if(Greenfoot.isKeyDown("left"))
            {
                setLocation(getX() - 7, getY());
                setImage(flippedCat1);
            }
            else if(Greenfoot.isKeyDown("right"))
            {
                setLocation(getX() + 7, getY());
                setImage(cat1);
            }
            if(Greenfoot.isKeyDown("up") && catAlreadyJumped == false)
            {
                catVelocity = 20;
                catAlreadyJumped = true;
            }
        }
        Actor block = getOneObjectAtOffset(0, -catVelocity + getImage().getHeight() / 2, Block.class);
        if(block != null && catVelocity <= 0)
        {
            catAlreadyJumped = false;
            int newY = block.getY() - block.getImage().getHeight() / 2 - getImage().getHeight() / 2;
            setLocation(getX(), newY);
            catVelocity = 0;
        }
        else
        {
            setLocation(getX(), getY() - catVelocity);
            catVelocity -= catAcceleration;
        }
        if((Greenfoot.isKeyDown("z") || Greenfoot.isKeyDown("x") || Greenfoot.isKeyDown("c") || Greenfoot.isKeyDown("v")) && previouslyTransformed == false)
        {
            transformTimer++;
            if(transformTimer == 10)
            {
                setImage(cTransforming3);
            }
            else if(transformTimer == 20)
            {
                setImage(cTransforming2);
            }
            else if(transformTimer == 30)
            {
                setImage(cTransforming1);
            }
            else if(transformTimer == 40)
            {
                setImage(middleTransforming);
            }
            else if(transformTimer == 50)
            {
                setImage(hTransforming3);
            }            
            else if(transformTimer == 60)
            {
                setImage(hTransforming2);
            }
            else if(transformTimer == 70)
            {
                setImage(hTransforming1);
            }
            //transformation completed
            else if(transformTimer == 80)
            {
                setImage(human1);
                form = "human";
                transformTimer = 0;
                previouslyTransformed = true;
            }
        }
        //cancel
        else if(transformTimer > 0)
        {
            transformTimer = 0;
            setImage(cat1);
        }
        
        if(!(Greenfoot.isKeyDown("z") || (Greenfoot.isKeyDown("x")) || (Greenfoot.isKeyDown("c")) || (Greenfoot.isKeyDown("v"))))
        {
            previouslyTransformed = false;
        }
        
        if(isTouching(Bullet.class))
        {
            destroy();
        }
    }
    public void destroy()
    {
        getWorld().removeObject(this);
    }
    public void addedToWorld (World world)
    {
        human1.scale(human1.getHeight() * 6, human1.getWidth() * 6);
        hTransforming1.scale(hTransforming1.getHeight() * 6, hTransforming1.getWidth() * 6);
        hTransforming2.scale(hTransforming2.getHeight() * 6, hTransforming2.getWidth() * 6);
        hTransforming3.scale(hTransforming3.getHeight() * 6, hTransforming3.getWidth() * 6);
        middleTransforming.scale(middleTransforming.getHeight() * 6, middleTransforming.getWidth() * 6);
        flippedHuman1 = new GreenfootImage(human1);
        flippedHuman1.mirrorHorizontally();
        
        bird1.scale(bird1.getHeight() * 6, bird1.getWidth() * 6);
        bTransforming1.scale(bTransforming1.getHeight() * 6, bTransforming1.getWidth() * 6);
        bTransforming2.scale(bTransforming2.getHeight() * 6, bTransforming2.getWidth() * 6);
        bTransforming3.scale(bTransforming3.getHeight() * 6, bTransforming3.getWidth() * 6);
        flippedBird1 = new GreenfootImage(bird1);
        flippedBird1.mirrorHorizontally();
        
        rhino1.scale(rhino1.getHeight() * 12, rhino1.getWidth() * 3);
        rTransforming1.scale(rTransforming1.getHeight() * 12, rTransforming1.getWidth() * 3);
        rTransforming2.scale(rTransforming2.getHeight() * 12, rTransforming2.getWidth() * 3);
        rTransforming3.scale(rTransforming3.getHeight() * 12, rTransforming3.getWidth() * 3);   
        flippedRhino1 = new GreenfootImage(rhino1);
        flippedRhino1.mirrorHorizontally();
        
        penguin1.scale(penguin1.getHeight() * 6, penguin1.getWidth() * 6);
        pTransforming1.scale(pTransforming1.getHeight() * 6, pTransforming1.getWidth() * 6);
        pTransforming2.scale(pTransforming2.getHeight() * 6, pTransforming2.getWidth() * 6);
        pTransforming3.scale(pTransforming3.getHeight() * 6, pTransforming3.getWidth() * 6);       
        flippedPenguin1 = new GreenfootImage(penguin1);
        flippedPenguin1.mirrorHorizontally();
        
        cat1.scale(cat1.getHeight() * 6, cat1.getWidth() * 6);
        cTransforming1.scale(cTransforming1.getHeight() * 6, cTransforming1.getWidth() * 6);
        cTransforming2.scale(cTransforming2.getHeight() * 6, cTransforming2.getWidth() * 6);
        cTransforming3.scale(cTransforming3.getHeight() * 6, cTransforming3.getWidth() * 6);   
        flippedCat1 = new GreenfootImage(cat1);
        flippedCat1.mirrorHorizontally();
        
        setImage(human1);
    }
}
